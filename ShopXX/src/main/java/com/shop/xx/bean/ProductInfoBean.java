package com.shop.xx.bean;

import java.sql.Date;

import lombok.Data;

/**
 * 商品情報 
 */
@Data
public class ProductInfoBean {

	private String id;

	private String name;

	private String showFlg;

	private String delFlg;

	private int sort;

	private Date dateCreated;

	private Date dateModified;

}
