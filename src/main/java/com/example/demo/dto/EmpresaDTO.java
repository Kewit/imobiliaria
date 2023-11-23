package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Funcionarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {
	private String cnpj;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private List<Funcionarios> funcionarios;
	private String atividade;
}
