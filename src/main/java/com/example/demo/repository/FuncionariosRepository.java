package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Funcionarios;

public interface FuncionariosRepository extends JpaRepository<Funcionarios,String>{
    
      @Query("SELECT i FROM Funcionarios i WHERE i.empresa.cnpj= :cnpj")
    List<Funcionarios> listarFuncionariosEmpresa(@Param("cnpj") String proprietarioId);
}
