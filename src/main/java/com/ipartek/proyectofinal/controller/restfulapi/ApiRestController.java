package com.ipartek.proyectofinal.controller.restfulapi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.proyectofinal.domain.Curso;
import com.ipartek.proyectofinal.service.ServiceCurso;

@Controller
@RequestMapping(value = "api/curso/")
public class ApiRestController {

	@Autowired()
	private ServiceCurso serviceCurso;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Curso> recuperarIngrediente(
			@RequestParam(value = "filtro", required = true) String textoFiltrar) {

		ArrayList<Curso> cursos = null;

		if (textoFiltrar != null) {
			cursos = (ArrayList<Curso>) serviceCurso.listarBusqueda(textoFiltrar);
		}

		return cursos;
	}

}
