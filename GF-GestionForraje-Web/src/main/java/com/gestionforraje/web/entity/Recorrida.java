package com.gestionforraje.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Recorrida implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3432717906453689188L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recorrida_potreros",
				joinColumns = @JoinColumn(name="recorrida_id"),
				inverseJoinColumns = @JoinColumn(name="potrero_id"))
	@NotNull
	private Set<Potrero> potreros;
	*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "potrero_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@NotNull
	private Potrero potrero;

	private Long numero;
	
	private Date fecha;
	
	@Column
	@NotNull
	private BigDecimal kgMsHa;
	
	@Column
	@NotNull
	private BigDecimal hojas;
	
	@Column
	@NotNull
	private BigDecimal nudos;
	
	@Column
	@NotBlank
	private String observaciones;

	private BigDecimal crecimientoSemanal;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	*/
	
	public Recorrida() {
		super();
	}

	public Recorrida(Long id, @NotNull Potrero potrero, Long numero, Date fecha, @NotNull BigDecimal kgMsHa,
			@NotNull BigDecimal hojas, @NotNull BigDecimal nudos, @NotBlank String observaciones,
			BigDecimal crecimientoSemanal) {
		super();
		this.id = id;
		this.potrero = potrero;
		this.numero = numero;
		this.fecha = fecha;
		this.kgMsHa = kgMsHa;
		this.hojas = hojas;
		this.nudos = nudos;
		this.observaciones = observaciones;
		this.crecimientoSemanal = crecimientoSemanal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Potrero getPotrero() {
		return potrero;
	}

	public void setPotrero(Potrero potrero) {
		this.potrero = potrero;
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

	public BigDecimal getKgMsHa() {
		return kgMsHa;
	}

	public void setKgMsHa(BigDecimal kgMsHa) {
		this.kgMsHa = kgMsHa;
	}

	public BigDecimal getHojas() {
		return hojas;
	}

	public void setHojas(BigDecimal hojas) {
		this.hojas = hojas;
	}

	public BigDecimal getNudos() {
		return nudos;
	}

	public void setNudos(BigDecimal nudos) {
		this.nudos = nudos;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getCrecimientoSemanal() {
		return crecimientoSemanal;
	}

	public void setCrecimientoSemanal(BigDecimal crecimientoSemanal) {
		this.crecimientoSemanal = crecimientoSemanal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crecimientoSemanal == null) ? 0 : crecimientoSemanal.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hojas == null) ? 0 : hojas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kgMsHa == null) ? 0 : kgMsHa.hashCode());
		result = prime * result + ((nudos == null) ? 0 : nudos.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((potrero == null) ? 0 : potrero.hashCode());
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
		Recorrida other = (Recorrida) obj;
		if (crecimientoSemanal == null) {
			if (other.crecimientoSemanal != null)
				return false;
		} else if (!crecimientoSemanal.equals(other.crecimientoSemanal))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hojas == null) {
			if (other.hojas != null)
				return false;
		} else if (!hojas.equals(other.hojas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kgMsHa == null) {
			if (other.kgMsHa != null)
				return false;
		} else if (!kgMsHa.equals(other.kgMsHa))
			return false;
		if (nudos == null) {
			if (other.nudos != null)
				return false;
		} else if (!nudos.equals(other.nudos))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (potrero == null) {
			if (other.potrero != null)
				return false;
		} else if (!potrero.equals(other.potrero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recorrida [id=" + id + ", potrero=" + potrero + ", numero=" + numero + ", fecha=" + fecha + ", kgMsHa="
				+ kgMsHa + ", hojas=" + hojas + ", nudos=" + nudos + ", observaciones=" + observaciones
				+ ", crecimientoSemanal=" + crecimientoSemanal + "]";
	}

	


	
	
	

}
