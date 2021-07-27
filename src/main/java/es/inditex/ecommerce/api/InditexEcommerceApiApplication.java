package es.inditex.ecommerce.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"es.inditex.ecommerce.api.persistence.entity"})
public class InditexEcommerceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InditexEcommerceApiApplication.class, args);
	}

}
