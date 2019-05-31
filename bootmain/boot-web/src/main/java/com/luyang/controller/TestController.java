package com.luyang.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luyang.pigbean.PigBean;
import com.luyang.pigservice.PigService;
import com.luyang.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/test1")
@Api(value = "/test1", tags = "测试接口模块")
public class TestController {

	private Logger log = Logger.getLogger(TestController.class);

	@Autowired
	private PigService pigService;

	@RequestMapping(value = "/geta", method = { RequestMethod.GET })
	@Cacheable(value = "a")
	public String a() {
		return "1";
	}

	@RequestMapping(value = "aa", method = { RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "数据库测试", notes = "数据库测试1")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "bad request"),
			@ApiResponse(code = 404, message = "the source is not found"),
			@ApiResponse(code = 500, message = "error") })
	public PigBean aa() {
		log.info(MessageUtil.M("run"));
		System.out.println(pigService.getPigById(1));
		return pigService.getPigById(1);
	}

	@PostMapping("cOne")
	@ApiOperation(value = "修改", notes = "修改1")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "bad request"),
			@ApiResponse(code = 404, message = "the source is not found"),
			@ApiResponse(code = 500, message = "error") })	
	public boolean changePigById(@RequestBody PigBean pig) {
			boolean flag = pigService.changePigById(pig);
			System.out.println("更新成功");
			return flag;		
	}
		
}
