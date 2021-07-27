package es.inditex.ecommerce.api.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DateTimeConfigTest {
	@InjectMocks
	private DateTimeConfig dateTimeConfig;
	@Test
	public void dateTimeConfigShouldBeDeclare() {
		assertNotNull(dateTimeConfig.mvcConversionService());
	}
}
