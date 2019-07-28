/**
* @Title: MemberApifeignInterfaceFallBack.java
* @Package com.fpq.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年5月2日
* @version V1.0
*/
package com.fpq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fpq.base.BaseApiService;
import com.fpq.base.ResponseBase;
import com.fpq.service.ImemberApifeignInterface;


import lombok.extern.slf4j.Slf4j;

/**
* @classDesc: 功能描述：
* @author 付品欣
* @createTime 2019年5月2日 上午12:10:04
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@Slf4j
@Component
public class MemberApifeignInterfaceFallBack implements ImemberApifeignInterface {

	@Autowired
	private BaseApiService baseApiService;
	
	@Override
	public ResponseBase getMember2() {
		String result = "getMember服务繁忙，请稍后再调用！服务降级后调用的FallBack服务消费者所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId();
		log.info(result);
		ResponseBase responseBase = baseApiService.setResultError(result);
		return responseBase;
	}

	@Override
	public ResponseBase getUser(String name) {
		String result = "getUser服务繁忙，请稍后再调用！服务降级后调用的FallBack服务消费者所在的线程池名称："+Thread.currentThread().getName()+"，线程id:"+Thread.currentThread().getId();
		log.info(result);
		ResponseBase responseBase = baseApiService.setResultError(result);
		return responseBase;
	}

}
