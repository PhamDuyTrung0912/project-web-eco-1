package com.thuchanhchuyensau.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.thuchanhchuyensau.dto.CategoryDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.service.ICategoryService;
import com.thuchanhchuyensau.service.IProductService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	
		@Autowired
		private IProductService productService;
		
		@Autowired
		private ICategoryService categoryService;
		
		
		@InitBinder
		   public void initBinder(WebDataBinder dataBinder) {
		       Object target = dataBinder.getTarget();
		       if (target == null) {
		           return;
		       }
		       System.out.println("Target=" + target);
		 
		       if (target.getClass() == ProductDTO.class) {
		  
		           // Đăng ký để chuyển đổi giữa các đối tượng multipart thành byte[]
		           dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		       }
		   }
		
	
	  @RequestMapping(value ="/admin/home", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("admin/home");
	      return mav;
	   }
	  
	  @RequestMapping(value ="/admin/create", method = RequestMethod.GET)
	   public ModelAndView CreatePage() {
		  CategoryDTO categoryDTO=new CategoryDTO();
		 
		  categoryDTO.setListResult(categoryService.findAll());
	      ModelAndView mav = new ModelAndView("admin/actionProduct");
	      
	      mav.addObject("categories", categoryDTO);
	      mav.addObject("product",new ProductDTO());
	      return mav;
	   }
	  
	  @RequestMapping(value ="/admin/create", method = RequestMethod.POST)
	  public ModelAndView doCreatePage(@ModelAttribute("product") ProductDTO product,HttpServletRequest request) {
		  
		  return this.doUpload(request, product);
		  
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
	  
	  
	  
	  private ModelAndView doUpload(HttpServletRequest request, //
	           ProductDTO productDTO) {
	 
	       
	 
	       // Thư mục gốc upload file.
	       String uploadRootPath = "D:\\Spring MVC\\btl\\src\\main\\webapp\\assets\\image";
	       System.out.println("uploadRootPath=" + uploadRootPath);
	 
	       File uploadRootDir = new File(uploadRootPath);
	       //
	       // Tạo thư mục gốc upload nếu nó không tồn tại.
	       if (!uploadRootDir.exists()) {
	           uploadRootDir.mkdirs();
	       }
	       CommonsMultipartFile[] fileData = productDTO.getNameImage();
	       //
		       
	 
	           // Tên file gốc tại Client.
	           String name = fileData[0].getOriginalFilename();
	           System.out.println("Client File Name = " + name);
	 
	           if (name != null && name.length() > 0 ) {
	               try {	
	                   // Tạo file tại Server.
	                   File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
	                   	
	                   
	                   
	                   
	                   
	                   // Luồng ghi dữ liệu vào file trên Server.
	                   FileOutputStream stream = new FileOutputStream(serverFile);
	                   stream.write(fileData[0].getBytes());
	                   stream.close();
	                   //
	                  
	                   System.out.println("Write file: " + serverFile);
	               } catch (Exception e) {
	                   System.out.println("Error Write file: " + name);
	               }
	           }
	       
	      String temp=name.substring(0,name.length()-4);
	      System.out.println("name = " + temp);
	       productDTO.setImageProduct(temp);
	       
	       productService.save(productDTO);
	       
	       ModelAndView mav = new ModelAndView("redirect:/admin/list/product");
		      return mav;
	       
	   }
	  
	  
	  
	  
	  
}