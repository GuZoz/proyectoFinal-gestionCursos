package com.ipartek.proyectofinal.service;

import java.util.List;

import com.ipartek.proyectofinal.domain.Curso;

public interface ServiceCurso {

	/**
	 * Método que lista el total de cursos guardados en la BBDD
	 * 
	 * @return - lista de objetos Curso
	 */
	List<Curso> listar();

	/**
	 * Método que devuelve un objeto Curso de la BBDD, correspondiente al
	 * atributo id, identificador único del registro de curso a devolver, que se
	 * le pasa como parámetro
	 * 
	 * @param id
	 *            del POJO Curso
	 * @return - Objeto Curso escogido de la BBDD
	 */
	Curso buscarPorId(long id);

	/**
	 * Método que pasa un objeto Curso al DAO, para que cree una nueva entrada
	 * de Curso en la BBDD con los datos de los campos del objeto Curso que se
	 * pasa como parámetro. Devuelve un booleano True si se consigue crear la
	 * nueva entrada de curso, False en caso contrario
	 * 
	 * @param curso
	 *            Objeto curso que se trata de insertar en la BBDD
	 * @return - una variable booleana
	 */
	boolean crear(Curso curso);

	/**
	 * Método que pasa un objeto Curso al DAO, para que modifique una entrada
	 * preexistente de Curso BBDD con los datos de los campos del objeto Curso
	 * que se pasa como parámetro. Devuelve un booleano True si se consigue
	 * modificar la entrada de curso, False en caso contrario
	 * 
	 * @param curso
	 *            Objeto curso que se trata de modificar en la BBDD
	 * @return - una variable booleana
	 */
	boolean modificar(Curso curso);

	/**
	 * Método que pasa un objeto Curso al DAO, para que elimine una entrada
	 * preexistente de Curso BBDD a partir de la variable long identificadora
	 * del registro a eliminar que se pasa como parámetro. Devuelve un booleano
	 * True si se consigue eliminar la entrada de curso, False en caso contrario
	 * 
	 * @param id
	 *            variable long identificativa de la entrada de curso a eliminar
	 *            de la BBDD
	 * @return - una variable booleana
	 */
	boolean eliminar(long id);

}
