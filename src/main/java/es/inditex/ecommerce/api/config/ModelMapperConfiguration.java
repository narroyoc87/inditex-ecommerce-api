package es.inditex.ecommerce.api.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.inditex.ecommerce.api.model.ProductPriceDTO;
import es.inditex.ecommerce.api.persistence.entity.Price;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

		Converter<Price, ProductPriceDTO> priceConverter = new Converter<Price, ProductPriceDTO>() {
			public ProductPriceDTO convert(MappingContext<Price, ProductPriceDTO> context) {
				Price price = context.getSource();
				return ProductPriceDTO.builder().brandId(price.getId().getBrandId())
						.startDatePrice(convertTo(price.getId().getStartDate()))
						.endDatePrice(convertTo(price.getId().getEndDate()))
						.productId(price.getId().getProductId())
						.priceList(price.getId().getPriceListId())
						.price(price.getFinalPrice())
						.build();
			}
		};
		mapper.addConverter(priceConverter);
		return mapper;
	}

	private static LocalDateTime convertTo(final Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}
