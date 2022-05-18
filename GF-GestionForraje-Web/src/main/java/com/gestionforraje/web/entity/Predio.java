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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotBlank
	private String nombre;

	@Column
	@NotNull
	private Long areaHa;

	@Column
	@NotBlank
	private String observaciones;

		
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "predio_potreros",
				joinColumns = @JoinColumn(name="predio_id"),
				inverseJoinColumns = @JoinColumn(name="potrero_id"))
	private Set<Potrero> potreros;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "predio_lotes",
				joinColumns = @JoinColumn(name="predio_id"),
				inverseJoinColumns = @JoinColumn(name="lote_id"))
	private Set<Lote> lotes;
	
	
    public Predio() {
    	super();
    }
    
	public Predio(Long id, @NotBlank String nombre, @NotNull Long areaHa, @NotBlank String observaciones,
			Set<Potrero> potreros, Set<Lote> lotes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.areaHa = areaHa;
		this.observaciones = observaciones;
		this.potreros = potreros;
		this.lotes = lotes;
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

	public Long getAreaHa() {
		return areaHa;
	}

	public void setAreaHa(Long areaHa) {
		this.areaHa = areaHa;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set<Potrero> getPotreros() {
		return potreros;
	}

	public void setPotreros(Set<Potrero> potreros) {
		this.potreros = potreros;
	}

	public Set<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaHa == null) ? 0 : areaHa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lotes == null) ? 0 : lotes.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((potreros == null) ? 0 : potreros.hashCode());
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
		if (areaHa == null) {
			if (other.areaHa != null)
				return false;
		} else if (!areaHa.equals(other.areaHa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lotes == null) {
			if (other.lotes != null)
				return false;
		} else if (!lotes.equals(other.lotes))
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
		if (potreros == null) {
			if (other.potreros != null)
				return false;
		} else if (!potreros.equals(other.potreros))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Predio [id=" + id + ", nombre=" + nombre + ", areaHa=" + areaHa + ", observaciones=" + observaciones
				+ ", potreros=" + potreros + ", lotes=" + lotes + "]";
	}
	
	
	
	


	
	
}
