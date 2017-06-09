package com.ipartek.proyectofinal.service;

import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.proyectofinal.domain.Curso;
import com.ipartek.proyectofinal.repository.DAOCurso;
import com.opencsv.CSVReader;

@Service(value = "serviceCurso")
public class ServiceCursoImpl implements ServiceCurso {

	@Autowired()
	private DAOCurso daoCurso;

	@Override
	public List<Curso> listar() {
		return this.daoCurso.getAll();
	}

	@Override
	public List<Curso> listar10Ultimos() {
		return this.daoCurso.getLast10();
	}

	@Override
	public List<Curso> listarBusqueda(String textoFiltrar) {
		return this.daoCurso.getSearch(textoFiltrar);
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

	@Override
	public void migrarCSV(String rutaAcceso) {
		try {

			int contador = 0;
			CSVReader reader = new CSVReader(new FileReader(rutaAcceso), ';');
			List<String[]> misRegistros = reader.readAll();
			for (String[] linea : misRegistros) {
				if (contador != 0) {
					Curso curso = new Curso();
					curso.setNomCurso(linea[1]);
					curso.setCodCurso(linea[8]);
					if (!"".equals(curso.getNomCurso()) && !"".equals(curso.getCodCurso())) {
						this.daoCurso.insert(curso);
					}
				}
				contador++;
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
