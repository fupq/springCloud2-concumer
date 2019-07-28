/**
* @Title: ApolloValueIsChange.java
* @Package com.fpq.service
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年4月7日
* @version V1.0
*/
package com.fpq.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

import lombok.extern.slf4j.Slf4j;

/**
* @classDesc: 功能描述：监听apollo中参数值是否进行了修改
* @author 付品欣
* @createTime 2019年4月7日 下午1:51:30
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@Slf4j
@Component
public class ApolloValueIsChange implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	/*@ApolloConfigChangeListener("application")
	private void anotherOnChange(ConfigChangeEvent changeEvent) {
		ConfigChange change = changeEvent.getChange("ribbon.ConnectTimeout");
		System.out.println(String.format("Found change - key: %s, oldValue: %s," + "newValue: %s, changeType: %s",
				change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
	}*/

	@ApolloConfigChangeListener
	private void someChangeHandler(ConfigChangeEvent changeEvent) {
		int count = 0;
	    for (String key : changeEvent.changedKeys()) {
	        ConfigChange change = changeEvent.getChange(key);
	        log.info(count++ +" *** Found change - {}", change.toString());
	    }
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}
}
