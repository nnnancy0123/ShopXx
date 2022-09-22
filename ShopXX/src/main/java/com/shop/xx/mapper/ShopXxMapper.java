package com.shop.xx.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.shop.xx.bean.ProductInfoBean;


@Mapper
public interface ShopXxMapper {
	
	/**
	 * 商品情報登録
	 */
	public void newProductInfo(ProductInfoBean ProductInfoBean);
	
}
