package com.shop.xx;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.xx.bean.ProductInfoBean;
import com.shop.xx.service.ShopXxService;

@SpringBootTest
public class ShopXxServiceTest {

	@Autowired
	ShopXxService shopXxService;

	/**
	商品情報検索
	*/
	@Test
	void testCase001() {

		List<ProductInfoBean> list = shopXxService.searchProductInfo("フルーツティー");

		assertTrue(1 == list.size());
	}

	/**
	* 商品情報主キー検索
	*/
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testFindById() {

		ProductInfoBean productInfoBean = shopXxService.findById(1);
		assertTrue(70 == productInfoBean.getInventory());
		assertEquals("黒糖ミルク",productInfoBean.getName());
		assertEquals(520,productInfoBean.getPrice());
		
	}

	/**
	*  商品情報取得
	*/
	@Test
	void testgetProductInfo() {
		List<ProductInfoBean> getProductInfo = shopXxService.getProductInfo();
		assertTrue(11 == getProductInfo.size());
	}
	/**
	*  商品情報取得
	*/
}
