package com.shop.xx.service;

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

}
