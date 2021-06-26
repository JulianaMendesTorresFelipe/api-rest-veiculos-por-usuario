package com.veiculos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veiculos.apirest.cloud.Feign;
import com.veiculos.apirest.cloud.Marca;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/use")
@Api(value = "API REST Veiculos")
@CrossOrigin(origins = "*")
public class FeignResources {
	@Autowired
	Feign feign;
	
	@GetMapping(value = "marcasFeign")		
	@ApiOperation(value = "Informe automóvel (carros, motos ou caminhões)")
	public List<Marca> Marca() {
		return feign.findAll();
		}
	
	
}
