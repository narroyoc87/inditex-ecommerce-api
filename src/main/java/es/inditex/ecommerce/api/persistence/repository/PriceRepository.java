package es.inditex.ecommerce.api.persistence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.inditex.ecommerce.api.persistence.entity.Price;
import es.inditex.ecommerce.api.persistence.entity.PricePK;

@Repository
public interface PriceRepository extends JpaRepository<Price, PricePK> {
	List<Price> findByIdBrandIdAndIdStartDateLessThanEqualAndIdEndDateGreaterThanEqualAndIdProductId(final Long brandId,
			final Date compareDate, final Date sameDate, final Long productId);
	@EntityGraph(value = "priceGraph")
	default List<Price> findProductPriceAtMoment(final Long brandId, final Date compareDate,
			 final Long productId) {
		return findByIdBrandIdAndIdStartDateLessThanEqualAndIdEndDateGreaterThanEqualAndIdProductId(brandId, compareDate, compareDate,
				productId);
	}
}
