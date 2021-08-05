package es.inditex.ecommerce.api.service;

import java.util.Optional;

import es.inditex.ecommerce.api.model.ProductPriceDTO;
import es.inditex.ecommerce.api.model.ProductPriceFilterDTO;

public interface ProductPriceService {
	Optional<ProductPriceDTO> findProductPrice(final ProductPriceFilterDTO productPriceFilterDTO );
}
