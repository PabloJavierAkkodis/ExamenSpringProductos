package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Producto;
import com.example.demo.repositories.ProductoRepository;

@Service
public class ProductoService {
	

	@Autowired
	ProductoRepository productoRepository;
	
	public Producto crearProducto(Producto prod) {
		if(prod.getTotalFinal() == 0 || prod.getPrecioFinalUnidad() == 0) {
			
			prod.calcularPrecioFinal();
			prod.calcularTotalFinal();
		}
		return productoRepository.save(prod);
	}
	
	public Producto buscarProducto(Long id) {
		return productoRepository.findById(id).get();
	}
	
	public Producto actualizaProducto(Producto prod) {
		prod.calcularPrecioFinal();
		prod.calcularTotalFinal();
		return productoRepository.save(prod);
	}
	
	public void borrarProducto(Long id) {
		productoRepository.deleteById(id);
	}
	
	public ArrayList<Producto> obtenerProductos(){
		return (ArrayList<Producto>) productoRepository.findAll();
	}
	
	
	
	
	
	
}
