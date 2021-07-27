package es.inditex.ecommerce.api.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceFilterDTO {
	@NotNull
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" )
	private LocalDateTime date;
	@NotNull
	private Long productId;
	@NotNull
	private Long brandId;
}
