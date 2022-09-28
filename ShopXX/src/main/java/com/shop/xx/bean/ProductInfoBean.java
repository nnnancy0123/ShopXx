package com.shop.xx.bean;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
/**
 * 商品情報 
 */

@Entity
@Data
public class ProductInfoBean {
	@Id   //主キー
	@GeneratedValue   //自動採番される
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
