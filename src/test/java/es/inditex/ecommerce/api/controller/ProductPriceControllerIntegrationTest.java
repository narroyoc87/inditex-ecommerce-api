package es.inditex.ecommerce.api.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@ExtendWith( SpringExtension.class )
@SpringBootTest
@AutoConfigureMockMvc
public class ProductPriceControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;

    @Test
    void findProductPrice_shouldReturnStatusOk() throws Exception {	
    	final MvcResult result = mockMvc.perform( get( "/prices?date=2020-06-14 21:00:00&productId=35455&brandId=1" ))
    			.andExpect( status().isOk() ).andReturn();
    	final String content = result.getResponse().getContentAsString();
    	assertTrue( content.contains( "\"price\":35.5" ) );
    }
    
    @Test
    void notFindProductPrice_shouldReturnStatusOk() throws Exception {	
    	final MvcResult result = mockMvc.perform( get( "/prices?date=2020-06-14 21:00:00&productId=3&brandId=2" ))
    			.andExpect( status().isNotFound() ).andReturn();
    	final String content = result.getResponse().getContentAsString();
    	assertTrue( content.isEmpty() );
    }

}
