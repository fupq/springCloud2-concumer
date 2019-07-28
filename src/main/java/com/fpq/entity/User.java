/**
* @Title: User.java
* @Package com.fpq.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年3月26日
* @version V1.0
*/
package com.fpq.entity;

import lombok.ToString;

/**
* @classDesc: 功能描述：
* @author 付品欣
* @createTime 2019年3月26日 上午12:00:24
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@ToString
public class User {

	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 年龄
	 */
	private int age;

	/**
	* @return name
	*/
	public String getName() {
		return name;
	}

	/**
	* @param paramtheparamthe{bare_field_name} to set
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* @return age
	*/
	public int getAge() {
		return age;
	}

	/**
	* @param paramtheparamthe{bare_field_name} to set
	*/
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
