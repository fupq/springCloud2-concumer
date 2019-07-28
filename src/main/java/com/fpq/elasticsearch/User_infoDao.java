/**
* @Title: User_infoDao.java
* @Package com.fpq.elasticsearch
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年6月19日
* @version V1.0
*/
package com.fpq.elasticsearch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
* @classDesc: 功能描述：对elasticsearch中索引es_index下的user_info类型进行增删改查操作
* @author 付品欣
* @createTime 2019年6月19日 上午12:03:41
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
//@Component //不需要加@Component，直接可以@Autowared
public interface User_infoDao extends CrudRepository<User_info, Long>{

}
