package com.example.demo.dto;

import com.example.demo.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {
    private String creci;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private Empresa empresa;
}
