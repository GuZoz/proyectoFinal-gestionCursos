package com.ipartek.proyectofinal.controller;

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
	public String listar(Model model) {
		LOG.info("Entrando en admin");
		model.addAttribute("cursos", this.serviceCurso.listar());
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
		return "admin/curso/form";
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
	public String formularioEditar(Model model, @PathVariable() int idCurso) {
		LOG.info("Editando curso preexistente desde el backoffice. Id curso -> " + idCurso);

		model.addAttribute("curso", this.serviceCurso.buscarPorId(idCurso));
		return "admin/curso/form";
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
	@RequestMapping(value = "admin/curso/crear", method = RequestMethod.POST)
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
	@RequestMapping(value = "admin/curso/eliminar", method = RequestMethod.POST)
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