package com.fpq.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class HttpClient {


	/**
	 * 
	* @Title: invokeInterfaceUserAgentHttpClient
	* @Description: 封装httpClient调用url，模拟浏览器调用
	* @param  被调用的url
	* @param  serverIp 高匿代理的服务器ip
	* @param  port 高匿代理的端口
	* @param 
	* @param @throws Exception    参数
	* @return String 调用url返回的结果
	* @throws
	 */
	public String invokeInterfaceUserAgentHttpClient(String url,String serverIp,int port) throws Exception{
		CloseableHttpClient httpClient =HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);//https://www.baidu.com/ //http://127.0.0.1:8080/getJsonPerson
		
		
		//设置高匿代理 
		HttpHost proxy = new HttpHost(serverIp,port); //西刺免费代理ip,("175.155.213.235",1999)
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(10000) //设置链接超时10秒钟
				.setSocketTimeout(10000) //设置读取超时时间10秒钟
				.setProxy(proxy)
				.build();
		httpGet.setConfig(config);
		httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/65.0");
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		//获取返回实体
		HttpEntity httpEntity = httpResponse.getEntity();
		//使用utf-8编码格式对httpEntity进行解析，获取网页内容
		String pageContext = EntityUtils.toString(httpEntity, "utf-8");
//		log.info("网页内容："+pageContext);
		//获取响应的内容类型
//		log.info("ContentType:name="+httpEntity.getContentType().getName()+",value:"+httpEntity.getContentType().getValue());
		//获取响应的状态
//		log.info("响应状态status:"+httpResponse.getStatusLine());
		//关闭httpResponse
		httpResponse.close();
		//关闭httpClient
		httpClient.close();
		return pageContext;
	}
	
	/**
	 * 
	* @Title: invokeInterfaceUserHttpClient
	* @Description: httpclient封装调用url
	* @param @param 被调用的url 
	* @param @return    参数
	* @return String 调用url的返回结果
	* @throws
	 */
	public String invokeInterfaceUserHttpClient(String url) {
		CloseableHttpClient httpClient =HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);//https://www.baidu.com/ //http://127.0.0.1:8080/getJsonPerson
		CloseableHttpResponse httpResponse = null;
		
		try {
			httpResponse = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// http协议异常
			e.printStackTrace();
		} catch (IOException e) {
			// io异常
			e.printStackTrace();
		}
		//获取返回实体
		HttpEntity httpEntity = httpResponse.getEntity();
		String pageContext="";
		try {
			//使用utf-8编码格式对httpEntity进行解析，获取网页内容
		    pageContext = EntityUtils.toString(httpEntity, "utf-8");
//			log.info("网页内容："+pageContext);
		} catch (ParseException e) {
			//解析异常
			e.printStackTrace();
		} catch (IOException e) {
			// io异常
			e.printStackTrace();
		}
		//关闭httpResponse
		try {
			httpResponse.close();
		} catch (IOException e) {
			//io异常
			e.printStackTrace();
		}
		//关闭httpClient
		try {
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageContext;
	}
	
}
