/**
* @Title: AppProvider.java
* @Package com.fpq
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author slx
* @date 2019��3��20��
* @version V1.0
*/
package com.fpq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.client.RestTemplate;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.fpq.service.stream.IConcumerMessage;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring4all.swagger.EnableSwagger2Doc;

/**
* @classDesc: ����������
* @author ��Ʒ��
* @createTime 2019��3��20�� ����11:41:39
* @version: V1.0
* @copyright:���ڿ�������Ƽ����޹�˾
* @wechat:qhjx666888
* Netflix开发的声明式、模板化的HTTP客户端， Feign可以帮助我们更快捷、优雅地调用HTTP API
*/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //启动feign远程调用工具
@EnableHystrix //启动hystrix工具,可使用@HystrixCommand(fallbackMethod="methodName") 进行服务隔离，服务降级和服务熔断
@EnableApolloConfig //启动apollo客户端
@EnableSwagger2Doc  //生产swagger2Doc文档
@EnableBinding(IConcumerMessage.class) // 开启绑定mq的channel
@EnableElasticsearchRepositories(basePackages = "com.fpq")
public class AppConsumer {

	public static void main(String[] args) {
		SpringApplication.run(AppConsumer.class, args);
	}

	/**
	 * LoadBalanced就能让这个RestTemplate在请求时拥有客户端负载均衡的能力
	 * 解决RestTemplate 找不到原因 应该把restTemplate注册SpringBoot容器中 @bean
	* @Title: restTemplate
	* @Description: 想spring注入RestTemplate
	* @param @return    参数
	* @return RestTemplate    返回类型
	* @throws
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
