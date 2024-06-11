package aoptest.service;

import org.springframework.stereotype.Service;
import aoptest.vo.ProductVo;

@Service
public class ProductService {

	public ProductVo find(String name) {
		System.out.println("product Service");
		return new ProductVo(name);
	}
	
}
