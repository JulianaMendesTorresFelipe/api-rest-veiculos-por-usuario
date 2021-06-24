package com.veiculos.apirest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.veiculos.apirest.models.Usuario;




public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByCpf(String cpf);
	public Usuario findByCpf(Boolean b);


}
