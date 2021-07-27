package es.inditex.ecommerce.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.inditex.ecommerce.api.model.ProductPriceDTO;
import es.inditex.ecommerce.api.model.ProductPriceFilterDTO;
import es.inditex.ecommerce.api.service.ProductPriceService;

@RestController
@RequestMapping("/prices")
public class ProductPriceController {
	
	private ProductPriceService productPriceService;
	public  ProductPriceController(ProductPriceService productPriceService) {
		this.productPriceService = productPriceService;
	}
	
	@GetMapping
	public ResponseEntity<ProductPriceDTO> findProductPrice( @Valid ProductPriceFilterDTO productPriceFilterDTO ){
		final ProductPriceDTO productPriceDTO = productPriceService.findProductPrice( productPriceFilterDTO );
        if( null != productPriceDTO ) {
        	return ResponseEntity.status(HttpStatus.OK).body(productPriceDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
		

}
