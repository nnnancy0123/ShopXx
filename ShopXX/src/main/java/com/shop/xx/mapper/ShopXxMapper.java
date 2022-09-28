package com.shop.xx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.xx.bean.ProductInfoBean;
import com.shop.xx.dto.ProductUpdateRequest;

@Mapper
public interface ShopXxMapper {

	/**
	 * 商品情報登録
	 */
	public void newProductInfo(ProductInfoBean ProductInfoBean);

	/**
	 * 商品情報一覧取得
	 */
	public List<ProductInfoBean> getProductInfo();

	/**
	 * 商品情報主キー検索
	 */
	public ProductInfoBean findById(int Id);
	

    /**
     * 商品情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
	public  void proInfoUpdate(ProductUpdateRequest productUpdateRequest);
    
    
}
