package com.shop.xx.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
public class ProductAddRequest implements Serializable{

    /**
     * 名前
     */
    @NotEmpty(message = "名前を入力してください")
    private String name;
    
}
