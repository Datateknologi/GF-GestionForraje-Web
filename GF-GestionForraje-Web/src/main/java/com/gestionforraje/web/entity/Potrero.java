package com.gestionforraje.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@NotBlank
	private String nombre;
	
	@Column
	@NotNull
	private BigDecimal areaHa;
	
	@Column
	@NotBlank
	private String pastura;
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "potrero_estados",
				joinColumns = @JoinColumn(name="potrero_id"),
				inverseJoinColumns = @JoinColumn(name="estado_id"))
	private Set<Estado> estados;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "potrero_predios",
				joinColumns = @JoinColumn(name="potrero_id"),
				inverseJoinColumns = @JoinColumn(name="predio_id"))
	private Set<Predio> predios;
	
	*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@NotNull
	private Estado estado;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "predio_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@NotNull
	private Predio predio;	
	
	
		
	@Column
	@NotNull
	private String observaciones;
	
	@Transient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "potrero")
    private List<Recorrida> recorridas;
			
	public Potrero() {
		super();
	}

	public Potrero(Long id, @NotBlank String nombre, @NotNull BigDecimal areaHa, @NotBlank String pastura,
			@NotNull Estado estado, @NotNull Predio predio, @NotNull String observaciones, List<Recorrida> recorridas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.areaHa = areaHa;
		this.pastura = pastura;
		this.estado = estado;
		this.predio = predio;
		this.observaciones = observaciones;
		this.recorridas = recorridas;
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

	public BigDecimal getAreaHa() {
		return areaHa;
	}

	public void setAreaHa(BigDecimal areaHa) {
		this.areaHa = areaHa;
	}

	public String getPastura() {
		return pastura;
	}

	public void setPastura(String pastura) {
		this.pastura = pastura;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public List<Recorrida> getRecorridas() {
		return recorridas;
	}

	public void setRecorridas(List<Recorrida> recorridas) {
		this.recorridas = recorridas;
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
		result = prime * result + ((pastura == null) ? 0 : pastura.hashCode());
		result = prime * result + ((predio == null) ? 0 : predio.hashCode());
		result = prime * result + ((recorridas == null) ? 0 : recorridas.hashCode());
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
		if (pastura == null) {
			if (other.pastura != null)
				return false;
		} else if (!pastura.equals(other.pastura))
			return false;
		if (predio == null) {
			if (other.predio != null)
				return false;
		} else if (!predio.equals(other.predio))
			return false;
		if (recorridas == null) {
			if (other.recorridas != null)
				return false;
		} else if (!recorridas.equals(other.recorridas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Potrero [id=" + id + ", nombre=" + nombre + ", areaHa=" + areaHa + ", pastura=" + pastura + ", estado="
				+ estado + ", predio=" + predio + ", observaciones=" + observaciones + ", recorridas=" + recorridas
				+ "]";
	}

	
	
	
	
			
	
}
