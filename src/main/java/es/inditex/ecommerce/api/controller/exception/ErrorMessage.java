package es.inditex.ecommerce.api.controller.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage<T> {
	private T error;
}
