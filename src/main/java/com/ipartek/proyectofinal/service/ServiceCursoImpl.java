package com.ipartek.proyectofinal.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.proyectofinal.domain.Curso;
import com.ipartek.proyectofinal.repository.DAOCurso;
import com.opencsv.CSVReader;

/**
 * Implementación de la interfaz serviceCurso
 * 
 * @author guillermo
 *
 */
@Service(value = "serviceCurso")
public class ServiceCursoImpl implements ServiceCurso {

	@Autowired()
	private DAOCurso daoCurso;

	private static final int NUM_COL_NOMCURSO = 1;
	private static final int NUM_COL_CODCURSO = 8;

	@Override()
	public List<Curso> listar() {
		return this.daoCurso.getAll();
	}

	@Override()
	public List<Curso> listar10Ultimos() {
		return this.daoCurso.getLast10();
	}

	@Override()
	public List<Curso> listarBusqueda(String textoFiltrar) {
		return this.daoCurso.getSearch(textoFiltrar);
	}

	@Override()
	public Curso buscarPorId(long id) {
		return this.daoCurso.getById(id);
	}

	@Override()
	public boolean crear(Curso curso) {
		return this.daoCurso.insert(curso);
	}

	@Override()
	public boolean modificar(Curso curso) {
		return this.daoCurso.update(curso);
	}

	@Override()
	public boolean eliminar(long id) {
		return this.daoCurso.delete(id);
	}

	@Override()
	public boolean migrarCSV(String rutaAcceso) {
		boolean resul = false;
		
		try {

			int contador = 0;
			CSVReader reader = new CSVReader(new FileReader(rutaAcceso), ';');
			List<String[]> misRegistros = reader.readAll();
			for (String[] linea : misRegistros) {
				if (contador != 0) {
					Curso curso = new Curso();
					curso.setNomCurso(linea[NUM_COL_NOMCURSO]);
					curso.setCodCurso(linea[NUM_COL_CODCURSO]);
					if (!"".equals(curso.getNomCurso()) && !"".equals(curso.getCodCurso())) {
						this.daoCurso.insert(curso);
					}
				}
				contador++;
			}
			reader.close();
			resul = true;
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return resul;
	}

}
