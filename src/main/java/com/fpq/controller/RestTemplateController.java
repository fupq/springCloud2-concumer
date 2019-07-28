/**
* @Title: RestTemplateController.java
* @Package com.fpq.controller
* @Description: 测试RestTemplate调用url的功能
* @author slx
* @date 2019年3月25日
* @version V1.0
*/
package com.fpq.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.esotericsoftware.minlog.Log;
import com.fpq.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

//import com.fpq.config.SimpleRestClient;

/**
* @classDesc: 功能描述：
* @author 付品欣
* @createTime 2019年3月25日 下午9:43:46
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@RestController
@Slf4j
@Api("使用restTemplate调用http接口的几种方式测试") //api的描述
public class RestTemplateController {

	/**
	 * 获取会员服务在服务注册中心eureke中注册的别名，若apollo中未配置，则取默认值springCloud2-provider
	 */
	@Value("${memberServer:springCloud2-provider}")
	private String memberServer;

	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * http://127.0.0.1:8300/getForEntity
	* @Title: getForEntity
	* @Description: 使用restTemplate进行接口调用
	* @param @return    参数
	* @return ResponseEntity<String>    返回类型
	* @throws
	 */
	@GetMapping("/getForEntity")
	@ApiOperation("使用restTemplate进行接口调用")
	public ResponseEntity<String> getForEntity() {
		System.out.println("memberServer="+memberServer);
		ResponseEntity<String> response = restTemplate.getForEntity("http://"+memberServer+"/getUser?name=carson",String.class);
		System.out.println("statusCode:" + response.getStatusCode());
		System.out.println("Body:" + response.getBody());
		System.out.println("headers:" + response.getHeaders().toString());
		System.out.println("StatusCodeValue:" + response.getStatusCodeValue());
		return response;
	}

	
	/**
	 * http://127.0.0.1:8300/getForEntityParameter?name=restTemplateWithParamete
	* @Title: getForEntityParameter
	* @Description: 带参数的getForEntity调用，通过map传递参数
	* @param @param name
	* @param @return    参数
	* @return ResponseEntity<String>    返回类型
	* @throws
	* 使用name={name}这种形式，最后一个参数是一个map，map的key即为前边占位符的名字，map的value为参数值；
	* 可以用一个数字做占位符，最后是一个可变长度的参数，来一一替换前面的占位符；
	 */
	@GetMapping("/getForEntityParameter")
	@ApiOperation("带参数的getForEntity调用，通过map传递参数")
	public ResponseEntity<String> getForEntityParameter(String name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		ResponseEntity<String> response = restTemplate.getForEntity("http://"+memberServer+"/getUser?name={name}",String.class, map);
		System.out.println("statusCode:" + response.getStatusCode());
		System.out.println("Body:" + response.getBody());
		return response;
	}

	
	/**
	 * http://127.0.0.1:8300/getOrder
	* @Title: getOrder
	* @Description: getForObject访问url
	* @param @return    参数
	* @return String    返回类型
	* @throws
	* getForObject函数实际上是对getForEntity函数的进一步封装，
	*  如果你只关注返回的消息体的内容，对其他信息都不关注，此时可以使用getForObject
	 */
	@GetMapping("/getOrder")
	@ApiOperation("getForObject访问url")
	public String getOrder() {
		// 有两种方式，一种是采用服务别名方式调用，另一种是直接调用 使用别名去注册中心上获取对应的服务调用地址
		String url = "http://"+memberServer+"/getMember";
		String result = restTemplate.getForObject(url, String.class);
		System.out.println("订单服务调用会员服务result:" + result);
		return result;
	}

	/**
	 * http://127.0.0.1:8300/postForObjectOrder
	* @Title: postForObjectOrder
	* @Description: restTemplate的post请求方式postForObject调用url
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@GetMapping("/postForObjectOrder")
	@ApiOperation("getForObject访问url")
	public String postForObjectOrder() {
		User user = new User();
		user.setName("carson");
		user.setAge(5);
		// 有两种方式，一种是采用服务别名方式调用，另一种是直接调用 使用别名去注册中心上获取对应的服务调用地址
		String url = "http://"+memberServer+"/getUserObject";
		String result = restTemplate.postForObject(url, user, String.class);
		System.out.println("订单服务调用会员服务result:" + result);
		return result;
	}
	
	/**
	 * http://127.0.0.1:8300/postForEntityOrder
	* @Title: postForEntityOrder
	* @Description: restTemplate的post请求方式postForEntity调用url
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@GetMapping("/postForEntityOrder")
	@PostMapping("/postForEntityOrder")
	@ApiOperation("restTemplate的post请求方式postForEntity调用url")
	public String postForEntityOrder() {
		User user = new User();
		user.setName("carson");
		user.setAge(5);
		log.info("请求参数："+user.toString());
		// 有两种方式，一种是采用服务别名方式调用，另一种是直接调用 使用别名去注册中心上获取对应的服务调用地址
		String url = "http://"+memberServer+"/getUserObject";
		ResponseEntity<String> result = restTemplate.postForEntity(url, user, String.class);
		System.out.println("StatusCode:" + result.getStatusCodeValue());
		System.out.println("订单服务调用会员服务result:" + result.getBody());
		return result.getBody();
	}
}
