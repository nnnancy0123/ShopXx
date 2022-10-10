package com.shop.xx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.xx.bean.ProductInfoBean;
import com.shop.xx.dto.ProductUpdateRequest;
import com.shop.xx.mapper.ShopXxMapper;

@Service
public class ShopXxService {

	@Autowired
	ShopXxMapper shopXxMapper;

	/**
	 * 商品情報登録
     * 
     */
	public void createProductInfo(ProductInfoBean productInfoBean) {
		shopXxMapper.newProductInfo(productInfoBean);
	}

	/**
	 * 商品情報取得
     * ＠return取得結果
     */
	 public List<ProductInfoBean> getProductInfo(){
		 return shopXxMapper.getProductInfo();
	 }
	 
		/**
	     * 商品情報主キー検索
	     * @return 検索結果
	     */
	 public ProductInfoBean findById(int Id) {
		return shopXxMapper.findById(Id);
		 
	 }
	 
	 
	    /**
	     * 商品情報更新
	     * @param productUpdateRequest 更新用リクエストデータ
	     */
	 public  void proInfoUpdate(ProductUpdateRequest productUpdateRequest) {
		 
		 ProductInfoBean productInfoBean = new ProductInfoBean();
		 productInfoBean.setId(productUpdateRequest.getProductId());
		 productInfoBean.setName(productUpdateRequest.getName());
		 productInfoBean.setSimpleDesc(productUpdateRequest.getSimpleDesc());
		 productInfoBean.setPrice(productUpdateRequest.getPrice());
		 productInfoBean.setInventory(productUpdateRequest.getInventory());
		 productInfoBean.setImage(productUpdateRequest.getImage());
		 productInfoBean.setDateCreated(productUpdateRequest.getDateCreated());
		 productInfoBean.setDateModified(productUpdateRequest.getDateModified());
		 shopXxMapper.proInfoUpdate(productInfoBean);
		 
	 }
	 
	    /**
	     * 商品情報検索
	     * @param productNm
	     * @return 検索結果
	     */
	 public List<ProductInfoBean> searchProductInfo(String productNm) {
		
		  return shopXxMapper.searchProductInfo(productNm);
	 }
	    
}
