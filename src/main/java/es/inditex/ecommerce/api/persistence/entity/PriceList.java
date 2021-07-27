package es.inditex.ecommerce.api.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRICE_LIST")
@Getter
@Setter
@NoArgsConstructor
public class PriceList {
	@Id
	@Column(name = "PRICE_LIST_ID")
	private Integer id;
	@Column( name = "PRICE_LIST_NAME" )
	private String name;

}
