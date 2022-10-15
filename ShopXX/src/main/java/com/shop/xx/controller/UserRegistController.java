package com.shop.xx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.xx.bean.UserInfoBean;
import com.shop.xx.service.ShopXxService;

@Controller
public class UserRegistController {
	@Autowired
	HttpSession session;
	@Autowired
	ShopXxService shopXxService;

	/**
	 * ユーザー登録画面表示
	 * @return mav
	 */
	@GetMapping("/userRegist")
	public ModelAndView userRigist() {
		ModelAndView mav = new ModelAndView("userRegist");
		return mav;
	}

	/**
	 * ユーザー新規登録画面の値をセッションする
	 * @param userName 
	 * @param userPassword 
	 * @param userType
	 * @return ユーザー情報一覧画面
	 */
	@PostMapping("/userInfoList")
	public String createUserInfo(@RequestParam String userName, @RequestParam int userPassword,
			@RequestParam String userType) {
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setUserName(userName);
		userInfoBean.setUserPassword(userPassword);
		userInfoBean.setUserType(userType);

		session.setAttribute("userInfoBean", userInfoBean);
		System.out.println(userInfoBean.getUserName());
		System.out.println(userInfoBean.getUserPassword());
		System.out.println(userInfoBean.getUserType());
		
		shopXxService.createUserInfo(userInfoBean);
		return "redirect:/userInfoList";
	}

	/**
	 * ユーザー新規登録画面の値を取得
	 * @param userName 
	 * @param userPassword 
	 * @param userType
	 * @return mav
	 */
	@GetMapping("/userInfoList")
	public ModelAndView userInfolist() {
		ModelAndView mav = new ModelAndView("userInfoList");
		UserInfoBean userInfoBean = (UserInfoBean) session.getAttribute("userInfoBean");
		System.out.println(userInfoBean.getUserName());
		System.out.println(userInfoBean.getUserPassword());
		System.out.println(userInfoBean.getUserType());
		return mav;

	}

}
