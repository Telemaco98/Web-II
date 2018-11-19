package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.model.Patient;
import com.example.model.Student;
import com.example.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {

	private static final String MSG_SUCESS_INSERT = "Patient inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Patient successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Patient successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PatientService patientService;
	

	@GetMapping
	public String index(Model model) {
		List<Patient> all = patientService.findAll();
		model.addAttribute("listPatient", all);
		return "patient/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Patient patient = patientService.findOne(id).get();
			model.addAttribute("patient", patient);
		}
		return "patient/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Patient entityPatient, @ModelAttribute Student entityStudent) {
		// model.addAttribute("patient", entityPatient);
		
		return "patient/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Patient entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Patient patient = null;
		try {
			patient = patientService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			System.out.println("Exception:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			System.out.println("Throwable:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "redirect:/patients/" + patient.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Patient entity = patientService.findOne(id).get();
				model.addAttribute("patient", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "patient/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Patient entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Patient patient = null;
		try {
			patient = patientService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/patients/" + patient.getId();
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Patient entity = patientService.findOne(id).get();
				patientService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/patients/";
	}

}
