package com.demo.SpringBootRestful.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.SpringBootRestful.beans.Product;
import com.demo.SpringBootRestful.dto.ProductDto;

public class ProductDtoMapper {
	public record mapToProductDto() {

	}

	public static Product mapToProduct(ProductDto p) {
		return new Product(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),LocalDate.parse(p.getLdtstr(),DateTimeFormatter.ofPattern("dd/MM/yyyy")),p.getCid());
	}
	
	public static ProductDto mapToProductDto(Product p) {
		if(p.getMfgdate()==null) {
			return new ProductDto(p.getPid(), p.getPname(), p.getQty(), p.getPrice(),null, p.getCid());
		} else {
			return new ProductDto(p.getPid(), p.getPname(), p.getQty(), p.getPrice(), p.getMfgdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), p.getCid());
		}
	}
}


