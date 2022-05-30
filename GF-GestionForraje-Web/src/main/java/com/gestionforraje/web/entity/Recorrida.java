package com.gestionforraje.web.entity;

import java.io.Serializable;
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
	
	private Date fecha;
	
	@Column
	@NotNull
	private Long kgMsHa;
	
	@Column
	@NotNull
	private Long hojas;
	
	@Column
	@NotNull
	private Long nudos;
	
	@Column
	@NotBlank
	private String observaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	
	
	public Recorrida() {
		super();
	}


	public Recorrida(Long id, @NotNull Potrero potrero, Date fecha, @NotNull Long kgMsHa, @NotNull Long hojas,
			@NotNull Long nudos, @NotBlank String observaciones, Usuario usuario) {
		super();
		this.id = id;
		this.potrero = potrero;
		this.fecha = fecha;
		this.kgMsHa = kgMsHa;
		this.hojas = hojas;
		this.nudos = nudos;
		this.observaciones = observaciones;
		this.usuario = usuario;
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


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Long getKgMsHa() {
		return kgMsHa;
	}


	public void setKgMsHa(Long kgMsHa) {
		this.kgMsHa = kgMsHa;
	}


	public Long getHojas() {
		return hojas;
	}


	public void setHojas(Long hojas) {
		this.hojas = hojas;
	}


	public Long getNudos() {
		return nudos;
	}


	public void setNudos(Long nudos) {
		this.nudos = nudos;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hojas == null) ? 0 : hojas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kgMsHa == null) ? 0 : kgMsHa.hashCode());
		result = prime * result + ((nudos == null) ? 0 : nudos.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((potrero == null) ? 0 : potrero.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Recorrida [id=" + id + ", potrero=" + potrero + ", fecha=" + fecha + ", kgMsHa=" + kgMsHa + ", hojas="
				+ hojas + ", nudos=" + nudos + ", observaciones=" + observaciones + ", usuario=" + usuario + "]";
	}


	
	
	

}
