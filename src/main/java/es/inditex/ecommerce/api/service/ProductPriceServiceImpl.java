package es.inditex.ecommerce.api.service;

import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import es.inditex.ecommerce.api.model.ProductPriceDTO;
import es.inditex.ecommerce.api.model.ProductPriceFilterDTO;
import es.inditex.ecommerce.api.persistence.entity.Price;
import es.inditex.ecommerce.api.persistence.repository.PriceRepository;

public class ProductPriceServiceImpl implements ProductPriceService {
	private PriceRepository priceRepository;
	private ModelMapper modelMapper;

	public ProductPriceServiceImpl(PriceRepository priceRepository, ModelMapper modelMapper) {
		this.priceRepository = priceRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Optional<ProductPriceDTO> findProductPrice(final ProductPriceFilterDTO productPriceFilterDTO) {
		Date searchDate = Date.from(productPriceFilterDTO.getDate().atZone(ZoneId.systemDefault()).toInstant());
		return Optional.of(priceRepository
				.findProductPriceAtMoment(productPriceFilterDTO.getBrandId(), searchDate,
						productPriceFilterDTO.getProductId())
				.stream().sorted(Comparator.comparing(Price::getPriority).reversed()).findFirst()
				.map(price -> modelMapper.map(price, ProductPriceDTO.class))).orElse(Optional.empty());
	}

}
