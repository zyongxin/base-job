package com.bhzy.carnet.resutl;


import com.bhzy.carnet.enmus.ResponCodeEnmu;

/**
 * 返回信息枚举
 */
public class Message {

	public String code;
	
	public Object data;
	
	public String message;
	
	public Message() {
		
	}
	
	public Message(String code, Object data, String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public Message(String code, String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public Message(ResponCodeEnmu enmu) {
		this.code = enmu.getCode();
		this.message = enmu.getMessage();
	}

	public static Message success(Object data) {
		return new Message(ResponCodeEnmu.SUCCESS.getCode(),data,"成功");
	}

	public static Message success() {
		return new Message(ResponCodeEnmu.SUCCESS.getCode(),"成功");
	}

	public static Message build(String code, Object data, String message) {
		return new Message(code,data,message);
	}
}
