package br.com.curso.sistemaPonto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.sistemaPonto.models.BancoHoras;
import br.com.curso.sistemaPonto.service.BancoHorasService;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {

	@Autowired
	private BancoHorasService bancoHorasService;
	
	
	@PostMapping
	public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
		return this.bancoHorasService.save(bancoHoras);
	}
	
	@GetMapping
	public List<BancoHoras> getBancoHorasList(){
		return this.bancoHorasService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<BancoHoras> getBancoHorasById(@PathVariable long id) throws Exception{
		return ResponseEntity.ok(this.bancoHorasService.getById(id).orElseThrow(()-> new Exception("Id não encontrado")));
	}
	
	@PutMapping
	public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
		return this.bancoHorasService.update(bancoHoras);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BancoHoras> deleteBancoHorasById(long id){

		try {
			this.bancoHorasService.deletar(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return ResponseEntity.ok().build();
	}

}
