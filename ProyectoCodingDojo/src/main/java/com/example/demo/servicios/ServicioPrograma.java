package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Programa;
import com.example.demo.repositorios.RepositorioPrograma;


@Service
public class ServicioPrograma {
	@Autowired
	private final RepositorioPrograma repositorioPrograma;

	public ServicioPrograma(RepositorioPrograma repositorioPrograma) {
		this.repositorioPrograma = repositorioPrograma;
	}

	public Programa insertarPrograma(Programa nuevoPrograma){
		return this.repositorioPrograma.save(nuevoPrograma);
	}

	public List<Programa> obtenerTodos(){
		return this.repositorioPrograma.findAll();
	}

	public Programa obtenerPorId(Long id) {
		return this.repositorioPrograma.findById(id).orElse(null);
	}

	public void eliminarPorId(Long id) {
		this.repositorioPrograma.deleteById(id);
	}

	public Programa actualizarPrograma(Programa programa) {
		return this.repositorioPrograma.save(programa);
	}
}