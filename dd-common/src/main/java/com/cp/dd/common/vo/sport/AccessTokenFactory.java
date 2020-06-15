package com.cp.dd.common.vo.sport;

import com.alibaba.fastjson.JSONObject;
import com.cp.dd.common.util.http.HttpRequest;

import java.util.Date;


/**
 * @desc: token工具类
 * @author: chengp
 * @since: 1.0
 */
public class AccessTokenFactory {

	private static AccessToken accessToken;
	//有效时间
	private static long expiresDate;
	
	private static JsapiTicket jsapiTicket;
	
	private static long jsExpiresDate;
	
	/**
	 * 获取 access_token
	 */
	public static AccessToken getAccessToken(String appId, String appSecret) {
		if(accessToken == null || (new Date().getTime() >= expiresDate - 10000)){
			accessToken = accessApi(appId, appSecret);
			expiresDate = new Date().getTime() + accessToken.getExpires_in() * 1000;
		}
		return accessToken;
	}
	
	
	public static AccessToken accessApi(String appId, String appSecret){
		String url =  "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret="
				+ appSecret;
		String str = HttpRequest.sendGet(url);
		if(str.indexOf("errcode") != -1){
			return null;
		}else{
			JSONObject jsonObj = JSONObject.parseObject(str);
			AccessToken token = JSONObject.parseObject(jsonObj.toString(), AccessToken.class);
			return token;
		}
	}
	
	/**
	 * 获取调用微信JS接口的临时票据
	 */
	public static JsapiTicket getJsapiTicket(String appId, String appSecret){
		if(jsapiTicket == null || (new Date().getTime() >= jsExpiresDate - 10000)){
			jsapiTicket = jsapiTicketApi(appId, appSecret);
			jsExpiresDate = new Date().getTime() + jsapiTicket.getExpires_in() * 1000;
		}
		return jsapiTicket;
	}
	
	
	public static JsapiTicket jsapiTicketApi(String appId, String appSecret){
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ getAccessToken(appId, appSecret).getAccess_token() +"&type=jsapi";
		String str = HttpRequest.sendGet(url);
		
		JSONObject jsonObj = JSONObject.parseObject(str);
		JsapiTicket vo = JSONObject.parseObject(jsonObj.toString(), JsapiTicket.class);
		return vo;
	}
}
