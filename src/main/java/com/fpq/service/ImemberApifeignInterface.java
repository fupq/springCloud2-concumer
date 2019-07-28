/**
* @Title: MemberApifeignInterface.java
* @Package com.fpq.service
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年3月28日
* @version V1.0
*/
package com.fpq.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpq.base.ResponseBase;
import com.fpq.service.impl.MemberApifeignInterfaceFallBack;

/**
* @classDesc: 功能描述：feign测试，Feign客户端是一个web接口式http远程调用工具,实现本地负载均衡调用api接口
* @author 付品欣
* @createTime 2019年3月28日 上午12:04:21
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
//name 指定被调用的服务名称
@FeignClient(name = "springCloud2-provider",fallback=MemberApifeignInterfaceFallBack.class)
public interface ImemberApifeignInterface {

	//制定被调用的接口
	@RequestMapping("/getMember2")
	public ResponseBase getMember2();

	@RequestMapping("/getUser")
	public ResponseBase getUser(String name);
//	public String getUser();
}
