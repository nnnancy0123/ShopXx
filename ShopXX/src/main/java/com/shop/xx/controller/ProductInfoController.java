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
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView displayEdit(@PathVariable int id, Model model) {

		ProductInfoBean product = shopXxService.findById(id);
		ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
		productUpdateRequest.setProductId(product.getId());
		productUpdateRequest.setName(product.getName());
		productUpdateRequest.setSimpleDesc(product.getSimpleDesc());
		productUpdateRequest.setPrice(product.getPrice());
		productUpdateRequest.setInventory(product.getInventory());
		productUpdateRequest.setImage(product.getImage());
		productUpdateRequest.setDateCreated(product.getDateCreated());
		productUpdateRequest.setDateModified(product.getDateModified());
		
		model.addAttribute("productUpdateRequest", productUpdateRequest);
		ModelAndView mav = new ModelAndView("productInfoEdit");
		return mav;

	}
	
    /**
     * 商品更新
     * @param productUpdateRequest リクエストデータ
     * @param model Model
     * @return 商品詳細情報画面
     */
    @RequestMapping(value = "/productInfoUpdate", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute ProductUpdateRequest productUpdateRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "redirect:/productInfoEdit";
        }
        
        // ユーザー情報の更新
        shopXxService.proInfoUpdate(productUpdateRequest);
        return "redirect:/productInfoList";
    }
	
    /**
     * 商品名検索
     * @param productSearchRequest リクエストデータ
     * @param model Model
     * @return 商品情報一覧画面
     */
//    @RequestMapping(value = "/productInfoSearch", method = RequestMethod.POST)
//    public String productInfoSearch(@PathVariable @ModelAttribute String productNm, Model model) {
//    	
//       List<ProductInfoBean> productInfoSearchList = shopXxService.searchProductInfo(productNm);
//       
//       ProductSearchRequest productSearchRequest = new ProductSearchRequest();
//       productSearchRequest.setProductNm(productNm);
//       
//        model.addAttribute("getProductInfoSearchList", productInfoSearchList);
//        
//        return "redirect:/ProductInfoSearch";
//    }
    
}
