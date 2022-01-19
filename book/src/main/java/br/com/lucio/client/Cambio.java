package br.com.lucio.client;

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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cambio implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionFactor;
	private BigDecimal convertedValue;
	private String enviroment;
	
}
