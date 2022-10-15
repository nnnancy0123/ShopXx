package com.shop.xx.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.xx.bean.UserInfoBean;
import com.shop.xx.service.ShopXxService;

@Controller
public class UserRegistController {

	@Autowired
	ShopXxService shopXxService;

	/**
	 * ユーザー新規登録画面を表示
	 * @param price 
	 * @param inventory 
	 * @return 
	 * @return 商品情報一覧画面
	 */
	@PostMapping("/userInfoList")
	public String createUserInfo(@RequestParam String userName, @RequestParam int userPassword,
			@RequestParam String userType, Model model) {
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setUserName(userName);
		userInfoBean.setUserPassword(userPassword);
		userInfoBean.setUserType(userType);
		shopXxService.createUserInfo(userInfoBean);
		
		return "redirect:/userInfoList";

	}
}
