package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Imovel {
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imovel_id")
	private long imovelId;
	private String titulo;
	private String tipo;
	private String alocacao;
	private Double preco;
	private String iptu;
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "imovel_imagem", joinColumns = {
            @JoinColumn(name = "imovel_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "imagem_id")
    })
	private List<Imagens> imagens;
	private String condominio;
	private String localizacao;
	private String mobiliado;
	private String descricao;
	private long tamanho;
	private int comodos;
	private int quartos;
	private String cep;
	private int numClicks;
	@ManyToOne
	@JoinColumn(name="proprietario_id")
	private Proprietario proprietario;
	
	
	
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	  }
}
