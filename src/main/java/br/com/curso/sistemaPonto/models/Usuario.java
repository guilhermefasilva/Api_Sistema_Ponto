package br.com.curso.sistemaPonto.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private CategoriaUsuario categoriaUsuario;
	@ManyToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name="nivelAcesso_id")
	private NivelAcesso nivelAcesso;
	@ManyToOne
	@JoinColumn(name="jornadaTrabalho_id")
	private JornadaTrabalho jornadaTrabalho;
	
	private BigDecimal jornadaTrablaho;
	
	private LocalDateTime inicioJornada;
	
	private LocalDateTime finalJornada;

}
