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
import com.example.model.Doctor;
import com.example.service.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	private static final String MSG_SUCESS_INSERT = "Doctor inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Doctor successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Doctor successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private DoctorService doctorService;
	

	@GetMapping
	public String index(Model model) {
		List<Doctor> all = doctorService.findAll();
		model.addAttribute("listDoctor", all);
		return "doctor/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Doctor doctor = doctorService.findOne(id).get();
			model.addAttribute("doctor", doctor);
		}
		return "doctor/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Doctor entityDoctor) {
		// model.addAttribute("doctor", entityDoctor);
		
		return "doctor/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Doctor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Doctor doctor = null;
		try {
			doctor = doctorService.save(entity);
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
		return "redirect:/doctors/" + doctor.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Doctor entity = doctorService.findOne(id).get();
				model.addAttribute("doctor", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "doctor/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Doctor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Doctor doctor = null;
		try {
			doctor = doctorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/doctors/" + doctor.getId();
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Doctor entity = doctorService.findOne(id).get();
				doctorService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/doctors/";
	}

}
