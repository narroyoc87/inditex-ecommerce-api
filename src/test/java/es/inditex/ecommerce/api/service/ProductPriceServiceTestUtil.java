package es.inditex.ecommerce.api.service;

import java.time.LocalDateTime;
import java.util.Date;

import es.inditex.ecommerce.api.model.ProductPriceFilterDTO;
import es.inditex.ecommerce.api.persistence.entity.Price;
import es.inditex.ecommerce.api.persistence.entity.PricePK;

public class ProductPriceServiceTestUtil {
	private static final Long PRODUCT_ID = 35455L;
	private static final Long BRAND_ID = 1l;

	public static ProductPriceFilterDTO mockProductPriceFilterDTO(LocalDateTime searchDate) {
		return ProductPriceFilterDTO.builder().productId(PRODUCT_ID).brandId(BRAND_ID).date(searchDate).build();
	}

	public static Price mockPrice(Integer priceListId, Date startDate, Date endDate, Integer priority, Double finalPrice) {
		Price price = new Price();
		price.setFinalPrice(finalPrice);
		price.setId(mockPK(priceListId, startDate, endDate));
		price.setPriority(priority);
		return price;
	}

	private static PricePK mockPK(Integer priceListId, Date startDate, Date endDate) {
		PricePK pk = new PricePK();
		pk.setBrandId(BRAND_ID);
		pk.setProductId(PRODUCT_ID);
		pk.setPriceListId(priceListId);
		pk.setStartDate(startDate);
		pk.setEndDate(endDate);
		return pk;
	}
}
