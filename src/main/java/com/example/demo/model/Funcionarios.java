package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue; 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("F") 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcionarios{
	@Id
	private String creci;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	@ManyToOne
	@JoinColumn(name="cnpj")
	private Empresa empresa;
}