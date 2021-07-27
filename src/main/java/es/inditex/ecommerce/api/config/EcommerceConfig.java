package es.inditex.ecommerce.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import es.inditex.ecommerce.api.controller.ProductPriceController;
import es.inditex.ecommerce.api.persistence.repository.PriceRepository;
import es.inditex.ecommerce.api.service.ProductPriceService;
import es.inditex.ecommerce.api.service.ProductPriceServiceImpl;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = "es.inditex.ecommerce.api.persistence.repository")
public class EcommerceConfig {

	@Bean
	public ProductPriceController productPriceController(ProductPriceService priceService) {
		return new ProductPriceController(priceService);
	}

	@Bean
	public ProductPriceService productPriceService(PriceRepository priceRepository, ModelMapper modelMapper) {
		return new ProductPriceServiceImpl(priceRepository, modelMapper);
	}
	
}
