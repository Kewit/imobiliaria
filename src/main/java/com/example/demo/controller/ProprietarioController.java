package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AvaliacaoDTO;
import com.example.demo.dto.ProprietarioDTO;
import com.example.demo.service.ProprietarioService;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {
    @Autowired
    ProprietarioService proprietarioService;

    @PostMapping("/criarProprietario")
	public ResponseEntity<ProprietarioDTO> criarProprietario(@RequestBody ProprietarioDTO proprietario){
		 proprietario = proprietarioService.criarProprietario(proprietario);
		return new ResponseEntity<>(proprietario, HttpStatus.OK);
	}


	@PutMapping("/alterarProprietario/{id}")
	public ResponseEntity<ProprietarioDTO> AlterarProprietario(@RequestBody ProprietarioDTO proprietario, @PathVariable long id){
		 proprietario = proprietarioService.alterarProprietario(proprietario, id);
		return new ResponseEntity<>(proprietario, HttpStatus.OK);
	}

	

	@DeleteMapping("/deletarProprietario/{id}")
	public ResponseEntity<?> DeletarProprietario(@PathVariable long id){
		proprietarioService.deletarProprietario(id);
		return new ResponseEntity<>("Proprietario deletado com sucesso!", HttpStatus.OK);
	}

    @GetMapping("/detalharProprietario/{id}")
	public ResponseEntity<ProprietarioDTO> DetalharProprietario(@PathVariable long id){
		ProprietarioDTO proprietario = proprietarioService.detalharProprietario(id);
		return new ResponseEntity<>(proprietario, HttpStatus.OK);
	}

	@PutMapping("/avaliarProprietario/{id}")
	public ResponseEntity<AvaliacaoDTO> avaliarProprietario(@RequestBody AvaliacaoDTO avaliacao, @PathVariable long id){
		AvaliacaoDTO avaliacaoDTO = proprietarioService.avaliarProprietario(avaliacao, id);
		return new ResponseEntity<>(avaliacaoDTO, HttpStatus.OK);
	}
	
}