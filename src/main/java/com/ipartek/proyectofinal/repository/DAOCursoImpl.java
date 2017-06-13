package com.ipartek.proyectofinal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.proyectofinal.domain.Curso;
import com.ipartek.proyectofinal.repository.mapper.CursoMapper;

/**
 * Implementación de la DAO (Data Access Object) del POJO Curso
 * 
 * @author guillermo
 *
 */
@Repository(value = "daoCurso")
public class DAOCursoImpl implements DAOCurso {

	@Autowired()
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	private final Log LOGGER = LogFactory.getLog(getClass());

	@Autowired()
	@Override()
	public void setDatasource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	private static final String SQL_GET_ALL = "SELECT `id`, `nom_curso`, `cod_curso` FROM `curso` ORDER BY `id` DESC LIMIT 500;";
	private static final String SQL_GET_LAST_10 = "SELECT `id`, `nom_curso`, `cod_curso` FROM `curso` ORDER BY `id` DESC LIMIT 10;";
	private static final String SQL_GET_ALL_FILTER = "SELECT `id`, `nom_curso`, `cod_curso` FROM `curso` WHERE `nom_curso` LIKE '%' ? '%' OR `cod_curso` LIKE '%' ? '%' ORDER BY `id` DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT `id`, `nom_curso`, `cod_curso` FROM `curso` WHERE `id` = ?;";
	private static final String SQL_INSERT = "INSERT INTO `curso` (`nom_curso`, `cod_curso`) VALUES (?, ?);";
	private static final String SQL_UPDATE = "UPDATE `curso` SET `nom_curso`= ?, `cod_curso`= ? WHERE `id`= ?;";
	private static final String SQL_DELETE = "DELETE FROM `curso` WHERE `id` = ?;";

	@Override()
	public List<Curso> getAll() {
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		try {
			listaCursos = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_ALL, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.LOGGER.warn("No existen cursos todavia");
		} catch (Exception e) {
			this.LOGGER.error(e.getMessage());
		}
		return listaCursos;
	}

	@Override()
	public List<Curso> getLast10() {
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		try {
			listaCursos = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_LAST_10, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.LOGGER.warn("No existen cursos todavia");
		} catch (Exception e) {
			this.LOGGER.error(e.getMessage());
		}
		return listaCursos;
	}

	@Override()
	public List<Curso> getSearch(String textoFiltrar) {

		ArrayList<Curso> listaBusqueda = new ArrayList<Curso>();

		try {
			listaBusqueda = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_ALL_FILTER,
					new Object[] { textoFiltrar, textoFiltrar }, new CursoMapper());

		} catch (EmptyResultDataAccessException e) {

			this.LOGGER.warn("No existen cursos todavia");

		} catch (Exception e) {

			this.LOGGER.error(e.getMessage());

		}

		return listaBusqueda;
	}

	@Override()
	public Curso getById(long id) {
		Curso curso = null;
		try {
			curso = this.jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[] { id }, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.LOGGER.warn("No existen el usuario");
		} catch (Exception e) {
			this.LOGGER.error(e.getMessage());
		}

		return curso;
	}

	@Override()
	public boolean insert(final Curso curso) {
		boolean resul = false;
		try {
			int affectedRows = -1;
			KeyHolder keyHolder = new GeneratedKeyHolder();

			affectedRows = this.jdbcTemplate.update(new PreparedStatementCreator() {
				@Override()
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					final PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, curso.getNomCurso());
					ps.setString(2, curso.getCodCurso());
					return ps;
				}
			}, keyHolder);

			if (affectedRows == 1) {
				resul = true;
				curso.setId(keyHolder.getKey().longValue());
			}

		} catch (Exception e) {
			this.LOGGER.error(e.getMessage());
		}
		return resul;
	}

	@Override()
	public boolean update(Curso curso) {
		boolean resul = false;
		int affectedRows = -1;
		try {
			Object[] argumentos = { curso.getNomCurso(), curso.getCodCurso(), curso.getId() };
			affectedRows = this.jdbcTemplate.update(SQL_UPDATE, argumentos);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			this.LOGGER.error(e.getMessage());
		}
		return resul;
	}

	@Override()
	public boolean delete(long id) {
		boolean resul = false;
		try {
			int affectedRows = this.jdbcTemplate.update(SQL_DELETE, id);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (DataIntegrityViolationException e) {
			this.LOGGER.warn(e.getMessage());
		} catch (Exception e) {
			this.LOGGER.error(e.getMessage());
		}
		return resul;
	}

}
