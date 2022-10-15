package com.shop.xx.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserInfoDto implements Serializable {

	/**
	  * 名前
	  */
	@NotEmpty(message = "名前を入力してください")
	@Size(max = 5, message = "名前は100桁以内で入力してください")
	private String userName;

	@NotEmpty(message = "名前を入力してください")
	private int userPassword;

	@NotEmpty(message = "名前を入力してください")
	private String userType;
	
}
