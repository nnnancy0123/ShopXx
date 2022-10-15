package com.shop.xx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.xx.bean.ProductInfoBean;
import com.shop.xx.bean.UserInfoBean;

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
	 * @param productUpdateRequest 更新用リクエストデータ
	 */
	public void proInfoUpdate(ProductInfoBean productInfoBean);

	/**
	* 商品情報検索
	* @param product 検索用リクエストデータ
	* @return 検索結果
	*/
	public List<ProductInfoBean> searchProductInfo(String productNm);

	/**
	 * ユーザー情報登録
	 *
	 */
	public void newUserInfo(UserInfoBean userInfoBean);
	
}
