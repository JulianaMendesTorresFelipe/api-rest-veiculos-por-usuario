package com.veiculos.apirest.resources;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.veiculos.apirest.cloud.Feign;
import com.veiculos.apirest.cloud.Marca;
import com.veiculos.apirest.models.Usuario;
import com.veiculos.apirest.models.Veiculos;
import com.veiculos.apirest.models.VeiculosDTO;
import com.veiculos.apirest.repository.UsuarioRepository;
import com.veiculos.apirest.repository.VeiculosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/use")
@Api(value = "API REST Veiculos")
@CrossOrigin(origins = "*")

public class VeiculosResouces {
	
	@Autowired
	Feign feign;
	
	@Autowired
	VeiculosRepository veiculosRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/listaveiculos")
	@ApiOperation(value="Retorna lista de veiculos para o cpf do usuário")
	public List<String> listaVeiculos(String cpf){
		Usuario usuario = usuarioRepository.findByCpf(cpf);
		List<Veiculos> l1= veiculosRepository.findAllByUsuario(usuario);
		List<String>l2 = l1.stream().map(this::toVeiculosDTO).map(this::formatacao).collect(Collectors.toList());
		return l2;
		  
	}

	@PostMapping("/veiculo")
	@ApiOperation(value = "Salva veiculo")
	public ResponseEntity<VeiculosDTO> salvaVeiculo(@RequestBody VeiculosDTO veiculosDTO) {
		try {
			Usuario usuario = usuarioRepository.findByCpf(veiculosDTO.getCpf());
			Veiculos veiculo1 = veiculosDTO.toEntity(usuario);
			Veiculos novoVeiculo = veiculosRepository.save(veiculo1);

			veiculosDTO.setId(novoVeiculo.getId());
			return new ResponseEntity<>(veiculosDTO, HttpStatus.CREATED);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
		
	private VeiculosDTO toVeiculosDTO(Veiculos veiculo) {
		var veiculosDTO = new VeiculosDTO();
		veiculosDTO.setId(veiculo.getId());
		veiculosDTO.setAno(veiculo.getAno());
		veiculosDTO.setMarca(veiculo.getMarca());
		veiculosDTO.setModelo(veiculo.getModelo());
		return veiculosDTO;
	}
	private String rodízio(VeiculosDTO veiculos){
	char ult = veiculos.getAno().charAt(3);
		if (ult == '0'|| ult == '1') {
	return "Segunda-feira";
		}
	else if (ult == '2' || ult == '3') {
		return "Terça-feira";
		}
	else if (ult == '4' || ult == '5') {
		return "Quarta-feira";
		}
	else if (ult == '6' || ult == '7') {
		return "Quinta-feira";
			}
	else if (ult == '8' || ult == '9') {
		return "Sexta-feira";
			}
	else return "";
	}
	
	private String dataAtual() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		if (day == 2){
			return "Segunda-feira";
				}
			else if  (day == 3){
				return "Terça-feira";
				}
			else if  (day == 4) {
				return "Quarta-feira";
				}
			else if  (day == 5) {
				return "Quinta-feira";
					}
			else if  (day == 6) {
				return "Sexta-feira";
					}
			else return "";
	}

	private boolean hoje(VeiculosDTO veiculos) {
		return dataAtual() == rodízio(veiculos);
	}
	
	private String formatacao(VeiculosDTO veiculos) {
		return "hoje  é" + dataAtual() + ", o carro é da marca " + veiculos.getMarca() + 
				", modelo " + veiculos.getModelo() + " do ano de " + 
				veiculos.getAno() + ", ou seja, seu rodízio será às " + rodízio(veiculos)
						+ " e o atributo de rodízio ativo será " + hoje(veiculos) + ".";
	}
}

	
