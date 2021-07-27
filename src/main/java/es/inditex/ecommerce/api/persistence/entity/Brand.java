package es.inditex.ecommerce.api.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BRANDS")
@Getter
@Setter
@NoArgsConstructor
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId;
	private String brandName;
}
