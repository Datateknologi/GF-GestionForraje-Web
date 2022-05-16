package com.gestionforraje.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Predio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5106977082624082668L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;

	@Column
	private String nombre;

	@Column
	private long areaHa;

	@Column
	private String observaciones;

		
	/*	
	@OneToMany(mappedBy="predio")
	@Transient
	private List<Potrero> potreros;
	
	
	@OneToMany(mappedBy="predio")
	@Transient
	private List<Lote> lotes;
	*/
	
	public Predio() {
		super();
	}


	public Predio(Long id, String nombre, long areaHa, String observaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.areaHa = areaHa;
		this.observaciones = observaciones;
	}


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


	public long getAreaHa() {
		return areaHa;
	}


	public void setAreaHa(long areaHa) {
		this.areaHa = areaHa;
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
		result = prime * result + (int) (areaHa ^ (areaHa >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
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
		Predio other = (Predio) obj;
		if (areaHa != other.areaHa)
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
		return true;
	}


	@Override
	public String toString() {
		return "Predio [id=" + id + ", nombre=" + nombre + ", areaHa=" + areaHa + ", observaciones=" + observaciones
				+ "]";
	}
	
	
	
	

	

}
