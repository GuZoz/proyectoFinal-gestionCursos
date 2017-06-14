package com.ipartek.proyectofinal.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	/**
	 * Logger del AdminController.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	/**
	 * Inicializamos serviceCurso.
	 */
	@Autowired()
	private ServiceCurso serviceCurso;

	/**
	 * Método de AdminController que lista todos los cursos.
	 * 
	 * @param model
	 *            atributos para la vista
	 * @param locale
	 *            atributos para la vista
	 * @return al index.jsp
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Locale locale, Model model, @RequestParam(value = "msg", required = false) String msg) {
		LOG.info("Entrando en el backoffice! " + "El locale del cliente es {}.", locale);

		model.addAttribute("msg", msg);
		model.addAttribute("cursos", this.serviceCurso.listar());

		return "admin/index";
	}

	/**
	 * Método de AdminController que abre el formulario con un curso nuevo para
	 * poder crearlo.
	 * 
	 * @param model
	 *            atributos para la vista
	 * @return al form.jsp
	 */
	@RequestMapping(value = "/admin/curso/edit", method = RequestMethod.GET)
	public String formularioCrear(Model model) {
		LOG.info("Creando nuevo curso en la base de datos");

		model.addAttribute("curso", new Curso());
		return "admin/form";
	}

	/**
	 * Método de AdminController que abre el formulario con un registro de curso
	 * para modificarlo/eliminarlo
	 * 
	 * @param model
	 *            atributos para la vista
	 * @param id
	 *            de curso
	 * @return al form.jsp
	 */
	@RequestMapping(value = "/admin/curso/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(Model model, @PathVariable() int id) {
		LOG.info("Editando curso preexistente en la base de datos. Id curso -> " + id);

		model.addAttribute("curso", this.serviceCurso.buscarPorId(id));
		return "admin/form";
	}

	/**
	 * Método de AdminController que llama al servicio para crear o modificar el
	 * curso
	 * 
	 * @param model
	 *            atributos para la vista
	 * @param curso
	 *            de Curso
	 * @return index.jsp vuelve al index de admin
	 */
	@RequestMapping(value = "curso/crear", method = RequestMethod.POST)
	public String crear(Model model, @Valid() Curso curso, BindingResult bindingResult) {
		LOG.info("Creando/modificando registro de curso desde Post");

		if (bindingResult.hasErrors()) {
			return "admin/form";
		}

		String msg = "Error al modificar o crear el nuevo curso";
		if (curso.getId() == -1) {
			boolean resulCrearCurso = this.serviceCurso.crear(curso);
			if (resulCrearCurso) {
				msg = "Curso creado con exito";
			}
		} else {
			boolean resulModificarCurso = this.serviceCurso.modificar(curso);
			if (resulModificarCurso) {
				msg = "Curso modificado con exito";
			}
		}
		model.addAttribute("msg", msg);
		model.addAttribute("cursos", this.serviceCurso.listar());
		return "redirect: ../admin";
	}

	/**
	 * Método de AdminController que elimina al entrada de curso
	 * 
	 * @param model
	 *            atributos para la vista
	 * @param curso
	 *            de Curso
	 * @return index.jsp vuelve al index de admin
	 */
	@RequestMapping(value = "curso/eliminar", method = RequestMethod.POST)
	public String eliminar(Model model, Curso curso) {
		LOG.info("Eliminando registro de curso desde Post");
		String msg = "Error al eliminar el registro de curso";
		if (this.serviceCurso.eliminar(curso.getId())) {
			msg = "Curso eliminado correctamente de la base de datos";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("curso", new Curso());
		model.addAttribute("cursos", this.serviceCurso.listar());
		return "redirect: ../admin";
	}

	/**
	 * Método de AdminController que vuelca las entradas de un csv a la BBDD
	 * 
	 * @param model
	 *            atributos para la vista
	 * @return index.jsp vuelve al index de admin
	 */
	@RequestMapping(value = "/admin/migrar", method = RequestMethod.GET)
	public String migrarCSVaBBDD(Model model, @RequestParam(value = "ruta", required = true) String rutaAccesoCSV) {
		boolean resulMigracion = false;
		resulMigracion = this.serviceCurso.migrarCSV(rutaAccesoCSV);
		String msg = "Error al migrar el archivo CSV a la base de datos. "
				+ "Compruebe que la ruta de acceso al archivo sea correcta y "
				+ "no contenga espacios, y que el contenido del archivo y su " + " formato sean adecuados ";
		if (resulMigracion) {
			msg = "Migracion del archivo CSV a la base de datos realizada con éxito";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("cursos", this.serviceCurso.listar());

		return "redirect: ../admin";
	}

}
