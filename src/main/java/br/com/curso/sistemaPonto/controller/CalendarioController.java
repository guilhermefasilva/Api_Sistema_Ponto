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

import br.com.curso.sistemaPonto.models.Calendario;
import br.com.curso.sistemaPonto.service.CalendarioService;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

	@Autowired
	private CalendarioService calendarioService;
	
	
	@PostMapping
	public Calendario createCalendario(@RequestBody Calendario calendario) {
		return this.calendarioService.save(calendario);
	}
	
	@GetMapping
	public List<Calendario> getCalendarioList(){
		return this.calendarioService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Calendario> getCalensarioById(@PathVariable long id) throws Exception{
		return ResponseEntity.ok(this.calendarioService.getById(id).orElseThrow(()-> new Exception("Id não encontrado")));
	}
	
	@PutMapping
	public Calendario updateCalendario(@RequestBody Calendario calendario) {
		return this.calendarioService.update(calendario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Calendario> deleteCalendarioById(long id){

		try {
			this.calendarioService.deletar(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return ResponseEntity.ok().build();
	}
}
