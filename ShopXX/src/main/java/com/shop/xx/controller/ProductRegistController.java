package com.shop.xx.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.xx.bean.ProductInfoBean;
import com.shop.xx.service.ShopXxService;

@Controller
public class ProductRegistController {
	@Autowired
	ShopXxService shopXxService;

	/*
	 * @return
	 * 
	 */
	@GetMapping("/ProductRegist")
	public ModelAndView register() {

		ModelAndView mav = new ModelAndView("ProductRegist");
		return mav;
	}

	/**
	 * 商品新規登録画面を表示
	 * @param price 
	 * @param inventory 
	 * @return 商品情報一覧画面
	 */
	@PostMapping("/ProductInfoList")
	public ModelAndView CreatInfo(@RequestParam int id, @RequestParam String name, @RequestParam int price,
			@RequestParam String image, @RequestParam int inventory,Model model,ProFileForm fileForm) {

		ProductInfoBean productInfoBean = new ProductInfoBean();
		productInfoBean.setId(id);
		productInfoBean.setName(name);
		productInfoBean.setPrice(price);
		productInfoBean.setInventory(inventory);
		productInfoBean.setImage(image);
		LocalDateTime localDateTime = LocalDateTime.now();
		productInfoBean.setDateCreated(localDateTime);
		productInfoBean.setDateModified(localDateTime);
		
		shopXxService.createProductInfo(productInfoBean);

		
		/**
		 * 商品情報一覧画面を表示
		 * @param model
		 * @return 商品情報一覧画面
		 */
		
		List<ProductInfoBean> productInfo = shopXxService.getProductInfo();
		model.addAttribute("getProductInfolist",productInfo);
		
		System.out.println("234");
		
		ModelAndView productInfoList = new ModelAndView("productInfoList");
		return productInfoList;
	}
	

}
