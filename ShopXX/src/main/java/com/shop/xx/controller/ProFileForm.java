package com.shop.xx.controller;

import org.springframework.web.multipart.MultipartFile;

public class ProFileForm {
	private MultipartFile mFile;

	public MultipartFile getMultipartFile() {
		return mFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.mFile = multipartFile;
	}

}
