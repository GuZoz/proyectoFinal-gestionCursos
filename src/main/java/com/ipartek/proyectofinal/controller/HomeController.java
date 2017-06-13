package com.ipartek.proyectofinal.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.proyectofinal.service.ServiceCurso;

/**
 * Handles requests for the application home page.
 * 
 * @author guillermo
 *
 */
@Controller()
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired()
	private ServiceCurso serviceCurso;

	/**
	 * Selecciona la vista home y devuelve los 10 últimos cursos.
	 *
	 * @param locale
	 *            Admite un parámetro una instancia de Locale
	 * @param model
	 *            Admite como parámetro una instancia de Model
	 * @return Devuelve la vista "home.jsp"
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOGGER.info("Bienvenido a la página home! El locale del cliente es {}.", locale);

		model.addAttribute("ultimosCursos", this.serviceCurso.listar10Ultimos());

		return "home";
	}

	/**
	 * Selecciona la vista de detalle y devuelve el curso seleccionado.
	 * 
	 * @param id
	 *            Admite un parámetro un atributo id que identifica la entrada
	 *            de curso a mostrar
	 * @param model
	 *            Admite como parámetro una instancia de Model
	 * @return Devuelve a la vista "detail.jsp"
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String irDetalleCurso(@PathVariable() int id, Model model) {

		model.addAttribute("curso", this.serviceCurso.buscarPorId(id));

		return "detail";
	}

}
