package ticomo.app.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import ticomo.app.dao.RestauranteRepository;
import ticomo.app.model.Restaurante;
import ticomo.app.service.RestauranteService;



@Controller

public class RestauranteController {

	@Autowired
	RestauranteService restauranteService;
	
	@Autowired
	RestauranteRepository restauranteRepository;

	@GetMapping("/restauranteForm")
	public String getRestaurantes(Model model) {

		model.addAttribute("restauranteForm", new Restaurante());
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
		model.addAttribute("listTab", "active");

		return "restaurante-form/restaurante-view";
	}

	@PostMapping("/crearRestaurante")
	public String postCrearRestaurante(@RequestBody @ModelAttribute("restauranteForm") Restaurante restaurante,
			BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("restauranteForm", restaurante);
			model.addAttribute("formTab", "active");

		} else {

			try {
				restauranteService.createRestaurante(restaurante);
				model.addAttribute("restauranteForm", new Restaurante());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("restauranteForm", restaurante);
				model.addAttribute("formTab", "active");
				model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
			}
		}

		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());

		return "restaurante-form/restaurante-view";
	}

	@GetMapping("/editRestaurante/{nombre}")
	public String getEditarRestaurante(Model model, @PathVariable(name = "nombre") String nombre) throws Exception {

		Optional<Restaurante> restauranteToEdit = restauranteRepository.findById(nombre);

		model.addAttribute("restauranteForm", restauranteToEdit);
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");

		return "restaurante-form/restaurante-view";
	}

	@PostMapping("/editRestaurante")
	public String postEditarRestaurante( @ModelAttribute("RestauranteForm") Restaurante restaurante,
			BindingResult result, ModelMap model) {

		try {
			restauranteService.editarRestaurante(restaurante);
			model.addAttribute("restauranteForm", new Restaurante());
			model.addAttribute("listTab", "active");

		} catch (Exception e) {
			model.addAttribute("formErrorMessage", e.getMessage());
			model.addAttribute("restauranteForm", restaurante);
			model.addAttribute("formTab", "active");
			model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
			model.addAttribute("editMode", "true");

		}

		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());

		return "restaurante-form/restaurante-view";

	}

	@GetMapping("/deleteRestaurante/{nombre}")
	public String getEliminarrRestaurante(Model model, @PathVariable(name = "nombre") String nombre) throws Exception {
		try {
			restauranteService.eliminarRestaurante(nombre);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}

		model.addAttribute("restauranteForm", new Restaurante());
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
		model.addAttribute("listTab", "active");
		return "restaurante-form/restaurante-view";
	}

}

