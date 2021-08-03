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

import br.com.curso.sistemaPonto.models.Ocorrencia;
import br.com.curso.sistemaPonto.service.OcorrenciaService;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
		
		@Autowired
		private OcorrenciaService ocorrenciaService;
		
		@PostMapping
		public Ocorrencia createOcorerncia(@RequestBody Ocorrencia ocorrencia) {
			return ocorrenciaService.save(ocorrencia);
		}
		
		@GetMapping
		public List<Ocorrencia> getOcorrenciaList(){
			return ocorrenciaService.findAll();
		}
		
		@GetMapping("/{idOcorrencia}")
		public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable long idOcorrencia) throws Exception{
			return ResponseEntity.ok(ocorrenciaService.getById(idOcorrencia).orElseThrow(()->new Exception("Ocorrencia não encontrada")));
		}
		
		@PutMapping
		public Ocorrencia updateOcorrencia(@RequestBody  Ocorrencia ocorrencia) {
			return ocorrenciaService.updateOcorrencia(ocorrencia);
		}
		
		@DeleteMapping("/{idOcorrencia}")
		public ResponseEntity<Ocorrencia> deleteOcorrencia(long idOcorrencia){
			try {
				ocorrenciaService.deletarOcorrencia(idOcorrencia);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return ResponseEntity.ok().build();
		}
		
}
