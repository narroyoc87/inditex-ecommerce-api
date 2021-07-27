package es.inditex.ecommerce.api.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import es.inditex.ecommerce.api.controller.ProductPriceControllerTest;
import es.inditex.ecommerce.api.persistence.repository.PriceRepository;
import es.inditex.ecommerce.api.service.ProductPriceService;

@ExtendWith(MockitoExtension.class)
public class EcommerceConfigTest {
	@InjectMocks
	private EcommerceConfig ecommerceConfig;
	@Mock
	private ProductPriceControllerTest productPriceControllerTest;
	@Mock
	private ProductPriceService productPriceService;
	@Mock
	private PriceRepository priceRepository;
	@Mock
	private ModelMapper modelMapper;
	@Test
	public void productPriceControllerShouldBeDeclare() {
		assertNotNull(ecommerceConfig.productPriceController(productPriceService));
	}
	@Test
	public void productPriceServiceShouldBeDeclare() {
		assertNotNull(ecommerceConfig.productPriceService(priceRepository,modelMapper));
	}
}
