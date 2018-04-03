package com.incture.zp.ereturns.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_HEADER")
public class Header {
	
	@Id
	@Column(name = "INVOICE_NO", nullable = false)
	private String invoiceNo;
	
	@Column(name = "INVOICE_SEQ", length = 3)
	private String invoiceSeq;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INVOICE_DATE")
	private Date invoiceDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;
	
	@Column(name = "AVAILABLE_QTY", length = 5)
	private String availableQty;

	@Column(name = "NET_VALUE", precision = 8, scale = 2)
	private String netValue; // sum of all item level net value to be calculated
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false, updatable = false)
	private User headerData;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "itemData")
	private Set<Item> setItem;
	
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public void setInvoiceSeq(String invoiceSeq) {
		this.invoiceSeq = invoiceSeq;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNetValue() {
		return netValue;
	}

	public void setNetValue(String netValue) {
		this.netValue = netValue;
	}

	public User getHeaderData() {
		return headerData;
	}

	public void setHeaderData(User headerData) {
		this.headerData = headerData;
	}

	public Set<Item> getSetItem() {
		return setItem;
	}

	public void setSetItem(Set<Item> setItem) {
		this.setItem = setItem;
	}

	public String getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(String availableQty) {
		this.availableQty = availableQty;
	}

	public String getInvoiceSeq() {
		return invoiceSeq;
	}

}