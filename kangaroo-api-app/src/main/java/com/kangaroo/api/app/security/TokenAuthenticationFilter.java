package com.kangaroo.api.app.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import com.kangaroo.api.app.cache.TokenKey;
import com.kangaroo.api.app.security.CustomUserDetails;
import com.kangaroo.utils.redis.RedisHelper;

public class TokenAuthenticationFilter extends GenericFilterBean {
    public static final String HEADER_TOKEN = "token";
    private RedisHelper redisHelper;

    public TokenAuthenticationFilter(RedisHelper redisHelper) {
        this.redisHelper = redisHelper;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (verifyToken(httpRequest, httpResponse)) {
            chain.doFilter(request, response);
        }
    }

    private boolean verifyToken(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        String token = httpRequest.getHeader(HEADER_TOKEN);
        // 没token则继续执行过滤器
        if (StringUtils.isEmpty(token)) {
        	CustomUserDetails userDetails = new CustomUserDetails(null, "", "", new ArrayList<GrantedAuthority>());
    		Authentication securityToken = new PreAuthenticatedAuthenticationToken(userDetails, null,
    				userDetails.getAuthorities());
    		SecurityContextHolder.getContext().setAuthentication(securityToken);
            return true;
        }
        
        Long userid = redisHelper.opsForLong().get(token, TokenKey.TOKEN);
        if (userid==null) {
            return buildResponse(httpResponse, "账号已过期，请重新登录");
        }

        CustomUserDetails userDetails = new CustomUserDetails(userid, "", "", new ArrayList<GrantedAuthority>());
        Authentication securityToken = new PreAuthenticatedAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(securityToken);
        return true;
    }


    private boolean buildResponse(HttpServletResponse httpResponse, String msg) throws IOException {
        httpResponse.setStatus(HttpServletResponse.SC_OK);
        httpResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpResponse.getWriter()
                .write("{\"status\":205,\"msgCode\":" + "" + ",\"msg\":\"" + msg + "\"}");
        httpResponse.getWriter().flush();
        return false;
    }

}
