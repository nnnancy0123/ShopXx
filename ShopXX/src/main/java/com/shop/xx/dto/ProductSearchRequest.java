package com.shop.xx.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Data
public class ProductSearchRequest implements Serializable  {
	
	 /**
     * 名前
     */
    private String productNm;
 
}
