package com.veiculos.apirest.cloud;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(url = "https://parallelum.com.br/fipe/api/v1/" , name = "veiculosFeign")
public interface Feign {
	
@GetMapping(value =  "carros/marcas")
List<Marca> findAll();

}
