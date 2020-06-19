package com.thuchanhchuyensau.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thuchanhchuyensau.dto.CartDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.service.impl.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	 @RequestMapping(value = "/web/cart/add", method = RequestMethod.GET)
	    public ModelAndView viewAdd( HttpSession session, @RequestParam("id") long id,@RequestParam("quantity") int quantity) {
	        HashMap<Long, CartDTO> cartItems = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
	        if (cartItems == null) {
	            cartItems = new HashMap<>();
	        }
	        ProductDTO product = productService.findOneById(id);
	        if (product != null) {
	            if (cartItems.containsKey(id)) {
	            	CartDTO item = cartItems.get(id);
	                item.setProduct(product);
	                item.setQuantity(item.getQuantity()+1);
	                cartItems.put(id, item);
	            } else {
	            	CartDTO item = new CartDTO();
	                item.setProduct(product);
	                item.setQuantity(quantity);
	                cartItems.put(id, item);
	            }
	        }
	        session.setAttribute("myCartItems", cartItems);
	        session.setAttribute("myCartTotal", totalPrice(cartItems));
	        session.setAttribute("myCartNum", cartItems.size());
	      return  new ModelAndView("redirect:/web/cart");
	        
	    }
	 
	 @RequestMapping(value = "/web/sub", method = RequestMethod.GET)
	    public ModelAndView viewUpdate(ModelMap mm, HttpSession session) {
	        HashMap<Long, CartDTO> cartItems = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
	        if (cartItems == null) {
	            cartItems = new HashMap<>();
	        }
	        session.setAttribute("myCartItems", cartItems);
	        return  new ModelAndView("redirect:/web/cart");
	       
	    }
	    
	 
	 @RequestMapping(value = "/web/remove/{productId}", method = RequestMethod.GET)
	    public ModelAndView viewRemove(ModelMap mm, HttpSession session, @PathVariable("productId") long productId) {
	        HashMap<Long, CartDTO> cartItems = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
	        if (cartItems == null) {
	            cartItems = new HashMap<>();
	        }
	        if (cartItems.containsKey(productId)) {
	            cartItems.remove(productId);
	        }
	        session.setAttribute("myCartItems", cartItems);
	        session.setAttribute("myCartTotal", totalPrice(cartItems));
	        session.setAttribute("myCartNum", cartItems.size());
	        
	        return  new ModelAndView("redirect:/web/cart");
	      
	    }
	 
	 
	 public double totalPrice(HashMap<Long, CartDTO> cartItems) {
	        int count = 0;
	        for (Map.Entry<Long, CartDTO> list : cartItems.entrySet()) {
	            count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
	        }
	        return count;
	    }
}
