/**
* @Title: ListenerChannel.java
* @Package com.fpq.service.stream
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年6月2日
* @version V1.0
*/
package com.fpq.service.stream;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
* @classDesc: 功能描述：监听channel中的消息
* @author 付品欣
* @createTime 2019年6月2日 下午6:00:30
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@Component
@Slf4j
public class ListenerChannel {

	/**
	 * 
	* @Title: listener
	* @Description:监听消息
	* @param @param msg 参数
	* @return void    返回类型
	* @throws
	 */
	@StreamListener("channel_fpq_test")
	public void listener(String msg) {
		log.info("消费者获取生产消息:" + msg);
	}

}
