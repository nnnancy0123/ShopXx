package com.shop.xx.bean;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserInfoBean {

	@NotBlank
	private String userName;

	private int userPassword;

	private String userType;
}
