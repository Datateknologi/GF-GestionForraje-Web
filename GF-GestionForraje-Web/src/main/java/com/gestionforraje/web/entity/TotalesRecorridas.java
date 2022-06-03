package com.gestionforraje.web.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class TotalesRecorridas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	
	private Long numero;
	
	private Date fecha;
	
	private BigDecimal toatalkgMsHa;
	
	private BigDecimal totalCreckgMs;
	
	
	public TotalesRecorridas() {
		super();
	}


	public TotalesRecorridas(Long id, Long numero, Date fecha, BigDecimal toatalkgMsHa, BigDecimal totalCreckgMs) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha = fecha;
		this.toatalkgMsHa = toatalkgMsHa;
		this.totalCreckgMs = totalCreckgMs;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getNumero() {
		return numero;
	}


	public void setNumero(Long numero) {
		this.numero = numero;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public BigDecimal getToatalkgMsHa() {
		return toatalkgMsHa;
	}


	public void setToatalkgMsHa(BigDecimal toatalkgMsHa) {
		this.toatalkgMsHa = toatalkgMsHa;
	}


	public BigDecimal getTotalCreckgMs() {
		return totalCreckgMs;
	}


	public void setTotalCreckgMs(BigDecimal totalCreckgMs) {
		this.totalCreckgMs = totalCreckgMs;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((toatalkgMsHa == null) ? 0 : toatalkgMsHa.hashCode());
		result = prime * result + ((totalCreckgMs == null) ? 0 : totalCreckgMs.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TotalesRecorridas other = (TotalesRecorridas) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (toatalkgMsHa == null) {
			if (other.toatalkgMsHa != null)
				return false;
		} else if (!toatalkgMsHa.equals(other.toatalkgMsHa))
			return false;
		if (totalCreckgMs == null) {
			if (other.totalCreckgMs != null)
				return false;
		} else if (!totalCreckgMs.equals(other.totalCreckgMs))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TotalesRecorridas [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", toatalkgMsHa="
				+ toatalkgMsHa + ", totalCreckgMs=" + totalCreckgMs + "]";
	}


		
	
	

}