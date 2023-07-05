package com.example.demo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "precio", nullable = false)
	private double precio;
	
	@Column(name = "cantidad_vendida", nullable = false)
	private int vendidos;
	
	@Column(name = "fecha_ultima_compra", nullable = false)
	private Date fechaUltimaCompra;
	
	@Column(name = "total_final", nullable = true)
	private double totalFinal;
	
	@Column(name = "precio_final_unidad", nullable = true)
	private double precioFinalUnidad;
	
	
	
	
	public Producto() {
		super();
	}

	public Producto(String descripcion, double precio, int vendidos, Date fechaUltimaCompra, double totalFinal,
			double precioFinalUnidad) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.vendidos = vendidos;
		this.fechaUltimaCompra = fechaUltimaCompra;
		this.totalFinal = totalFinal;
		this.precioFinalUnidad = precioFinalUnidad;
	}
	
	public Producto(String descripcion, double precio, int vendidos, Date fechaUltimaCompra) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.vendidos = vendidos;
		this.fechaUltimaCompra = fechaUltimaCompra;
		calcularPrecioFinal();
		calcularTotalFinal();
	}

	public double calcularPrecioFinal() {
		return this.precioFinalUnidad = this.precio * 1.21 ;
	}
	
	public double calcularTotalFinal() {
		return this.totalFinal = this.precio * this.vendidos * 1.21 ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		calcularPrecioFinal();
		calcularTotalFinal();
		this.precio = precio;
	}

	public int getVendidos() {
		return vendidos;
	}

	public void setVendidos(int vendidos) {
		calcularTotalFinal();
		this.vendidos = vendidos;
	}

	public Date getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(Date fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public double getTotalFinal() {
		return totalFinal;
	}

	public void setTotalFinal(double totalFinal) {
		this.totalFinal = totalFinal;
	}

	public double getPrecioFinalUnidad() {
		return precioFinalUnidad;
	}


	public void setPrecioFinalUnidad(double precioFinalUnidad) {
		this.precioFinalUnidad = precioFinalUnidad;
	}
	
	
	
	@Override
	public String toString() {
		return descripcion + "\t \t" + precio + "\t \t" + vendidos
				+ "\t \t" + fechaUltimaCompra + "\t \t" + totalFinal + "\t \t"
				+ precioFinalUnidad  + "\n" ;
	}

	
}
