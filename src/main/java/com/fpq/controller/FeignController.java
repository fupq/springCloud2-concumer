/**
* @Title: FeignController.java
* @Package com.fpq.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年3月28日
* @version V1.0
*/
package com.fpq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpq.base.BaseApiService;
import com.fpq.base.ResponseBase;
import com.fpq.service.IfeignService;
import com.fpq.service.ImemberApifeignInterface;
import com.fpq.service.impl.FeignServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
* @classDesc: 功能描述：使用feign调用服务接口
* @author 付品欣
* @createTime 2019年3月28日 上午12:12:05
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@RestController
@RequestMapping("/feign")
@Slf4j
@Api("使用feign调用服务接口") //api的描述
public class FeignController {

	@Autowired
	private ImemberApifeignInterface memberApifeign;

	@Autowired
	private IfeignService feignService;
	
	@Autowired
	private FeignServiceImpl feignServiceImpl;
	
	
	
	/**
	 * http://127.0.0.1:8300/feign/feignMember
	* @Title: feignMember
	* @Description: 调用feign封装的调用服务
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@GetMapping("/feignMember")
	@ApiOperation("调用feign封装的调用服务")
	public String feignMember() {
		System.out.println("调用feign封装的调用服务......");
		log.info("getMember服务所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId());
		return memberApifeign.getMember2().toString();
	}

	/**
	 * http://127.0.0.1:8300/feign/testHystrix
	* @Title: testHystrix
	* @Description: 测试Hystrix的服务降级功能
	* @param @param name 会员名称
	* @param @return    参数
	* @return ResponseBase    返回类型
	* @throws
	 */
	@GetMapping("/testHystrix")
	@ApiOperation("测试Hystrix的服务降级功能")
	public ResponseBase testHystrix() {
		log.info("testHystrix开始执行");
		return feignServiceImpl.testHystrix();
	}
	
	
	/**
	 * 
	* @Title: testHystrix2
	* @Description: TODO(测试服务降级问题--类实现方式)
	* @param @return    参数
	* @return ResponseBase    返回类型
	* @throws
	* http://127.0.0.1:8300/feign/testHystrix2
	 */
	@GetMapping("/testHystrix2")
	@ApiOperation("测试服务降级问题--类实现方式")
	public ResponseBase testHystrix2(HttpServletRequest request,HttpServletResponse response) {
		ResponseBase responseBase = feignService.testHystrix2();
		log.info("我是订单服务(服务消费者):TraceId:" + request.getHeader("X-B3-TraceId") + ",spanid:"+ request.getHeader("X-B3-SpanId"));
		log.info("testHystrix2开始执行,测试服务降级问题--类实现方式");
		
		//log.info("我是订单服务(服务消费者):TraceId:" + respose..getHeader("X-B3-TraceId") + ",spanid:"+ request.getHeader("X-B3-SpanId"));
		
		return responseBase;
	}
	
	/**
	 * http://127.0.0.1:8300/feign/testServiceSeperate?name=carson
	* @Title: testServiceSeperate
	* @Description: 测试Hystrix的服务隔离
	* @param @param name
	* @param @return    参数
	* @return ResponseBase    返回类型
	* @throws
	 */
	@GetMapping("/testServiceSeperate")
	@ApiOperation("测试服务降级问题--类实现方式")
	public ResponseBase testServiceSeperate(String name) {
		log.info("testServiceSeperateFallBack开始执行");
		return feignServiceImpl.testServiceSeperate(name);
	}
}
