/**
* @Title: ElasticsearchController.java
* @Package com.fpq.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年6月18日
* @version V1.0
*/
package com.fpq.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpq.elasticsearch.User_info;
import com.fpq.elasticsearch.User_infoDao;

import lombok.extern.slf4j.Slf4j;

/**
* @classDesc: 功能描述：操作elasticsearch
* @author 付品欣
* @createTime 2019年6月18日 下午11:41:15
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
@RequestMapping("/elasticsearch")
@RestController
@Slf4j
public class ElasticsearchController {

	@Autowired
	private User_infoDao user_infoDao;
	
	/**
	 * http://127.0.0.1:8300/elasticsearch/addUser
	* @Title: addUser
	* @Description: 对elasticsearch中索引es_index下的user_info类型进行增加操作
	* @param @param user
	* @param @return    参数
	* @return User_info    返回类型
	* @throws
	 */
	@RequestMapping("/addUser")
	public User_info addUser(@RequestBody User_info user) {
		User_info userInfo = user_infoDao.save(user);
		log.info("向elasticsearch中索引es_index下的user_info类型添加："+userInfo.toString()+"成功！");
		return userInfo;
	}
	
	
	/**
	 * http://127.0.0.1:8300/elasticsearch/findById?id=1
	* @Title: findById
	* @Description: 对elasticsearch中索引es_index下的user_info类型进行查询操作
	* @param id
	* @return Optional<User_info>    返回类型
	* @throws
	 */
	@RequestMapping("/findById")
	public Optional<User_info> findById(Long id) {
		Optional<User_info> userInfo = user_infoDao.findById(id);
		log.info("查询elasticsearch中索引es_index下的user_info类型的id为"+id+"的值成功："+userInfo.toString());
		return userInfo;
	}
}
