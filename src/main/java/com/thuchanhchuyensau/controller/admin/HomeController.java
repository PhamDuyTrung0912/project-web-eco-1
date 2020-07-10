package com.thuchanhchuyensau.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.service.IProductService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	
		@Autowired
		private IProductService productService;
	
	  @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("admin/home");
	      return mav;
	   }
	  
	  @RequestMapping(value = "/admin/create/product", method = RequestMethod.GET)
	   public ModelAndView CreatePage() {
	      ModelAndView mav = new ModelAndView("admin/actionProduct");
	      return mav;
	   }
	  
	  @RequestMapping(value = "/admin/update/{id}", method = RequestMethod.GET)
	   public ModelAndView UpdatePage(@PathVariable("id") Long id) {
		  
		  ProductDTO dto= productService.findOneById(id);  
	      ModelAndView mav = new ModelAndView("admin/actionProduct");
	      mav.addObject("model",dto);
	      return mav;
	   }
	  
	  @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
	   public ModelAndView DeletePage(@PathVariable("id") Long id) {
		  
		  productService.deleteProduct(id);
	      ModelAndView mav = new ModelAndView("redirect:/admin/list/product");
	      return mav;
	   }
	  
	  
	  @RequestMapping(value = "/admin/list/product", method = RequestMethod.GET)
	   public ModelAndView ListProductPage() {
		  
		  ProductDTO dto=new ProductDTO();
		
		  
		  dto.setListResult(productService.findAllProduct());
		  
	      ModelAndView mav = new ModelAndView("admin/ListProduct");
	      
	      mav.addObject("modal", dto);
	      return mav;
	   }
	  
}