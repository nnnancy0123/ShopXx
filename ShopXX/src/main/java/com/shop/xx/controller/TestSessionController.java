package com.shop.xx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shop.xx.bean.UserInfoBean;
import com.shop.xx.dto.UserInfoDto;

@Controller
public class TestSessionController {

	@Autowired
	HttpSession session;

	/**
	 * @mav
	 */
	@GetMapping("/testSession")
	public ModelAndView testSession(Model model) {
		ModelAndView mav = new ModelAndView("testSession");
		model.addAttribute("userInfoForm", new UserInfoDto());
		return mav;
	}

	//@PostMapping("/testSessionReg")
	@RequestMapping(value="/testSessionReg", method=RequestMethod.POST)
	public String testSessionReg(@ModelAttribute @Validated UserInfoDto userInfoDto, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "/testSession";
		}

		UserInfoBean userInfoBean = new UserInfoBean();
		//		userInfoBean.setUserName(userName);
		//		userInfoBean.setUserPassword(userPassword);
		//		userInfoBean.setUserType(userType);

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
