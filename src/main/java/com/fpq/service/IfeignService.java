/**
* @Title: IfeignService.java
* @Package com.fpq.service
* @Description: TODO(用一句话描述该文件做什么)
* @author slx
* @date 2019年3月31日
* @version V1.0
*/
package com.fpq.service;

import com.fpq.base.ResponseBase;

/**
* @classDesc: 功能描述：feign调用api的接口
* @author 付品欣
* @createTime 2019年3月31日 下午3:16:09
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
*/
public interface IfeignService {


	
	/**
	 * 
	* @Title: testHystrix2
	* @Description: TODO(服务降级的第二种方法:用类的方式实现)
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	public ResponseBase testHystrix2();
	
	/**
	 * 
	* @Title: testServiceSeperate2
	* @Description: TODO(服务降级的第二种方法:用类的方式实现)
	* @param @param name
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	public ResponseBase testServiceSeperate2(String name);
	
//	/**
//	 * 
//	* @Title: testServiceSeperate
//	* @Description: 测试服务隔离
//	* @param  name:用户名称
//	* @param     参数
//	* @return ResponseBase    返回类型
//	* @throws
//	 */
//	public String testServiceSeperate(String name);
	
//	/**
//	 * 
//	* @Title: testHystrix
//	* @Description: 测试Hystrix实现服务降级
//	* @param @param name
//	* @param @return    参数
//	* @return ResponseBase    返回类型
//	* @throws
//	 */
//	public String testHystrix();
}
