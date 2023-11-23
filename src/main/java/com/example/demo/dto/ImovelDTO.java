package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Proprietario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImovelDTO {
    private long imovelId;
	private String titulo;
	private String tipo;
	private String alocacao;
	private Double preco;
	private String iptu;
	private List<ImagensDTO> imagens;
	private String condominio;
	private String localizacao;
	private String mobiliado;
	private String descricao;
	private long tamanho;
	private int comodos;
	private int quartos;
	private String cep;
	private int numClicks;
	private Proprietario proprietario;
}
