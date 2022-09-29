package com.shop.xx.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Setter
@Getter
public class ProductUpdateRequest implements Serializable {

	/**
	 * ユーザーID
	 */
	@NotNull
	private int productId;
	
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
     * いめーじ
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
