package com.shop.xx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.xx.bean.ProductInfoBean;
import com.shop.xx.dto.ProductUpdateRequest;
import com.shop.xx.service.ShopXxService;

@Controller
public class ProductInfoController {

	@Autowired
	ShopXxService shopXxService;
	
	/**
	 * 商品詳細画面を表示
	 * @param 商品ID
	 * @param model Model
	 * @return  商品情報詳細画面
	 */
	@GetMapping("/productInfoDetail/{id}")
	public String displayEdit(@PathVariable int id, Model model) {

		ProductInfoBean product = shopXxService.findById(id);
		ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
		productUpdateRequest.setId(product.getId());
		productUpdateRequest.setName(product.getName());
		productUpdateRequest.setPrice(product.getPrice());
		productUpdateRequest.setInventory(product.getInventory());
		productUpdateRequest.setImage(product.getImage());
		productUpdateRequest.setDateCreated(product.getDateCreated());
		productUpdateRequest.setDateModified(product.getDateModified());
		
		model.addAttribute("productUpdate", productUpdateRequest);

		return "/productInfoEdit";

	}
	
    /**
     * 商品更新
     * @param productUpdateRequest リクエストデータ
     * @param model Model
     * @return 商品詳細情報画面
     */
    @RequestMapping(value = "proInfoUpdate", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute ProductUpdateRequest productUpdateRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "user/edit";
        }
        // ユーザー情報の更新
        shopXxService.proInfoUpdate(productUpdateRequest);
        return "redirect:/ProductInfoList";
    }
	
}
