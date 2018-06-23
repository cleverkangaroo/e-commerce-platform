package com.kangaroo.microservices.provider.base.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kangaroo.microservices.api.base.model.vo.UsersVO;
import com.kangaroo.microservices.provider.base.model.entity.Users;
import com.kangaroo.microservices.provider.base.service.UsersService;
import com.kangaroo.utils.bean.BeanCastUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"用户"})
@RestController("UsersProvider")
@RequestMapping("/user")
public class UsersProvider {

	@Autowired
	private UsersService usersService;
	
	    @ApiOperation(value = "获取用户信息")
	    @GetMapping("/getUserInfo")
	    public ResponseEntity<?> getUserInfo(@RequestParam Long userId) {
	        Users users = usersService.selectByPrimaryKey(userId);
	        UsersVO vo = BeanCastUtil.castBean(users, UsersVO.class);
	        return ResponseEntity.ok(vo);
	    }
	    @ApiOperation(value = "根据登陆名及登陆类型，获取用户信息")
	    @GetMapping("/selectByUsernameAndDtype")
	    public ResponseEntity<?> selectByUsernameAndDtype(@RequestParam String username, @RequestParam String dtype) {
	        Users users = usersService.selectByUsernameAndDtype(username, dtype);
	        UsersVO vo = BeanCastUtil.castBean(users, UsersVO.class);
	        return ResponseEntity.ok(vo);
	    }
	    
}
