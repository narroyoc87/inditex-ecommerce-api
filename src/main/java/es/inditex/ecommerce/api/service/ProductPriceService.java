package es.inditex.ecommerce.api.service;

import es.inditex.ecommerce.api.model.ProductPriceDTO;
import es.inditex.ecommerce.api.model.ProductPriceFilterDTO;

public interface ProductPriceService {
	ProductPriceDTO findProductPrice(final ProductPriceFilterDTO productPriceFilterDTO );
}
