package com.example.demo.dto;

import java.util.List;
import com.example.demo.model.Avaliacao;
import com.example.demo.model.Imovel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProprietarioDTO {
    private long proprietarioId;
	private String email;
	private String telefone;
	private String nome;
	private String cpf;
	private String endereco;
	private int moveisDisp;
	private int credibilidade;
	private List<Imovel> imoveis;
	private List<Avaliacao> avaliacoes;
	private String user;
	private String atividade;
}
