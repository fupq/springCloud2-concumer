/**
* @Title: IConcumerMessage.java
* @Package com.fpq.service.stream
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年6月2日
* @version V1.0
*/
package com.fpq.service.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
* @classDesc: 功能描述：消费者绑定channel
* @author 付品欣
* @createTime 2019年6月2日 下午6:05:37
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
public interface IConcumerMessage {

	/**
	 * 
	* @Title: sendMessage
	* @Description: 绑定channel名称，创建通道
	* @param @return    参数
	* @return SubscribableChannel    返回类型
	* @throws
	 */
	@Input("channel_fpq_test")
	public SubscribableChannel sendMessage();
}
