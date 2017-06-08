package com.ipartek.proyectofinal.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.proyectofinal.domain.Curso;

/**
 * Interfaz de la DAO (Data Access Object) del POJO Curso
 * 
 * @author guillermo
 *
 */
public interface DAOCurso {
	/**
	 * Método que instancia el DataSource
	 * 
	 * @param dataSource
	 *            nos devuelve un objeto datasource
	 */
	void setDatasource(DataSource dataSource);

	/**
	 * Método que devuelve la lista total de registros de curso de la BBDD
	 * 
	 * @return - devuelve un Array list de objetos Curso
	 */
	List<Curso> getAll();

	/**
	 * Método que devuelve el curso correspondiente al atributo id que se le
	 * pasa como parámetro
	 * 
	 * @param id
	 *            Parámetro con el numero que identifica de forma unívoca a la
	 *            entrada de curso en la BBDD
	 * @return - devuelve un objeto Curso
	 */
	Curso getById(long id);

	/**
	 * Método que devuelve un booleano True si consigue insertar en la BBDD el
	 * objeto Curso pasado como parámetro, False en caso contrario
	 * 
	 * @param curso
	 *            objeto Curso
	 * @return - devuelve un booleano
	 */
	boolean insert(Curso curso);

	/**
	 * Método que devuelve un booleano True si se consigue actualizar en la BBDD
	 * el objeto Curso pasado como parámetro, Falso en caso contrario
	 * 
	 * @param curso
	 *            objeto Curso
	 * @return - devuelve un booleano
	 */
	boolean update(Curso curso);

	/**
	 * Método que devuelve un booleano True si consigue eliminar de la BBDD la
	 * entrada correspondiente al parámetro id pasado como input, Falso en caso
	 * contrario
	 * 
	 * @param id
	 *            variable long que representa el identificador único de la
	 *            entrada de curso a eliminar
	 * @return - devuelve un booleano
	 */
	boolean delete(long id);
}
