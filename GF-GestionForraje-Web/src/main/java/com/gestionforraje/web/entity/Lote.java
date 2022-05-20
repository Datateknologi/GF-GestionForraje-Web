package com.gestionforraje.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
public class Lote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 918558019975154497L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	
	@Column
	private String nombre;
	
	private Date fecha;
	
	private long nAnimales;
	
	private BigDecimal consumoForrajeAnimal;
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "lote_predios",
				joinColumns = @JoinColumn(name="lote_id"),
				inverseJoinColumns = @JoinColumn(name="predio_id"))
	private Set<Predio> predios;
	*/
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predio_id")
    private Predio predio;	
	
	
	public Lote() {
		super();
	}


	public Lote(Long id, String nombre, Date fecha, long nAnimales, BigDecimal consumoForrajeAnimal, Predio predio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.nAnimales = nAnimales;
		this.consumoForrajeAnimal = consumoForrajeAnimal;
		this.predio = predio;
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


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public long getnAnimales() {
		return nAnimales;
	}


	public void setnAnimales(long nAnimales) {
		this.nAnimales = nAnimales;
	}


	public BigDecimal getConsumoForrajeAnimal() {
		return consumoForrajeAnimal;
	}


	public void setConsumoForrajeAnimal(BigDecimal consumoForrajeAnimal) {
		this.consumoForrajeAnimal = consumoForrajeAnimal;
	}


	public Predio getPredio() {
		return predio;
	}


	public void setPredio(Predio predio) {
		this.predio = predio;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consumoForrajeAnimal == null) ? 0 : consumoForrajeAnimal.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (nAnimales ^ (nAnimales >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((predio == null) ? 0 : predio.hashCode());
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
		Lote other = (Lote) obj;
		if (consumoForrajeAnimal == null) {
			if (other.consumoForrajeAnimal != null)
				return false;
		} else if (!consumoForrajeAnimal.equals(other.consumoForrajeAnimal))
			return false;
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
		if (nAnimales != other.nAnimales)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (predio == null) {
			if (other.predio != null)
				return false;
		} else if (!predio.equals(other.predio))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Lote [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", nAnimales=" + nAnimales
				+ ", consumoForrajeAnimal=" + consumoForrajeAnimal + ", predio=" + predio + "]";
	}
	
	
	
	

}
