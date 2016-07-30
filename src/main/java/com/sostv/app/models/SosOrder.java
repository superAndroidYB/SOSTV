package com.sostv.app.models;

import java.io.Serializable;

/**
 * 客户端请求指令操作
 * @author Administrator
 *
 */
public class SosOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderType;
	
	private String orderId;

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
