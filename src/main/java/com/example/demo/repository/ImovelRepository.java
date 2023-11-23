package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    @Query("SELECT i FROM Imovel i WHERE i.proprietario.id = :proprietarioId")
    List<Imovel> listarImovelPorProprietario(@Param("proprietarioId") long proprietarioId);

    @Query("SELECT i FROM Imovel i " +
            "WHERE (:tamanho IS NULL OR i.tamanho >= :tamanho) " +
            "AND (:precoMin IS NULL OR i.preco >= :precoMin) " +
            "AND (:precoMax IS NULL OR i.preco <= :precoMax) " +
            "AND (:tipoAloc IS NULL OR i.alocacao = :tipoAloc) " +
            "AND (:mobilia IS NULL OR i.mobiliado = :mobilia) " +
            "AND (:localizacao IS NULL OR i.localizacao = :localizacao)")
    List<Imovel> findImoveisByFiltro(Long tamanho, Integer precoMin, Integer precoMax,
                                     String tipoAloc, String mobilia, String localizacao);

    @Query("SELECT i FROM Imovel i " +
            "WHERE (:textoPesquisa IS NULL OR " +
            "LOWER(i.descricao) LIKE LOWER(CONCAT('%', :textoPesquisa, '%')) OR " +
            "LOWER(i.titulo) LIKE LOWER(CONCAT('%', :textoPesquisa, '%')) OR " +
            "LOWER(i.alocacao) LIKE LOWER(CONCAT('%', :textoPesquisa, '%')) OR " +
            "LOWER(i.localizacao) LIKE LOWER(CONCAT('%', :textoPesquisa, '%')))")
    List<Imovel> findImoveisByTextoPesquisa(String textoPesquisa);

    @Query("SELECT i FROM Imovel i WHERE (:textoPesquisa IS NULL OR LOWER(i.alocacao) LIKE LOWER(CONCAT('%', :textoPesquisa, '%')))")
    List<Imovel> findByAlocacao(String textoPesquisa);
}
