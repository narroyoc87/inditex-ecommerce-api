package es.inditex.ecommerce.api.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceDTO {
	
	private Long productId;
	private Long brandId;
	private Integer priceList;
	private Double price;
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" )
	private LocalDateTime startDatePrice;
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" )
	private LocalDateTime endDatePrice;
}
