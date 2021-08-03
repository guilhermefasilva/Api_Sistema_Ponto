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

import br.com.curso.sistemaPonto.models.Movimentacao;
import br.com.curso.sistemaPonto.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@PostMapping
	public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao) {
		return this.movimentacaoService.save(movimentacao);
	}
	
	@GetMapping
	public List<Movimentacao> getMovimentacaoList(){
		return this.movimentacaoService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Movimentacao> getMovimentacaoById(@PathVariable long id) throws Exception{
		return ResponseEntity.ok(this.movimentacaoService.getById(id).orElseThrow(()-> new Exception("Id não encontrado")));
	}
	
	@PutMapping
	public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao) {
		return this.movimentacaoService.update(movimentacao);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Movimentacao> deleteMovimentacaoById(long id){

		try {
			this.movimentacaoService.delete(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return ResponseEntity.ok().build();
	}
}
