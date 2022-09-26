package com.shop.xx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.xx.bean.ProductInfoBean;
import com.shop.xx.mapper.ShopXxMapper;

@Service
public class ShopXxService {

	@Autowired
	ShopXxMapper shopXxMapper;

	/**
	 * 商品情報登録
     * 
     */
	public void createProductInfo(ProductInfoBean ProductInfoBean) {
		shopXxMapper.newProductInfo(ProductInfoBean);
	}

	/**
	 * 商品情報取得
     * ＠return取得結果
     */
	 public List<ProductInfoBean> getProductInfo(){
		 return shopXxMapper.getProductInfo();
	 }
}
