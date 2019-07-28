/**
* @Title: ApolloController.java
* @Package com.fpq.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年4月6日
* @version V1.0
*/
package com.fpq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
* @classDesc: 功能描述：apollo分布式配置中心测试
* @author 付品欣
* @createTime 2019年4月6日 上午00:09:49
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@RestController
@Slf4j
@RequestMapping("/apollo")
@Api("服务消费者-apollo接入测试类") //api的描述
public class ApolloController {

	/**
	 * 通过value注解读取配置文件中配置的memberName参数的值
	 * 冒号参数名":"后是给参数定义的默认值，若apollo中未配置则取值为springCloud2-provider
	 */
	@Value("${memberServer:springCloud2-provider}")
	private String memberServer;
	
	/**
	 * 端口号
	 */
	@Value("${server.port:80}")
	private String serverPort;
	
	/**
	 * http://127.0.0.1:8300/apollo/getMemberName
	* @Title: getMemberName
	* @Description: 读取apollo中配置的参数的值
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@GetMapping("/getMemberName")
	@ApiOperation("读取apollo中配置的参数的值")
	public String getMemberName() {
		String result = "服务的名称为："+this.memberServer+",端口号："+serverPort;
		log.info(result);
		return result;
	}
}
