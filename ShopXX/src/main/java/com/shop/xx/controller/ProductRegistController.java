package com.shop.xx.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	 * 
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
	 * @param model Model
	 * @return 商品情報一覧画面
	 */
	@PostMapping("/userInfoList")
	public ModelAndView CreatInfo(@RequestParam String id, @RequestParam String name, @RequestParam String showFlg, 
		@RequestParam String delFlg, @RequestParam int sort, @RequestParam Date dateCreated, @RequestParam Date dateModifiedf) {
		
		ProductInfoBean productInfoBean = new ProductInfoBean();
		productInfoBean.setId(id);
		productInfoBean.setName(name);
		productInfoBean.setShowFlg(showFlg);
		productInfoBean.setDelFlg(delFlg);
		productInfoBean.setSort(sort);
		productInfoBean.setDateCreated(dateCreated);
		productInfoBean.setDateModified(dateModifiedf);

		shopXxService.createProductInfo(productInfoBean);
		ModelAndView userInfoList = new ModelAndView("ProductInfoList");
		return null ;
		
	}
}
