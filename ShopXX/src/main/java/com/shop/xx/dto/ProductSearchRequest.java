package com.shop.xx.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

public class ProductSearchRequest implements Serializable  {
	/**
	 * 商品番号
	 */
	@NotNull
	private int ProductId;
	
	 /**
     * 名前
     */
    private String name;
    /**
     * 紹介
     */
	private String simpleDesc;
	/**
     * 価格
     */
	private int price;
	/**
     * 在庫
     */
	private int inventory;
	/**
     * イメージ
     */
	private String image;
	/**
     * 販売
     */
	private String showFlg;
	/**
     * 品切れ
     */
	private String delFlg;
	/**
     * 編集時間
     */
	private LocalDateTime dateCreated;
	/**
     *更新時間
     */
	private LocalDateTime dateModified;

	

	    
}
