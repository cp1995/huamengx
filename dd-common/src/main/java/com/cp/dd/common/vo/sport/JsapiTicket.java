package com.cp.dd.common.vo.sport;

/**
 * @desc: jsticket
 * @author: chengp
 * @since: 1.0
 */
public class JsapiTicket {
private int errcode;
	
	private String errmsg;
	
	private String ticket;
	
	private Long expires_in;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
}
