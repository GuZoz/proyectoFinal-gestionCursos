package com.ipartek.proyectofinal.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.proyectofinal.domain.Curso;
import com.ipartek.proyectofinal.service.ServiceCurso;

/**
 * Controladores del Backoffice del proyecto final - Gestión de Cursos. Permite
 * realizar operaciones CRUD contra la BBDD de gestión de cursos
 * 
 * @author guillermo
 *
 */
@Controller()
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired()
	private ServiceCurso serviceCurso;

	/**
	 * Listar todos los cursos
	 * 
	 * @param model
	 *            atributos para la vista
	 * @return al index.jsp
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Locale locale, Model model) {
		LOG.info("Entrando en el backoffice! El locale del cliente es {}.", locale);

		model.addAttribute("cursos", this.serviceCurso.listar());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "admin/index";
	}

	/**
	 * Abre el formulario con un curso nuevo para poder crearlo
	 * 
	 * @param model
	 *            admin
	 * @return al form.jsp
	 */
	@RequestMapping(value = "/admin/curso/edit", method = RequestMethod.GET)
	public String formularioCrear(Model model) {
		LOG.info("Creando nuevo curso desde el backoffice");

		model.addAttribute("curso", new Curso());
		return "admin/form";
	}

	/**
	 * Abre el formulario con un registro de curso para modificarlo/eliminarlo
	 * 
	 * @param model
	 *            formulario
	 * @param id
	 *            de curso
	 * @return al form.jsp
	 */
	@RequestMapping(value = "/admin/curso/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(Model model, @PathVariable() int id) {
		LOG.info("Editando curso preexistente desde el backoffice. Id curso -> " + id);

		model.addAttribute("curso", this.serviceCurso.buscarPorId(id));
		return "admin/form";
	}

	/**
	 * Llama al servicio para crear o modificar el curso
	 * 
	 * @param model
	 *            del formulario
	 * @param curso
	 *            de Curso
	 * @return index.jsp
	 */
	@RequestMapping(value = "curso/crear", method = RequestMethod.POST)
	public String crear(Model model, Curso curso) {
		LOG.info("Creando/modificando registro de curso desde Post");
		String msg = "Error al modificar/crear el nuevo Curso";
		if (curso.getId() == -1) {
			this.serviceCurso.crear(curso);
			msg = "Curso creado con exito";
		} else {
			this.serviceCurso.modificar(curso);
			msg = "Curso modificado con exito";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("cursos", this.serviceCurso.listar());
		return "admin/index";
	}

	/**
	 * Elimina al entrada de curso
	 * 
	 * @param model
	 *            model de modelo
	 * @param curso
	 *            de Curso
	 * @return index.jsp returnea al index
	 */
	@RequestMapping(value = "curso/eliminar", method = RequestMethod.POST)
	public String eliminar(Model model, Curso curso) {
		LOG.info("Eliminando registro de curso desde Post");
		String msg = "Error al eliminar el registro de curso";
		if (this.serviceCurso.eliminar(curso.getId())) {
			msg = "Curso eliminado correctamente desde el backoffice";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("curso", new Curso());
		model.addAttribute("cursos", this.serviceCurso.listar());
		return "admin/index";
	}

}
/*
 * METER EN API CONTROLER package com.ipartek.formacion.api;
 * 
 * import java.util.ArrayList;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.MediaType; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * import com.ipartek.formacion.domain.Curso; import
 * com.ipartek.formacion.service.ServiceCurso;
 * 
 * @Controller
 * 
 * @RequestMapping(value = "api/curso/") public class ApiCursoController {
 * 
 * @Autowired() private ServiceCurso serviceCurso;
 * 
 * @RequestMapping( value="", method = RequestMethod.GET, produces =
 * MediaType.APPLICATION_JSON_VALUE) public @ResponseBody ArrayList<Curso>
 * recuperarIngrediente(
 * 
 * @RequestParam(value = "filtro", required = true) String filtro) {
 * 
 * ArrayList<Curso> cursos = null; if (filtro != null){ cursos =
 * (ArrayList<Curso>) serviceCurso.buscar(filtro); } return cursos; }
 * 
 * }
 */
