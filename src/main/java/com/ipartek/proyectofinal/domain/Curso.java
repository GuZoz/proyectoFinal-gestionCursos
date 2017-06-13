package com.ipartek.proyectofinal.domain;

import javax.validation.constraints.Size;

/**
 * Clase POJO de Curso
 * 
 * @author guillermo
 *
 */
public class Curso {

	private static final int MIN_NOMCURSO = 3;
	private static final int MAX_NOMCURSO = 255;
	private static final int MIN_CODCURSO = 3;
	private static final int MAX_CODCURSO = 50;

	private long id;

	@Size(message = "Debe tener entre {min} y {max} caracteres", min = MIN_NOMCURSO, max = MAX_NOMCURSO)
	private String nomCurso;

	@Size(message = "Debe tener entre {min} y {max} caracteres", min = MIN_CODCURSO, max = MAX_CODCURSO)
	private String codCurso;

	/**
	 * Constructor vacio de Curso
	 */
	public Curso() {
		super();
		this.id = -1;
		this.nomCurso = "";
		this.codCurso = "";
	}

	/**
	 * Getter del atributo id del POJO Curso
	 * 
	 * @return id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Setter del atributo id del POJO Curso
	 * 
	 * @param id
	 *            del POJO Curso
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter del atributo nomCurso del POJO Curso
	 * 
	 * @return nomCurso
	 */
	public String getNomCurso() {
		return this.nomCurso;
	}

	/**
	 * Setter del atributo nomCurso del POJO Curso
	 * 
	 * @param nomCurso
	 *            del POJO Curso
	 */
	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	/**
	 * Getter del atributo codCurso del POJO Curso
	 * 
	 * @return nomCurso
	 */
	public String getCodCurso() {
		return this.codCurso;
	}

	/**
	 * Setter del atributo codCurso del POJO Curso
	 * 
	 * @param codCurso
	 *            del POJO Curso
	 */
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	@Override()
	public String toString() {
		return "Curso [nomCurso=" + this.nomCurso + ", codCurso=" + this.codCurso + "]";
	}

}
