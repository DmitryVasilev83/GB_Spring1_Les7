package ru.gb.gb_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.gb_shop.service.ProductService;

@SpringBootApplication
public class ShopApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShopApp.class, args);
		ProductService productService = context.getBean(ProductService.class);
	}

}
