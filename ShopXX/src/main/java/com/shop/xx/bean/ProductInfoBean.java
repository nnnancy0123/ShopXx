package com.shop.xx.bean;
import java.time.LocalDateTime;

import lombok.Data;
/**
 * 商品情報 
 */
@Data
public class ProductInfoBean {
	
	private int id;

	private String name;

	private String simpleDesc;
	
	private int price;
	
	private int inventory;
	
	private String image;

	private String showFlg;

	private String delFlg;

	private LocalDateTime dateCreated;

	private LocalDateTime dateModified;

}
