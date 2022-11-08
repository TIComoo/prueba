package ticomo.app.controller;

import java.util.List;

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

import ticomo.app.model.Cliente;
import ticomo.app.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	
	@GetMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("signup",true);
		model.addAttribute("clientesForm", new Cliente());
		return "users/cliente-signup";
	}

	
	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("clientesForm")Cliente cliente, BindingResult result, ModelMap model) {
		cliente.setRol("USUARIO");
		model.addAttribute("clientesForm", cliente);
		model.addAttribute("signup",true);
		
		if(result.hasErrors()) {
			return "users/cliente-signup";
		}else {
			try {
				clienteService.guardarCliente(cliente);
			
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

	@PostMapping(value = "/guardarCliente")
	public void guardarUsuario(@RequestBody @ModelAttribute("Cliente") Cliente cliente) {
		this.clienteService.guardarCliente(cliente);
	}

	@GetMapping(value = "/leerClientes", produces = "application/json")
	@ResponseBody
	public List<Cliente> leerClientes() {
		List<Cliente> clientes = this.clienteService.consultarClientes();
		return clientes;
	}

	@GetMapping(value = "/leerClientePorEmail", produces = "application/json")
	@ResponseBody
	public Cliente leerClientePorEmail(@RequestHeader String email) {
		Cliente cliente = this.clienteService.leerClientePorEmail(email);
		
		return cliente;
	}

	@GetMapping("/borrarClientePorEmail/{email}")
	public String borrarClientePorEmail(Model model, @PathVariable(name = "email") String email) {
		try {
			this.clienteService.borrarClientePorEmail(email);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return "users/admin-view";
	}

}
