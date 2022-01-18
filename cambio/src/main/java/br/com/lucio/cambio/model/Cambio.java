package br.com.lucio.cambio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cambio")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cambio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column(name = "from_currency", nullable = false, length = 3)
	private String from;
	
	@Column(name = "to_currency", nullable = false, length = 3)
	private String to;
	
	@Column(nullable = false)
	private BigDecimal conversionFactor;

	@Transient
	private BigDecimal convertedValue;
	
	@Transient
	private String enviroment;
	
}
