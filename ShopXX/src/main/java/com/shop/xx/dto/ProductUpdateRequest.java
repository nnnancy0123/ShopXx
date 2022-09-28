package com.shop.xx.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductUpdateRequest extends ProductAddRequest implements Serializable {

	/**
	 * ユーザーID
	 */
	@NotNull
	private int id;

	

}
