/**
* @Title: RibbonControlle.java
* @Package com.fpq.controller
* @Description:实现ribbon客户端负载均衡调用
* @author slx
* @date 2019年3月25日
* @version V1.0
*/
package com.fpq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.fpq.service.HttpClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @classDesc: 功能描述：实现ribbon客户端负载均衡调用
* @author 付品欣
* @createTime 2019年3月25日 上午12:47:20
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@RestController
@Api("实现ribbon客户端负载均衡调用") //api的描述
public class RibbonControlle {

	/**
	 * 获取会员服务在服务注册中心eureke中注册的别名，若apollo中未配置，则取默认值springCloud2-provider
	 */
	@Value("${memberServer:springCloud2-provider}")
	private String memberServer;
	
	//获取注册中心上的服务列表
	@Autowired
	private DiscoveryClient discoveryClient;
	
	//注入restTemplate（对httpClient进行了封装）
//	@Autowired
//	private RestTemplate restTemplate;
	//接口的请求总数
	private int reqCount = 1;
	
	@Autowired
	private HttpClient httpClient;
	
	/**
	 * @throws Exception 
	 * http://127.0.0.1:8300/ribbonMember
	* @Title: ribbonMember
	* @Description: 手写ribbon的实现逻辑代码
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@GetMapping("/ribbonMember")
	@ApiOperation("手写ribbon的实现逻辑代码")
	public String ribbonMember() throws Exception {
		//1.获取服务的远程访问地址
		String instancesUrl = getInstances() + "/getMember";
		System.out.println("远程服务的url:"+instancesUrl);
		
		//2.可以直接使用httpClient技术实现远程http调用
//		String result = restTemplate.getForObject(instancesUrl, String.class);
		String result = httpClient.invokeInterfaceUserHttpClient(instancesUrl);
		return result;
	}
	
	
	
	private String getInstances() {
		List<ServiceInstance> instances = discoveryClient.getInstances(memberServer);
		if(instances == null || instances.size() <= 0) {
			return null;
		}
		
		//获取机器个数
		int instanceSize = instances.size();
		int serviceIndex = reqCount % instanceSize;
		reqCount++;  //集群情况下需要用原子计数器
		System.out.println("集群中节点个数："+instanceSize);
		for(int i=0;i<instanceSize;i++) {
			System.out.println("远程访问url-"+i+":"+instances.get(i).getUri().toString());
		}
		//返回服务的远程访问地址
		return instances.get(serviceIndex).getUri().toString();
	}
	
	
	
}
