package com.veiculos.apirest.cloud;

import java.awt.print.Pageable;
import java.util.List;

import org.apache.catalina.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("stores")
public interface Feign {
	@RequestMapping(method = RequestMethod.GET, value = " https://parallelum.com.br/fipe/api/v1/carros/marcas")
    List<Store> getStores();
	

   // @RequestMapping(method = RequestMethod.GET, value = "https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos")
  //  Page<Store> getStores(Pageable pageable);

   // @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
  //  Store update(@PathVariable("storeId") Long storeId, Store store);
}
