package ticomo.app.controller;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ticomo.app.model.Administrador;
import ticomo.app.model.Plato;
import ticomo.app.model.Rider;
import ticomo.app.service.AdministradorService;
import ticomo.app.service.ClienteService;
import ticomo.app.service.PlatoService;
import ticomo.app.service.RestauranteService;
import ticomo.app.service.RiderService;

@Controller
@RequestMapping("/admin")
public class AdministradorController {

	@Autowired
	private AdministradorService adminService;

	@Autowired
	private RiderService riderService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private RestauranteService restauranteService;

	@Autowired
	private PlatoService platoService;

	@GetMapping("/admin-view")
	public String getAdministradorView(Model model) {
		model.addAttribute("listTab", "active");
		/*
		 * model.addAttribute("listTab1", "active"); model.addAttribute("listTab2",
		 * "active"); model.addAttribute("listTab3", "active");
		 */
		model.addAttribute("crearAdmin",true);
		model.addAttribute("adminForm", new Administrador());
		model.addAttribute("crearRider",true);
		model.addAttribute("riderForm", new Rider());
		model.addAttribute("platoForm", new Plato());
        model.addAttribute("platoList", platoService.getAllPlatos());

		model.addAttribute("adminList", adminService.leerAdministradores());
		model.addAttribute("riderList", riderService.leerRiders());
		model.addAttribute("clienteList", clienteService.consultarClientes());
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());

		return "users/admin-view";

	}

	@PostMapping("/crearAdmin")
	public String signupAction(@Valid @ModelAttribute("adminForm")Administrador admin, BindingResult result, ModelMap model) {
		admin.setRol("ADMIN");
		model.addAttribute("adminForm", admin);
		model.addAttribute("crearAdmin",true);
		
		if(result.hasErrors()) {
			return "users/admin-view";
		}else {
			try {
				adminService.guardarAdministrador(admin);

			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return "users/admin-view";
	}
	
	@PostMapping("/crearRider")
	public String signupAction(@Valid @ModelAttribute("riderForm") Rider rider, BindingResult result, ModelMap model) {
		rider.setRol("RIDER");
		model.addAttribute("riderForm", rider);
		model.addAttribute("crearRider",true);
		
		if(result.hasErrors()) {
			return "user-form/admin-view";
		}else {
			try {
				riderService.guardarRider(rider);

			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return index();
	}
	@GetMapping({"/","/login"})
    public String index() {
        return "index";
    }
	

	@PostMapping(value = "/guardarAdmin")
	public void crearAdmin(@RequestBody @ModelAttribute("Administrador") Administrador admin) {
		this.adminService.guardarAdministrador(admin);
	}

	@GetMapping(value = "/leerAdminPorEmail", produces = "application/json")
	@ResponseBody
	public Administrador leerAdminPorEmail(@RequestHeader String email) {
		Administrador admin = this.adminService.leerAdminPorEmail(email);
		return admin;

	}

	@GetMapping(value = "/leerAdministradores", produces = "application/json")
	@ResponseBody
	public Iterable<Administrador> leerAdministradores() {
		Iterable<Administrador> administradores = this.adminService.leerAdministradores();
		return administradores;
	}

	@GetMapping("/borrarAdminPorEmail/{email}")
	public String borrarAdminPorEmail(Model model, @PathVariable(name = "email") String email) {
		try {
			this.adminService.borrarAdminPorEmail(email);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return getAdministradorView(model);
	}

	private void baseAdminForm(Model model, Administrador admin,String activeTab) {
		model.addAttribute("adminForm", admin);
		model.addAttribute(activeTab,"active");
	}
	
	@GetMapping("/adminForm")
	public String adminForm(Model model) {
		baseAdminForm(model, new Administrador(), "listTab" );
		return "users/admin-form";
	}
	
	private void baseRiderForm(Model model, Rider rider,String activeTab) {
		model.addAttribute("riderForm", rider);
		model.addAttribute(activeTab,"active");
	}
	
	@GetMapping("/riderForm")
	public String riderForm(Model model) {
		baseRiderForm(model, new Rider(), "listTab" );
		return "users/rider-form";
	}
}
