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

/**
 * 
 * @author user
 *
 */
@Controller
public class ProductRegistController {

	@Autowired
	ShopXxService shopXxService;

	/**
	 * @return
	 * 
	 */
	@GetMapping("/productRegist")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("productRegist");
		return mav;
	}

	/**
	 * 商品情報一覧画面を表示
	 * @param model
	 * @return 商品情報一覧画面
	 */
	@GetMapping("/productInfoList")
	public ModelAndView productInfoList(@RequestParam(name = "productNm", required = false) String productNm,Model model) {

		ModelAndView mav = new ModelAndView("productInfoList");

		List<ProductInfoBean> productInfo =  shopXxService.searchProductInfo(productNm);
		model.addAttribute("getProductInfolist", productInfo);
		return mav;

	}
	


	/**
	 * 商品新規登録画面を表示
	 * @param price 
	 * @param inventory 
	 * @return 商品情報一覧画面
	 */
	@PostMapping("/productInfoList")
	public String CreatProductInfo(@RequestParam int id, @RequestParam String name, @RequestParam int price,
			 @RequestParam String image, @RequestParam int inventory, Model model) {

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
		 return "redirect:/productInfoList";
	}

}
