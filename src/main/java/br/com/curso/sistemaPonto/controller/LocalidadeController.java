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

import br.com.curso.sistemaPonto.models.Localidade;
import br.com.curso.sistemaPonto.service.LocalidadeService;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

	@Autowired
	private LocalidadeService localidadeService;
	
	
	@PostMapping
	public Localidade createLocalidade(@RequestBody Localidade localidade) {
		return this.localidadeService.save(localidade);
	}
	
	@GetMapping
	public List<Localidade> getLocalidadeList(){
		return this.localidadeService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Localidade> getLocalidadeById(@PathVariable long id) throws Exception{
		return ResponseEntity.ok(this.localidadeService.getById(id).orElseThrow(()-> new Exception("Id não encontrado")));
	}
	
	@PutMapping
	public Localidade updateLocalidade(@RequestBody Localidade localidade) {
		return this.localidadeService.update(localidade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Localidade> deleteLocalidadeById(long id){

		try {
			this.localidadeService.deletar(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return ResponseEntity.ok().build();
	}
	
	
}
