package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.*;
import com.example.demo.models.*;


@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
	

}
