/**
* @Title: OrderController.java
* @Package com.fpq.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年3月22日
* @version V1.0
*/
package com.fpq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @classDesc: 功能描述：
* @author 付品欣
* @createTime 2019年3月22日 上午12:11:09
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@RestController
@Api("订单服务测试类") //api的描述
public class OrderController {
	
	/**
	 * 获取会员服务在服务注册中心eureke中注册的别名，若apollo中未配置，则取默认值springCloud2-provider
	 */
	@Value("${memberServer:springCloud2-provider}")
	private String memberServer;
	
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * http://127.0.0.1:8300/getorder
	* @Title: getOrder
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@GetMapping("/getorder")
	@ApiOperation("通过restTemplate调研http接口")
	public String getOrder() {
		// order 使用rpc 远程调用技术 调用 会员服务
		String memberUrl = "http://"+memberServer+"/getMember";
		String result = restTemplate.getForObject(memberUrl, String.class);
		System.out.println("会员服务调用订单服务,result:" + result);
		return result;
	}

}

