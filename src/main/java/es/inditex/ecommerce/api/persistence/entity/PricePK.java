package es.inditex.ecommerce.api.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PricePK implements Serializable{
	private static final long serialVersionUID = -8130018231572245294L;
	@Column(insertable = false, updatable = false)
	private Long brandId;
	@Column( insertable = false, updatable = false)
	private Date startDate;
	@Column(insertable = false, updatable = false)
	private Date endDate;
	@Column(insertable = false, updatable = false)
	private Integer priceListId;
	@Column( insertable = false, updatable = false)
	private Long productId;
}
