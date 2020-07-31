package com.thuchanhchuyensau.dto;

import java.util.List;

public class OrderDTO extends AbstractDTO<OrderDTO> {
	private List<CartDTO> cartDTOs;
	private CustomerDTO customerDTO;
	
	
	
	public List<CartDTO> getCartDTOs() {
		return cartDTOs;
	}
	public void setCartDTOs(List<CartDTO> cartDTOs) {
		this.cartDTOs = cartDTOs;
	}
	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	
	
}
