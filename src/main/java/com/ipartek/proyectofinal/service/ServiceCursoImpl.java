package com.ipartek.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.proyectofinal.domain.Curso;
import com.ipartek.proyectofinal.repository.DAOCurso;

@Service(value = "serviceCurso")
public class ServiceCursoImpl implements ServiceCurso {

	@Autowired()
	private DAOCurso daoCurso;

	@Override
	public List<Curso> listar() {
		return this.daoCurso.getAll();
	}

	@Override
	public Curso buscarPorId(long id) {
		return this.daoCurso.getById(id);
	}

	@Override
	public boolean crear(Curso curso) {
		return this.daoCurso.insert(curso);
	}

	@Override
	public boolean modificar(Curso curso) {
		return this.daoCurso.update(curso);
	}

	@Override
	public boolean eliminar(long id) {
		return this.daoCurso.delete(id);
	}

}
