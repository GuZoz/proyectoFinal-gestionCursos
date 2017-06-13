package com.ipartek.proyectofinal.service;

import java.util.List;

import com.ipartek.proyectofinal.domain.Curso;

/**
 * Interfaz del servicio de cursos, que contiene la lógica de negocio necesaria
 * para la visualización y mantenimiento de los registros de curso
 * 
 * @author guillermo
 *
 */
public interface ServiceCurso {

	/**
	 * Método que lista el total de cursos guardados en la BBDD
	 * 
	 * @return - lista de objetos Curso
	 */
	List<Curso> listar();

	/**
	 * Método que lista los 10 últimos cursos guardados en la BBDD
	 * 
	 * @return - lista de objetos Curso
	 */
	List<Curso> listar10Ultimos();

	/**
	 * Método que devuelve la lista con los cursos de la BBDD correspondientes
	 * al texto a filtrar pasado como parámetro. Este método filtrará contra los
	 * campos nomCurso y codCurso de los cursos guardados
	 *
	 * @param textoFiltrar
	 *            parámetro (variable de tipo string) a filtrar
	 * @return - devuelve un Array list de objetos Curso
	 */
	List<Curso> listarBusqueda(String textoFiltrar);

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

	/**
	 * Método que migra un fichero csv con los registros de cursos a la BBDD de
	 * gestion de cursos
	 * 
	 * @param rutaAcceso
	 *            variable string con la ruta de acceso al archivo csv a migrar
	 */
	void migrarCSV(String rutaAcceso);

}
