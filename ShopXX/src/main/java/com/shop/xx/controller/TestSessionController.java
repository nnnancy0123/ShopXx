package com.shop.xx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.xx.bean.UserInfoBean;

@Controller
public class TestSessionController {

	@Autowired
	HttpSession session;

	@GetMapping("/testSession")
	public ModelAndView testSession() {
		ModelAndView mav = new ModelAndView("testSession");

		return mav;
	}

	@PostMapping("/testSessionReg")
	public String testSessionReg(@RequestParam String userName, @RequestParam int userPassword,
			@RequestParam String userType) {

		System.out.println(userName);
		System.out.println(userPassword);
		System.out.println(userType);
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setUserName(userName);
		userInfoBean.setUserPassword(userPassword);
		userInfoBean.setUserType(userType);

		session.setAttribute("userInfoBean", userInfoBean);

		return "redirect:/testResult";
	}

	@GetMapping("/testResult")
	public ModelAndView testResult() {
		ModelAndView mav = new ModelAndView("testResult");
		UserInfoBean userInfoBean = (UserInfoBean) session.getAttribute("userInfoBean");
		System.out.println(userInfoBean.getUserName());
		System.out.println(userInfoBean.getUserPassword());
		System.out.println(userInfoBean.getUserType());

		return mav;
	}

}
