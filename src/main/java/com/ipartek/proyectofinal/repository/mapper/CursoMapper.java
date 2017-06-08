package com.ipartek.proyectofinal.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.proyectofinal.domain.Curso;

/**
 * Mapeador del Resultset a un objeto Curso
 * 
 * @author guillermo
 *
 */
public class CursoMapper implements RowMapper<Curso> {

	@Override()
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Curso curso = new Curso();

		curso.setId(rs.getLong("id"));
		curso.setNomCurso(rs.getString("nom_curso"));
		curso.setCodCurso(rs.getString("cod_curso"));

		return curso;
	}
}
