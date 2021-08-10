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

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductPriceControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	private static final String PRODUCT_ID = "35455";
	private static final String BRAND_ID = "1";
	private static final String PRICES_ENDPOINT = "/prices";
	private static final String DATE_PARAM_NAME = "date";
	private static final String PRODUCT_ID_PARAM_NAME = "productId";
	private static final String BRAND_ID_PARAM_NAME = "brandId";
	private static final String TEST_DATE_1 = "2020-06-14 10:00:00";
	private static final String TEST_DATE_2 = "2020-06-14 16:00:00";
	private static final String TEST_DATE_3 = "2020-06-14 21:00:00";
	private static final String TEST_DATE_4 = "2020-06-15 21:00:00";
	private static final String TEST_DATE_5 = "2020-06-16 21:00:00";

	@Test
	void foundProductPrice_whenDataIsForTest1_shouldReturnStatusOk() throws Exception {
		final MvcResult result = mockMvc
				.perform(get(PRICES_ENDPOINT).param(DATE_PARAM_NAME, TEST_DATE_1)
						.param(PRODUCT_ID_PARAM_NAME, PRODUCT_ID).param(BRAND_ID_PARAM_NAME, BRAND_ID))
				.andExpect(status().isOk()).andReturn();
		final String content = result.getResponse().getContentAsString();
		assertTrue(content.contains("\"price\":35.5"));
	}

	@Test
	void foundProductPrice_whenDataIsForTest2_shouldReturnStatusOk() throws Exception {
		final MvcResult result = mockMvc
				.perform(get(PRICES_ENDPOINT).param(DATE_PARAM_NAME, TEST_DATE_2)
						.param(PRODUCT_ID_PARAM_NAME, PRODUCT_ID).param(BRAND_ID_PARAM_NAME, BRAND_ID))
				.andExpect(status().isOk()).andReturn();
		final String content = result.getResponse().getContentAsString();
		assertTrue(content.contains("\"price\":25.45"));
	}

	@Test
	void foundProductPrice_whenDataIsForTest3_shouldReturnStatusOk() throws Exception {
		final MvcResult result = mockMvc
				.perform(get(PRICES_ENDPOINT).param(DATE_PARAM_NAME, TEST_DATE_3)
						.param(PRODUCT_ID_PARAM_NAME, PRODUCT_ID).param(BRAND_ID_PARAM_NAME, BRAND_ID))
				.andExpect(status().isOk()).andReturn();
		final String content = result.getResponse().getContentAsString();
		assertTrue(content.contains("\"price\":35.5"));
	}

	@Test
	void foundProductPrice_whenDataIsForTest4_shouldReturnStatusOk() throws Exception {
		final MvcResult result = mockMvc
				.perform(get(PRICES_ENDPOINT).param(DATE_PARAM_NAME, TEST_DATE_4)
						.param(PRODUCT_ID_PARAM_NAME, PRODUCT_ID).param(BRAND_ID_PARAM_NAME, BRAND_ID))
				.andExpect(status().isOk()).andReturn();
		final String content = result.getResponse().getContentAsString();
		assertTrue(content.contains("\"price\":38.95"));
	}

	@Test
	void foundProductPrice_whenDataIsForTest5_shouldReturnStatusOk() throws Exception {
		final MvcResult result = mockMvc
				.perform(get(PRICES_ENDPOINT).param(DATE_PARAM_NAME, TEST_DATE_5)
						.param(PRODUCT_ID_PARAM_NAME, PRODUCT_ID).param(BRAND_ID_PARAM_NAME, BRAND_ID))
				.andExpect(status().isOk()).andReturn();
		final String content = result.getResponse().getContentAsString();
		assertTrue(content.contains("\"price\":38.95"));
	}

}
