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

import br.com.curso.sistemaPonto.models.JornadaTrabalho;
import br.com.curso.sistemaPonto.service.JornadaService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
	
	@Autowired
	private JornadaService jornadaService;
	
	
	@PostMapping
	public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaService.save(jornadaTrabalho);
	}
	
	@GetMapping
	public List<JornadaTrabalho> getJornadaList(){
		return jornadaService.findAll();
	}
	@GetMapping("/{idJornada}")
	public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") long idJornada) throws Exception{
		return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(()-> new Exception("Jornada não Encontrada!"))); 
	}
	
	@PutMapping
	public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaService.updateJornada(jornadaTrabalho);
	}
	
	@DeleteMapping("/{idJornada}")
	public ResponseEntity<JornadaTrabalho> deleteByID(@PathVariable("idJornada") long idJornada) throws Exception{
		try {
			jornadaService.deleteJornada(idJornada);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} 
		return  ResponseEntity.ok().build();
	}

	

}
