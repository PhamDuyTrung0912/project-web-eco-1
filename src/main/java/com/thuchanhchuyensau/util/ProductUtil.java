package com.thuchanhchuyensau.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.entity.ProductEntity;


@Component
public class ProductUtil {
	
	public List<Long> toLong(List<ProductEntity> listProducts){
		List<Long> ids=new ArrayList<Long>();
		for(ProductEntity entity :listProducts) {
			Long id=entity.getId();
			ids.add(id);
		}
		
		return ids;
	}
}
