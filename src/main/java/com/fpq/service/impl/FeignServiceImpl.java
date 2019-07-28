/**
* @Title: FeignServiceImpl.java
* @Package com.fpq.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年3月31日
* @version V1.0
*/
package com.fpq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpq.base.BaseApiService;
import com.fpq.base.ResponseBase;
import com.fpq.service.IfeignService;
import com.fpq.service.ImemberApifeignInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

/**
* @classDesc: 功能描述：
* @author 付品欣
* @createTime 2019年3月31日 下午3:17:07
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@Service
@Slf4j
public class FeignServiceImpl implements IfeignService{

	@Autowired
	private ImemberApifeignInterface memberapi;
	
	@Autowired
	private BaseApiService baseApiService;
	
	/**
	 * 使用hystrix工具实现服务降级功能，若调用该接口失败则调用
	 * fallbackMethod：当服务不可用时，所执行的方法名称
	 */
	@HystrixCommand(fallbackMethod="testHystrixFallBack") //默认开启线程池隔离方式，进行服务隔离，服务降级，服务熔断
	public ResponseBase testHystrix() {
		log.info("getMember服务消费者所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId());
		ResponseBase result = memberapi.getMember2();
//		ResponseBase responseBase = baseApiService.setResultSuccess(result);
		return result;
	}


	/**
	 * 
	* @Title: testHystrixFallBack
	* @Description: 服务降级时调用的方法
	* @param @param name
	* @param @return    参数
	* @return ResponseBase    返回类型
	* @throws
	 */
	public ResponseBase testHystrixFallBack() {
		String result = "服务降级：服务‘getMember’繁忙，请稍后再调用！testHystrix服务降级后的testHystrixFallBack所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId();
		log.info(result);
		ResponseBase responseBase = baseApiService.setResultError(result);
		return responseBase;
	}

	/**
	 * 采用实现feign接口的类的方式实现fallback方法
	 */
	@Override
	public ResponseBase testHystrix2() {
		log.info("getMember服务消费者所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId());
		ResponseBase result = memberapi.getMember2();
//		ResponseBase responseBase = baseApiService.setResultSuccess(result);
		return result;
	}

	/**
	 * 测试服务隔离，feign的hystrix实现服务隔离，调用getUser服务
	 */
	@HystrixCommand(fallbackMethod="testServiceSeperateFallBack") //默认开启线程池隔离方式，进行服务隔离，服务降级，服务熔断
	public ResponseBase testServiceSeperate(String name) {
		log.info("getUser服务消费者所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId());
		ResponseBase result = memberapi.getUser(name);
//		ResponseBase responseBase = baseApiService.setResultSuccess(result);
		return result;
	}
	
	/**
	 * 
	* @Title: testServiceSeperateFallBack
	* @Description: 
	* @param   name 用户名称
	* @param      参数
	* @return ResponseBase    返回类型
	* @throws
	 */
	public ResponseBase testServiceSeperateFallBack(String name) {
		String result = "服务降级：服务‘getUser’繁忙，请稍后再调用！testServiceSeperate服务降级后调用的testServiceSeperateFallBack服务消费者所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId();
		log.info(result);
		ResponseBase responseBase = baseApiService.setResultError(result);
		return responseBase;
	}


	/**
	 * 采用实现feign接口的类的方式实现fallback方法
	 */
	@Override
	public ResponseBase testServiceSeperate2(String name) {
		log.info("getUser服务消费者所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId());
		ResponseBase result = memberapi.getUser(name);
//		ResponseBase responseBase = baseApiService.setResultSuccess(result);
		return result;
	}

}
