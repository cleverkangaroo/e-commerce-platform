package com.kangaroo.microservices.api.base.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kangaroo.microservices.api.base.model.vo.UsersVO;
import com.kangaroo.microservices.api.base.support.BaseVersion;

@FeignClient(value=BaseVersion.MIRCROSERVICES)
public interface UsersService {

	 @RequestMapping(method = RequestMethod.GET, value = "/user/getUserInfo")
	 public UsersVO getUserInfo(@RequestParam(value="userId") Long userId);
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/user/selectByUsernameAndDtype")
	 public UsersVO selectByUsernameAndDtype(@RequestParam(value="username") String username, @RequestParam(value="dtype") String dtype);
}
