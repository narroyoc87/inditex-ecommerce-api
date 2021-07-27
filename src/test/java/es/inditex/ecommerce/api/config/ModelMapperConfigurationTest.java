package es.inditex.ecommerce.api.config;

import static es.inditex.ecommerce.api.service.ProductPriceServiceTestUtil.mockPrice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import es.inditex.ecommerce.api.model.ProductPriceDTO;
import es.inditex.ecommerce.api.persistence.entity.Price;
@ExtendWith(MockitoExtension.class)
public class ModelMapperConfigurationTest {
	private ModelMapper mapper;

	  @BeforeEach
	  public void setup() {
	    mapper = new ModelMapperConfiguration().modelMapper();
	  }
	
	private static final Date START_DATE_RANGE1 = Date
			.from(LocalDateTime.now().minusDays(2L).atZone(ZoneId.systemDefault()).toInstant());
	private static final Date END_DATE_RANGE1 = Date
			.from(LocalDateTime.now().plusDays(2L).atZone(ZoneId.systemDefault()).toInstant());
	private static final Integer PRIORITY_0 = 0;
	private static final Double FINAL_PRICE_1 = 45.45;
	@Test
	public void priceConverterShouldBeCorrect() {
		Price price = mockPrice(1, START_DATE_RANGE1, END_DATE_RANGE1, PRIORITY_0, FINAL_PRICE_1);
		ProductPriceDTO productPriceDTO = mapper.map(price, ProductPriceDTO.class);
		
		assertEquals(price.getId().getBrandId().compareTo(productPriceDTO.getBrandId()), 0);
		assertEquals(price.getId().getProductId().compareTo(productPriceDTO.getProductId()), 0);
		assertEquals(price.getId().getPriceListId().compareTo(productPriceDTO.getPriceList()), 0);
		assertTrue((price.getId().getStartDate().toInstant().atZone(ZoneId.systemDefault())).toLocalDateTime().isEqual(productPriceDTO.getStartDatePrice()));
		assertTrue((price.getId().getEndDate().toInstant().atZone(ZoneId.systemDefault())).toLocalDateTime().isEqual(productPriceDTO.getEndDatePrice()));
		assertEquals(price.getFinalPrice().compareTo(productPriceDTO.getPrice()), 0);
	}
}
