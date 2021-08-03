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

import br.com.curso.sistemaPonto.models.NivelAcesso;
import br.com.curso.sistemaPonto.service.NivelAcessoService;

@RestController
@RequestMapping("/acesso")
public class NivelAcessoController {
	

	@Autowired
	private NivelAcessoService nivelAcessoService;
	
	@PostMapping
	public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
		return this.nivelAcessoService.save(nivelAcesso);
		
	}
	@GetMapping
	public List<NivelAcesso> getNivelAcessoList(){
		return this.nivelAcessoService.findAll();
	}
	
	@GetMapping("/{idAcesso}")
	public ResponseEntity<NivelAcesso> getByIdNivelAcesso(@PathVariable long idAcesso) throws Exception{
		return ResponseEntity.ok(this.nivelAcessoService.findById(idAcesso).orElseThrow(()-> new Exception("Id não encontrado")));
	}
	
	
	@PutMapping
	public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
		return this.nivelAcessoService.updateNivelAcesso(nivelAcesso);
	}
	
	@DeleteMapping("/{idAcesso}")
	public ResponseEntity<NivelAcesso> deleteNivelAcesso(@PathVariable long idAcesso){
		try {
			this.nivelAcessoService.deleteNivelAcesso(idAcesso);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
	
}
