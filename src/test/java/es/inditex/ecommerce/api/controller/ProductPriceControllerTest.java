package es.inditex.ecommerce.api.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import es.inditex.ecommerce.api.config.DateTimeConfig;
import es.inditex.ecommerce.api.model.ProductPriceDTO;
import es.inditex.ecommerce.api.model.ProductPriceFilterDTO;
import es.inditex.ecommerce.api.service.ProductPriceService;

@ExtendWith( MockitoExtension.class )
public class ProductPriceControllerTest {
	private MockMvc mockMvc;

    @Mock
    private ProductPriceService productPriceService;

    @InjectMocks
	ProductPriceController productPriceController;
    
    private FormattingConversionService formattingConversionService;
    private static final Long PRODUCT_ID = 35455L;
	private static final Long BRAND_ID = 1l;
	private static final String START_DATE_MOCK = "2020-06-14 00:00:00";
	private static final String END_DATE_MOCK = "2020-06-15 00:00:00";
    @BeforeEach
    public void setUp() throws Exception {
    	formattingConversionService = new DateTimeConfig().mvcConversionService();
    	this.mockMvc = MockMvcBuilders.standaloneSetup( productPriceController ).setConversionService(formattingConversionService).build();

    }
    
    @Test
    void findProductPrice_shouldReturnStatusOk() throws Exception {
        when( productPriceService.findProductPrice(any(ProductPriceFilterDTO.class)) ).thenReturn( Optional.of(mockProductPriceDTO()) );
        final MvcResult result = mockMvc.perform( get( "/prices?date=2020-06-14 21:00:00&productId=35455&brandId=1" ))
                .andExpect( status().isOk() ).andReturn();
        final String content = result.getResponse().getContentAsString();
        
        assertTrue( content.contains( "\"productId\":35455" ) );
        assertTrue( content.contains( "\"brandId\":1" ) );
        assertTrue( content.contains( "\"priceList\":2" ) );
        assertTrue( content.contains( "\"price\":55.77" ) );
        assertTrue( content.contains( "\"startDatePrice\":\"" + START_DATE_MOCK + "\"" ) );
        assertTrue( content.contains( "\"endDatePrice\":\"" + END_DATE_MOCK + "\"" ) );
    }
    
    @Test
    void notFindProductPrice_shouldReturnStatusOk() throws Exception {
    	final MvcResult result = mockMvc.perform( get( "/prices?date=2020-06-14 21:00:00&productId=35455&brandId=1" ))
    			.andExpect( status().isNotFound() ).andReturn();
    	final String content = result.getResponse().getContentAsString();
    	assertTrue( content.isEmpty());
    }
    
    @Test
    void shouldReturnBadrequestWhenDateParamNotExists() throws Exception {
    	mockMvc.perform( get( "/prices?productId=35455&brandId=1" ))
    			.andExpect( status().isBadRequest() ).andReturn();
    }
    
    
    @Test
    void shouldReturnBadrequestWhenProductParamNotExists() throws Exception {
    	mockMvc.perform( get( "/prices?date=2020-06-14 21:00:00&brandId=1" ))
    	.andExpect( status().isBadRequest() ).andReturn();
    }
    
    
    @Test
    void shouldReturnBadrequestWhenBrandParamNotExists() throws Exception {
    	mockMvc.perform( get( "/prices?date=2020-06-14 21:00:00&productId=35455" ))
    	.andExpect( status().isBadRequest() ).andReturn();
    }
    
    
	public static ProductPriceDTO mockProductPriceDTO() {
		return ProductPriceDTO.builder().brandId(BRAND_ID)
		.startDatePrice(LocalDateTime.parse(START_DATE_MOCK, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
		.endDatePrice(LocalDateTime.parse(END_DATE_MOCK, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
		.productId(PRODUCT_ID)
		.priceList(2)
		.price(55.77)
		.build();
	}

}
