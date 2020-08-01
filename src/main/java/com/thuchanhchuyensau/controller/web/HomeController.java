package com.thuchanhchuyensau.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thuchanhchuyensau.dto.AdvertingDTO;
import com.thuchanhchuyensau.dto.CartDTO;
import com.thuchanhchuyensau.dto.CategoryDTO;
import com.thuchanhchuyensau.dto.CommentDTO;
import com.thuchanhchuyensau.dto.CustomerDTO;
import com.thuchanhchuyensau.dto.NewDTO;
import com.thuchanhchuyensau.dto.OrderDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.dto.TagDTO;
import com.thuchanhchuyensau.dto.UserDTO;
import com.thuchanhchuyensau.service.IAdvertingService;
import com.thuchanhchuyensau.service.ICategoryService;
import com.thuchanhchuyensau.service.ICommentService;
import com.thuchanhchuyensau.service.INewService;
import com.thuchanhchuyensau.service.IProductService;
import com.thuchanhchuyensau.service.ITagService;
import com.thuchanhchuyensau.service.IUserService;
import com.thuchanhchuyensau.service.impl.CommentService;
import com.thuchanhchuyensau.util.MessageUtil;
import com.thuchanhchuyensau.util.SecurityUtils;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
		
	
		@Autowired
		private IAdvertingService advertingService;
		@Autowired
		private ICategoryService categoryService;
	
		@Autowired
		private IProductService productService;
		
		@Autowired
		private INewService newsService;
		
		@Autowired
		private ITagService tagService;
		
		
		@Autowired
		private MessageUtil messageUtil;
		@Autowired
		private IUserService userService;
		
		@Autowired
		private ICommentService commentService;
		
		
		
		
	
	  @RequestMapping(value = "/web/home", method = RequestMethod.GET)
	   public ModelAndView homePage() {
		  
	      ModelAndView mav = new ModelAndView("web/home");
	      
	      ProductDTO productDTO=new ProductDTO();
	      ProductDTO productDTO1=new ProductDTO();
	      AdvertingDTO advertingDTO=new AdvertingDTO();
	      CategoryDTO categoryDTO=new CategoryDTO();
	      NewDTO newDTO=new NewDTO();
	      
	      Pageable pageable=new PageRequest(0,4);
	      
	      advertingDTO.setListResult(advertingService.findAll(pageable));
	      productDTO1.setListResult(productService.findByGender("men"));
	      productDTO.setListResult(productService.findByGender("women"));
	      categoryDTO.setListResult(categoryService.findAll());
	      newDTO.setListResult(newsService.findall());
	      
	      mav.addObject("model",productDTO);
	      mav.addObject("model1",productDTO1);
	      mav.addObject("adverting",advertingDTO);
	      mav.addObject("category",categoryDTO);
	      mav.addObject("news",newDTO);
	      
	      
	      return mav;
	   }
	  
	  @RequestMapping(value = "/web/shop", method = RequestMethod.GET)
	  public ModelAndView shopPage() {
		  
		  
		   ModelAndView mav = new ModelAndView("web/ShopPage");
		   
		   ProductDTO productDTO=new ProductDTO();
		   TagDTO tagdto=new TagDTO();
		   
		   
		   
		   Pageable pageable=new PageRequest(0,6);
		   productDTO.setListResult(productService.findAll(pageable));
		   tagdto.setListResult(tagService.tags());
		   
		   
		   mav.addObject("model",productDTO);
		   mav.addObject("tags",tagdto);
		   
		   return mav;
		   
	  }
	  
	  
	  @RequestMapping(value = "/web/login", method = RequestMethod.GET)
	   public ModelAndView loginPage() {
	      ModelAndView mav = new ModelAndView("login");
	      return mav;
	   }
	  
	  @RequestMapping(value = "/web/register", method = RequestMethod.GET)
	   public ModelAndView RegisterPage(@RequestParam (required = false) String message) {
	      ModelAndView mav = new ModelAndView("register");
	      if(message!=null) {
	    	  Map<String,String> mess=messageUtil.getMessage(message);
	    	  	mav.addObject("message", mess.get("message"));
	    	  	mav.addObject("alert", mess.get("alert"));
	      }
	      return mav;
	   }
	  
	  @RequestMapping(value = "/web/product/{id}",method = RequestMethod.GET)
	  public ModelAndView ProductPage(@PathVariable("id") Long id ) {
		  ModelAndView mav=new ModelAndView("web/productDetail");
		  
		  ProductDTO productDTO= productService.findOneById(id);
		  
		  mav.addObject("model",productDTO);
		 
		  
		  return mav;
	  }
	  
	  @RequestMapping(value = "/web/new/{id}",method = RequestMethod.GET)
	  public ModelAndView NewPage(@PathVariable("id") Long id ) {
		  ModelAndView mav=new ModelAndView("web/NewsDetail");
		  
		 // ProductDTO productDTO= productService.findOneById(id);
		  
		 // mav.addObject("model",productDTO);
		 
		  
		  return mav;
	  }
	  
	  
	  @RequestMapping(value = "/web/cart",method = RequestMethod.GET)
	  public ModelAndView shoppingCartPage(HttpSession session) {  
//		  Object obj=session.getAttribute("myCartItems"); 
		  		  
		  ModelAndView mav=new ModelAndView("web/shoppingCart");
		
		  return mav;
	  }
	  
	  @RequestMapping(value ="/web/product/search",method = RequestMethod.GET)
	  public ModelAndView ProductSearch(@RequestParam ("keysearch") String key) {  
//		  Object obj=session.getAttribute("myCartItems"); 
		  ProductDTO dto=new ProductDTO();
		  
		  dto.setListResult(productService.findProductKey(key));
		    
		  ModelAndView mav=new ModelAndView("web/ShopPage");
		  
		  mav.addObject("model",dto);
		  	  
		  return mav;
	  }
	  
	  
	  @RequestMapping(value = "/web/comment/add",method = RequestMethod.GET)
	  public ModelAndView CommentAdd(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("content") String content,@RequestParam("id") Long id ) {
		  Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		  if(auth!=null) {
			  String user=auth.getName();
			  UserDTO userDTO=userService.findByUsername(user);
			  
			  CommentDTO commentdto=new CommentDTO();
			  commentdto.setContent(content);
			  commentdto.setUserDTO(userDTO);
			  
			  String rs=commentService.save(commentdto,id);
			  
		  }
	  
		
		  return new ModelAndView("redirect:/web/product/"+id+"");
	  }
	  
	  @RequestMapping(value = "/web/checkout",method = RequestMethod.GET)
	  	public ModelAndView PageCheckout() {
		  ModelAndView mav=new ModelAndView("web/Checkout");
		  
		  mav.addObject("customer",new CustomerDTO());
		  return mav;
	  }
	  
	  @RequestMapping(value = "/web/checkout",method = RequestMethod.POST)
	  	public ModelAndView DoCheck(@ModelAttribute("customer") CustomerDTO customerDTO,HttpSession httpSession,HttpServletRequest request) {
		  	
		 httpSession=request.getSession();
		  HashMap<Long, CartDTO> cartItems = (HashMap<Long, CartDTO>) httpSession.getAttribute("myCartItems");
		  System.out.println(cartItems);
		
		  
  
		 OrderDTO orderDTO=new OrderDTO();
		 
		  
		  
		  
		  
		 
		  httpSession.invalidate();
		  ModelAndView mav=new ModelAndView("redirect:/web/checkout");
		  return mav;
	  }
	  
	  
	  
	  @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
		public ModelAndView pageEror() {
			return new ModelAndView("redirect:/web/login?accessDenied");
		}
	  
	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
		public ModelAndView logoutPage(HttpServletRequest request,HttpServletResponse response) {
		  Authentication auth= SecurityContextHolder.getContext().getAuthentication();	  
		  if(auth!=null) {	
			  new SecurityContextLogoutHandler().logout(request, response, auth);
		  }
			return new ModelAndView("redirect:/web/home");
		}
}
