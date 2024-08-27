package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.Programa;

@Repository
public interface RepositorioPrograma extends CrudRepository<Programa, Long>{
	List<Programa> findAll();
}