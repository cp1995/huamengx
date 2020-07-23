package com.cp.dd.common.constant;

/**
 * 
 *<p>
 *常量表
 *<p>
 * @author chnegp
 * @date 2019年10月9日
 */
public interface Constants {

	public static final String LOGIN_ERROR = "loginLog:loginErrorCount:";
	public static final String WX_STATE = "wxState";


	/**
	 * 状态 -1删除 1正常（启用） 0 禁用
	 */
	public interface  Status {
		int delete = -1;
		int enable =1;
		int disable  =0;
	}
}
