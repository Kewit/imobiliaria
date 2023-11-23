package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Proprietario{
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proprietario_id")
	private long proprietarioId;
	private String email;
	private String telefone;
	private String nome;
	private String cpf;
	private String endereco;
	private int moveisDisp;
	private int credibilidade;
	@OneToMany(mappedBy="proprietario")
	@JsonIgnore
	private List<Imovel> imoveis;
	@OneToMany(mappedBy = "proprietario")
	@JsonIgnore
	private List<Avaliacao> avaliacoes;
	private String atividade;
}




