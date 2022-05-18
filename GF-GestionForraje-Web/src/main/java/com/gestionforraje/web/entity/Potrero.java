package com.gestionforraje.web.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
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
public class Potrero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4472459114266520015L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private Long areaHa;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "potrero_pasturas",
				joinColumns = @JoinColumn(name="potrero_id"),
				inverseJoinColumns = @JoinColumn(name="pastura_id"))
	private Set<Pastura> pasturas;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
    private Estado estado;	
	
	
	@Column
	private String observaciones;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Long getAreaHa() {
		return areaHa;
	}


	public void setAreaHa(Long areaHa) {
		this.areaHa = areaHa;
	}


	public Set<Pastura> getPasturas() {
		return pasturas;
	}


	public void setPasturas(Set<Pastura> pasturas) {
		this.pasturas = pasturas;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaHa == null) ? 0 : areaHa.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((pasturas == null) ? 0 : pasturas.hashCode());
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
		Potrero other = (Potrero) obj;
		if (areaHa == null) {
			if (other.areaHa != null)
				return false;
		} else if (!areaHa.equals(other.areaHa))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (pasturas == null) {
			if (other.pasturas != null)
				return false;
		} else if (!pasturas.equals(other.pasturas))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Potrero [id=" + id + ", nombre=" + nombre + ", areaHa=" + areaHa + ", pasturas=" + pasturas
				+ ", estado=" + estado + ", observaciones=" + observaciones + "]";
	}


	
	
	
	

}
