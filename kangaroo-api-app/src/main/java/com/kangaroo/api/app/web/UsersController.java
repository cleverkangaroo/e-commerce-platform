package com.kangaroo.api.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kangaroo.api.app.support.ApiResult;
import com.kangaroo.microservices.api.base.model.vo.UsersVO;
import com.kangaroo.microservices.api.base.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController("UsersController")
@Api(tags = {"用户"})
@RequestMapping("/user")
public class UsersController {

	@Autowired
    private UsersService usersService;
	
	    @ApiOperation(value = "获取用户信息", notes = "根据用户ID获取用户信息")
	    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	    public ApiResult getUserInfo(@ApiParam(value="用户ID",required=true) @RequestParam(value = "userId") Long userId)  {
	        UsersVO userInfo = usersService.getUserInfo(userId);
	    	return ApiResult.ok(userInfo);
	    }
}
