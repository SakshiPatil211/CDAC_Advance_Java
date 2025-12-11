package com.demo.FullStackProductWebApp.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.FullStackProductWebApp.beans.*;
import com.demo.FullStackProductWebApp.dto.*;

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


