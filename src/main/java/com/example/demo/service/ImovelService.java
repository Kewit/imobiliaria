
package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ImagensDTO;
import com.example.demo.dto.ImovelDTO;
import com.example.demo.exception.ResourceInternalServerException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Filtro;
import com.example.demo.model.Imagens;
import com.example.demo.model.Imovel;
import com.example.demo.model.Proprietario;
import com.example.demo.repository.ImovelRepository;
import com.example.demo.repository.ProprietarioRepository;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private ProprietarioRepository proprietarioRepository;




    public List<ImovelDTO> listarTodosImoveis(){
        List<Imovel> listaDeImoveis = imovelRepository.findAll();
        List<ImovelDTO> listaDeImoveisDTO = new ArrayList<>();
        for(Imovel i:listaDeImoveis){
            ImovelDTO imovelDTO = new ModelMapper().map(i, ImovelDTO.class);
            

            List<ImagensDTO> imagensDTOs = new ArrayList<>();
             for(Imagens im:i.getImagens()){
                ImagensDTO imagensDTO = new ImagensDTO();
                imagensDTO.setName(im.getName());
                imagensDTO.setType(im.getType());
                imagensDTO.setBase64(Base64.getEncoder().encodeToString(im.getPicByte()));
                imagensDTOs.add(imagensDTO);
             }
             imovelDTO.setImagens(imagensDTOs);
             listaDeImoveisDTO.add(imovelDTO);
        }            
        return listaDeImoveisDTO;
    }

    public List<ImovelDTO> listarImoveisProprietario(long proprietarioId){
        List<Imovel> listaDeImoveis = imovelRepository.listarImovelPorProprietario(proprietarioId);
        List<ImovelDTO> listaDeImoveisDTO = new ArrayList<>();
        for(Imovel i:listaDeImoveis){
            ImovelDTO imovelDTO = new ModelMapper().map(i, ImovelDTO.class);
            

            List<ImagensDTO> imagensDTOs = new ArrayList<>();
             for(Imagens im:i.getImagens()){
                ImagensDTO imagensDTO = new ImagensDTO();
                imagensDTO.setName(im.getName());
                imagensDTO.setType(im.getType());
                imagensDTO.setBase64(Base64.getEncoder().encodeToString(im.getPicByte()));
                imagensDTOs.add(imagensDTO);
             }
             imovelDTO.setImagens(imagensDTOs);
             listaDeImoveisDTO.add(imovelDTO);
        }            
        return listaDeImoveisDTO;
            }

	public List<ImovelDTO> listarImoveisFiltro(Filtro filtro){
		List<Imovel> imoveis = imovelRepository.findImoveisByFiltro(filtro.getTamanho(), filtro.getPrecoMin(), filtro.getPrecoMax(), filtro.getTipoAloc(), filtro.getMobilia(), filtro.getLocalizacao());
        if(imoveis.isEmpty()){
            throw new ResourceNotFoundException("Nenhuma imovel foi encontrado!");
        }
         List<ImovelDTO> listaDeImoveisDTO = new ArrayList<>();
        for(Imovel i:imoveis){
            ImovelDTO imovelDTO = new ModelMapper().map(i, ImovelDTO.class);
            

            List<ImagensDTO> imagensDTOs = new ArrayList<>();
             for(Imagens im:i.getImagens()){
                ImagensDTO imagensDTO = new ImagensDTO();
                imagensDTO.setName(im.getName());
                imagensDTO.setType(im.getType());
                imagensDTO.setBase64(Base64.getEncoder().encodeToString(im.getPicByte()));
                imagensDTOs.add(imagensDTO);
             }
             imovelDTO.setImagens(imagensDTOs);
             listaDeImoveisDTO.add(imovelDTO);
        }            
        if(filtro.isRelevancia() == true){
            Collections.sort(listaDeImoveisDTO, Comparator.comparingInt(ImovelDTO::getNumClicks));
        }
        return listaDeImoveisDTO;
    }

   
	public List<ImovelDTO> listarImoveisPesquisa(String pesquisa){
		List<Imovel> imoveis = imovelRepository.findImoveisByTextoPesquisa(pesquisa);
        if(imoveis.isEmpty()){
            throw new ResourceNotFoundException("Nenhum imovel encontrado!");
        }
        List<ImovelDTO> listaDeImoveisDTO = new ArrayList<>();
        for(Imovel i:imoveis){
            ImovelDTO imovelDTO = new ModelMapper().map(i, ImovelDTO.class);
            

            List<ImagensDTO> imagensDTOs = new ArrayList<>();
             for(Imagens im:i.getImagens()){
                ImagensDTO imagensDTO = new ImagensDTO();
                imagensDTO.setName(im.getName());
                imagensDTO.setType(im.getType());
                imagensDTO.setBase64(Base64.getEncoder().encodeToString(im.getPicByte()));
                imagensDTOs.add(imagensDTO);
             }
             imovelDTO.setImagens(imagensDTOs);
             listaDeImoveisDTO.add(imovelDTO);
        }            
        return listaDeImoveisDTO;
	}

	public List<ImovelDTO> listarImoveisPorRelevancia(boolean bool){
		List<Imovel> imoveis = imovelRepository.findAll();
        if(imoveis.isEmpty()){
            throw new ResourceNotFoundException("Nenhum imovel encontrado!");
        }
        List<ImovelDTO> listaDeImoveisDTO = new ArrayList<>();
        for(Imovel i:imoveis){
            ImovelDTO imovelDTO = new ModelMapper().map(i, ImovelDTO.class);
            

            List<ImagensDTO> imagensDTOs = new ArrayList<>();
             for(Imagens im:i.getImagens()){
                ImagensDTO imagensDTO = new ImagensDTO();
                imagensDTO.setName(im.getName());
                imagensDTO.setType(im.getType());
                imagensDTO.setBase64(Base64.getEncoder().encodeToString(im.getPicByte()));
                imagensDTOs.add(imagensDTO);
             }
             imovelDTO.setImagens(imagensDTOs);
             listaDeImoveisDTO.add(imovelDTO);
        }            
        if(bool == true){
            Collections.sort(listaDeImoveisDTO, Comparator.comparingInt(ImovelDTO::getNumClicks));
        } else if(bool == false){
            Collections.sort(listaDeImoveisDTO, Comparator.comparingInt(ImovelDTO::getNumClicks).reversed());
        }
        return listaDeImoveisDTO;
	}

	public List<ImovelDTO> listarImoveisPorTipo(String Tipo){
		List<Imovel> imoveis = imovelRepository.findByAlocacao(Tipo);
        if(imoveis.isEmpty()){
            throw new ResourceNotFoundException("Imoveis não encontrados!");
        }
        List<ImovelDTO> listaDeImoveisDTO = new ArrayList<>();
        for(Imovel i:imoveis){
            ImovelDTO imovelDTO = new ModelMapper().map(i, ImovelDTO.class);
            

            List<ImagensDTO> imagensDTOs = new ArrayList<>();
             for(Imagens im:i.getImagens()){
                ImagensDTO imagensDTO = new ImagensDTO();
                imagensDTO.setName(im.getName());
                imagensDTO.setType(im.getType());
                imagensDTO.setBase64(Base64.getEncoder().encodeToString(im.getPicByte()));
                imagensDTOs.add(imagensDTO);
             }
             imovelDTO.setImagens(imagensDTOs);
             listaDeImoveisDTO.add(imovelDTO);
        }    
        return listaDeImoveisDTO;
	}

	public List<ImovelDTO> listarImoveisMaiorPreco(){
		List<Imovel> imoveis = imovelRepository.findAll();
        if(imoveis.isEmpty()){
            throw new ResourceNotFoundException("Imoveis não encontrados!");
        }
        List<ImovelDTO> listaDeImoveisDTO = new ArrayList<>();
        for(Imovel i:imoveis){
            ImovelDTO imovelDTO = new ModelMapper().map(i, ImovelDTO.class);
            

            List<ImagensDTO> imagensDTOs = new ArrayList<>();
             for(Imagens im:i.getImagens()){
                ImagensDTO imagensDTO = new ImagensDTO();
                imagensDTO.setName(im.getName());
                imagensDTO.setType(im.getType());
                imagensDTO.setBase64(Base64.getEncoder().encodeToString(im.getPicByte()));
                imagensDTOs.add(imagensDTO);
             }
             imovelDTO.setImagens(imagensDTOs);
             listaDeImoveisDTO.add(imovelDTO);
        }    
         Collections.sort(listaDeImoveisDTO, Comparator.comparingDouble(ImovelDTO::getPreco));
        return listaDeImoveisDTO;
	}

    public List<ImovelDTO> listarImoveisMenorPreco(){
		List<Imovel> imoveis = imovelRepository.findAll();
        if(imoveis.isEmpty()){
            throw new ResourceNotFoundException("Imoveis não encontrados!");
        }
       List<ImovelDTO> listaDeImoveisDTO = new ArrayList<>();
        for(Imovel i:imoveis){
            ImovelDTO imovelDTO = new ModelMapper().map(i, ImovelDTO.class);
            

            List<ImagensDTO> imagensDTOs = new ArrayList<>();
             for(Imagens im:i.getImagens()){
                ImagensDTO imagensDTO = new ImagensDTO();
                imagensDTO.setName(im.getName());
                imagensDTO.setType(im.getType());
                imagensDTO.setBase64(Base64.getEncoder().encodeToString(im.getPicByte()));
                imagensDTOs.add(imagensDTO);
             }
             imovelDTO.setImagens(imagensDTOs);
             listaDeImoveisDTO.add(imovelDTO);
        }    
         Collections.sort(listaDeImoveisDTO, Comparator.comparingDouble(ImovelDTO::getPreco).reversed());
        return listaDeImoveisDTO;
	}

	public ImovelDTO detalharImovel(long id){
		Imovel imovel = imovelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado!"));
        ImovelDTO imovelDTO = new ModelMapper().map(imovel, ImovelDTO.class);
        if (imovel.getImagens() != null && !imovel.getImagens().isEmpty()) {
            Imagens imagem = imovel.getImagens().iterator().next();
            ImagensDTO imagemDTO = new ImagensDTO();
            imagemDTO.setName(imagem.getName());
            imagemDTO.setType(imagem.getType());
            imagemDTO.setBase64(Base64.getEncoder().encodeToString(imagem.getPicByte()));
            imovelDTO.setImagens(Collections.singletonList(imagemDTO));
        }
        return imovelDTO;
	}

    public ImovelDTO criarImovel(ImovelDTO imovelDTO, MultipartFile[] files, long id){
		try {
            Proprietario proprietario = proprietarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado!"));
            Imovel imovel = new ModelMapper().map(imovelDTO, Imovel.class);
            imovel.setProprietario(proprietario);
            proprietario.getImoveis().add(imovel);
            List<Imagens> imagens = uploadImage(files);
            imovel.setImagens(imagens);
            imovel = imovelRepository.save(imovel);
            proprietarioRepository.save(proprietario);
            imovelDTO.setImovelId(imovel.getImovelId());
            return imovelDTO;
        } catch (Exception e) {
            throw new ResourceInternalServerException("Ocorreu um erro no servidor!");
        }
	}

   
	public ImovelDTO alterarImovel(ImovelDTO imovelDTO, long id){
		Imovel imovel = imovelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado!"));
        imovel = new ModelMapper().map(imovelDTO, Imovel.class);
        imovelRepository.save(imovel);
        return imovelDTO;
	}
             
	public void deletarImovel(long id){
		Imovel imovel = imovelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado!"));
        Proprietario proprietario = imovel.getProprietario();
        List<Imovel> imoveis = proprietario.getImoveis();
        imoveis.remove(imovel);
        imovel.setProprietario(null);
        proprietario.setImoveis(imoveis);
        proprietarioRepository.save(proprietario);
        imovelRepository.delete(imovel);
	}

    public ImovelDTO adicionarImagens(Long imovelId, MultipartFile[] files){
        Imovel imovel = imovelRepository.findById(imovelId).orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado!"));
        try {
            List<Imagens> imagens = uploadImage(files);
            List<Imagens> imagensJaExistentes = imovel.getImagens();
            imagens.addAll(imagensJaExistentes);
            imovel.setImagens(imagens);
            imovelRepository.save(imovel);
            ImovelDTO imovelDTO = new ModelMapper().map(imovel, ImovelDTO.class);
            return imovelDTO;
        } catch (Exception e) {
            throw new ResourceInternalServerException("Ocorreu um erro no servidor!");
        }
    }

     public List<Imagens> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        List<Imagens> imagens = new ArrayList<>();

        for (MultipartFile file : multipartFiles) {
            Imagens imagem = new Imagens(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes());
            imagens.add(imagem);
        }

        return imagens;
    }
            
    }

