package com.fpq.base;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;

/**
 * 
* @classDesc: 功能描述：对返回结果进行封装
* @author 付品欣
* @createTime 2019年3月30日 下午2:38:07
* @version: V1.0
* @copyright:深圳科翔教育科技有限公司
* @wechat:qhjx666888
 */
@Data
@Slf4j
public class ResponseBase {

	/**
	 * 响应码
	 */
	private Integer rtnCode;
	/**
	 * 显示的信息
	 */
	private String msg;
	/**
	 * 返回的数据
	 */
	private Object data;

	public ResponseBase() {

	}

	public ResponseBase(Integer rtnCode, String msg, Object data) {
		super();
		this.rtnCode = rtnCode;
		this.msg = msg;
		this.data = data;
	}

	public static void main(String[] args) {
		ResponseBase responseBase = new ResponseBase();
		responseBase.setData("123456");
		responseBase.setMsg("success");
		responseBase.setRtnCode(200);
		System.out.println(responseBase.toString());
		log.info("itmayiedu...");
	}

	@Override
	public String toString() {
		return "ResponseBase [rtnCode=" + rtnCode + ", msg=" + msg + ", data=" + data + "]";
	}

}
