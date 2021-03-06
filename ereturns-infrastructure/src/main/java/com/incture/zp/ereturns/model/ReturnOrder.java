package com.incture.zp.ereturns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_RETURN_ORDER")
public class ReturnOrder {

	@Id
	@Column(name = "RETURN_ORDER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long returnOrderId;
	
	@Column(name = "RETURN_QTY", length = 50)
	private String returnQty;

	@Column(name = "REASON", length = 255)
	private String reason;
	
	@Column(name = "REMARK", length = 255)
	private String remark;
	
	@Column(name = "RETURN_PRICE", length = 50)
	private String returnPrice;
	
	@Column(name = "RETURN_VALUE", length = 50)
	private String returnValue;

	@Column(name = "ITEM_CODE")
	private String itemCode; 
	
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;

	@ManyToOne
	@JoinColumn(name = "REQUEST_ID", nullable = false, updatable = false)
	private Request returnOrderData;
	
	public Long getReturnOrderId() {
		return returnOrderId;
	}

	public void setReturnOrderId(Long returnOrderId) {
		this.returnOrderId = returnOrderId;
	}

	public String getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(String returnQty) {
		this.returnQty = returnQty;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getReturnPrice() {
		return returnPrice;
	}

	public void setReturnPrice(String returnPrice) {
		this.returnPrice = returnPrice;
	}

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}

	public Request getReturnOrderData() {
		return returnOrderData;
	}

	public void setReturnOrderData(Request returnOrderData) {
		this.returnOrderData = returnOrderData;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
