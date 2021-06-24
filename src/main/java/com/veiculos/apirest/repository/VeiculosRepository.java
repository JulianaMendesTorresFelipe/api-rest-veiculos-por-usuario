package com.veiculos.apirest.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veiculos.apirest.models.Usuario;
import com.veiculos.apirest.models.Veiculos;



public interface VeiculosRepository extends JpaRepository<Veiculos, Long>{ 
	List<Veiculos> findAllByUsuario(Usuario usuario);
	
}
