package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Empresa{
	@Id
	private String cnpj;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Funcionarios> funcionarios;
	private String atividade;
}
