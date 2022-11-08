package ticomo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ticomo.app.model.Rider;
import ticomo.app.service.RiderService;

@RestController
@RequestMapping("/rider")
public class RiderController {

	@Autowired
	private RiderService riderService;

	@PostMapping(value = "/guardarRider")
	public void guardarRider(@RequestBody @ModelAttribute("Rider") Rider rider) throws Exception {
		this.riderService.guardarRider(rider);
	}

	@GetMapping(value = "/leerRiders", produces = "application/json")
	@ResponseBody
	public List<Rider> leerRiders() {
		List<Rider> riders = this.riderService.leerRiders();
		return riders;
	}

	@GetMapping(value = "/leerRiderPorEmail", produces = "application/json")
	@ResponseBody
	public Rider leerRiderPorEmail(@RequestHeader String email) {
		Rider rider = this.riderService.leerRiderPorEmail(email);
		return rider;

	}

	@GetMapping("/borrarRiderPorEmail/{email}")
	public String borrarRiderPorEmail(Model model, @PathVariable(name = "email") String email) {
		try {
			this.riderService.borrarRiderPorEmail(email);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}

		model.addAttribute("riderList", riderService.leerRiders());
		model.addAttribute("listTab", "active");

		return "/admin/admin-view";
	}

}