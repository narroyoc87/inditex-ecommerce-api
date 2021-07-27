package es.inditex.ecommerce.api.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(
		  name = "priceGraph",
		  attributeNodes = {
		    @NamedAttributeNode("brand"),
		    @NamedAttributeNode("product"),
		    @NamedAttributeNode("priceList"),
		  }
		)
public class Price {
	@Id
	private PricePK id;
	
	@Column(name = "PRIORITY", columnDefinition = "integer default 0")
	private Integer priority;
	@NotEmpty
	@Column( name = "PRICE" )
	private Double finalPrice;
	
	@NotEmpty
	@Column( name = "CURR" )
	private String currency;

	@MapsId("brandId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brandId")
	private Brand brand;
	
	@MapsId("productId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	private Product product;
	
	@MapsId("priceListId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRICE_LIST")
	private PriceList priceList;

}
