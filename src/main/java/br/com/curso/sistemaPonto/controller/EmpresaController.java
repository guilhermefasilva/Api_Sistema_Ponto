package br.com.curso.sistemaPonto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.curso.sistemaPonto.models.Empresa;
import br.com.curso.sistemaPonto.service.EmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;

	@PostMapping
	public Empresa createEmpresa(@RequestBody Empresa empresa) {
		return this.empresaService.save(empresa);
	}
	
	@GetMapping
	public List<Empresa> getEmpresa(){
		return this.empresaService.findAll();
	}
	
	@GetMapping("/{idEmpresa}")
	public ResponseEntity<Empresa> getEmpresaId(@PathVariable long idEmpresa) throws Exception{
		return ResponseEntity.ok(this.empresaService.findById(idEmpresa).orElseThrow(()-> new Exception("Id não encontrado")));
	}
	
	@PutMapping
	public Empresa updateEmpresa(@RequestBody Empresa empresa) {
		return this.empresaService.update(empresa);
	}
	
	@DeleteMapping("/{idEmpresa}")
	public ResponseEntity<Empresa> deleteEmpresaById(@PathVariable long idEmpresaa){
		try {
			this.empresaService.delete(idEmpresaa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
	
}
