package es.inditex.ecommerce.api.service;

import static es.inditex.ecommerce.api.service.ProductPriceServiceTestUtil.mockPrice;
import static es.inditex.ecommerce.api.service.ProductPriceServiceTestUtil.mockProductPriceFilterDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import es.inditex.ecommerce.api.config.ModelMapperConfiguration;
import es.inditex.ecommerce.api.model.ProductPriceDTO;
import es.inditex.ecommerce.api.persistence.repository.PriceRepository;
@ExtendWith( MockitoExtension.class )
public class ProductPriceServiceTest {

	ProductPriceServiceImpl productPriceService;
	@Mock
	PriceRepository priceRepository;
	private ModelMapper mapper;

	private static final Date START_DATE_RANGE1 = Date
			.from(LocalDateTime.now().minusDays(2L).atZone(ZoneId.systemDefault()).toInstant());
	private static final Date END_DATE_RANGE1 = Date
			.from(LocalDateTime.now().plusDays(2L).atZone(ZoneId.systemDefault()).toInstant());
	private static final Date START_DATE_RANGE2 = Date
			.from(LocalDateTime.now().minusDays(1L).atZone(ZoneId.systemDefault()).toInstant());
	private static final Date END_DATE_RANGE2 = Date
			.from(LocalDateTime.now().plusDays(3L).atZone(ZoneId.systemDefault()).toInstant());
	private static final Integer PRIORITY_0 = 0;
	private static final Integer PRIORITY_1 = 1;
	private static final Double FINAL_PRICE_1 = 45.45;
	private static final Double FINAL_PRICE_2 = 50.75;

	@BeforeEach
	public  void setup() {
		mapper = new ModelMapperConfiguration().modelMapper();
		productPriceService = new ProductPriceServiceImpl(priceRepository, mapper);
	}
	
	@Test
	public void shouldBeNull() {
		Optional<ProductPriceDTO> result = productPriceService.findProductPrice(mockProductPriceFilterDTO(LocalDateTime.now()));
		assertTrue(result.isEmpty());
	}

	@Test
	public void shouldBeNotNull() {
		when(priceRepository.findProductPriceAtMoment(anyLong(), any(Date.class), anyLong()))
				.thenReturn(List.of(mockPrice(1, START_DATE_RANGE1, END_DATE_RANGE1, PRIORITY_0, FINAL_PRICE_1),
						mockPrice(2, START_DATE_RANGE2, END_DATE_RANGE2, PRIORITY_1, FINAL_PRICE_2)));
		Optional<ProductPriceDTO> result = productPriceService.findProductPrice(mockProductPriceFilterDTO(LocalDateTime.now()));
		assertTrue(result.isPresent());
		assertEquals(result.get().getPrice().compareTo(FINAL_PRICE_2), 0);
	}

}
