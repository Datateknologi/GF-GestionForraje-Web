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
	
	private String observaciones;
	
	
	public Lote() {
		super();
	}


	public Lote(Long id, String nombre, Date fecha, long nAnimales, BigDecimal consumoForrajeAnimal, Predio predio,
			String observaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.nAnimales = nAnimales;
		this.consumoForrajeAnimal = consumoForrajeAnimal;
		this.predio = predio;
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


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	@Override
	public String toString() {
		return "Lote [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", nAnimales=" + nAnimales
				+ ", consumoForrajeAnimal=" + consumoForrajeAnimal + ", predio=" + predio + ", observaciones="
				+ observaciones + "]";
	}
	
		
	
	

}
