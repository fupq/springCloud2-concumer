/**
* @Title: User_info.java
* @Package com.fpq.elasticsearch
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年6月19日
* @version V1.0
*/
package com.fpq.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

/**
* @classDesc: 功能描述：elasticsearch中索引es_index下的user_info类型
* @author 付品欣
* @createTime 2019年6月19日 上午12:00:31
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@Data
@Document(indexName="es_index",type="user_info") //加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词。
public class User_info {
	/**
	 * elasticsearch中记录的id
	 */
	@Id
	private Long id;
//	@Field //@Field注解来进行详细的指定，如果没有特殊需求，那么只需要添加@Document即可
	private String name;
	//@Field
	private int age;
	//@Field
	private String sex;
	//@Field
	private String phone;
	//@Field
	private String address;
}
