package com.ipartek.proyectofinal.domain;

/**
 * Clase POJO de Curso
 * 
 * @author guillermo
 *
 */
public class Curso {

	private long id;
	private String nomCurso;
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
	 * @param nomCurso
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
