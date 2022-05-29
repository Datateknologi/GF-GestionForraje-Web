package com.gestionforraje.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

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
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recorrida_potreros",
				joinColumns = @JoinColumn(name="recorrida_id"),
				inverseJoinColumns = @JoinColumn(name="potrero_id"))
	private Set<Potrero> potreros;
	
	private Date fecha;
	
	private Long kgMsHa;
	
	private Long hojas;
	
	private Long nudos;
	
	private String observaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	
	
	public Recorrida() {
		super();
	}


	public Recorrida(Long id, Set<Potrero> potreros, Date fecha, Long kgMsHa, Long hojas, Long nudos,
			String observaciones, Usuario usuario) {
		super();
		this.id = id;
		this.potreros = potreros;
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


	public Set<Potrero> getPotreros() {
		return potreros;
	}


	public void setPotreros(Set<Potrero> potreros) {
		this.potreros = potreros;
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
		result = prime * result + ((potreros == null) ? 0 : potreros.hashCode());
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
		if (potreros == null) {
			if (other.potreros != null)
				return false;
		} else if (!potreros.equals(other.potreros))
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
		return "Recorrida [id=" + id + ", potreros=" + potreros + ", fecha=" + fecha + ", kgMsHa=" + kgMsHa + ", hojas="
				+ hojas + ", nudos=" + nudos + ", observaciones=" + observaciones + ", usuario=" + usuario + "]";
	}

	
	

}
