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
import com.example.model.Nurse;
import com.example.service.NurseService;

@Controller
@RequestMapping("/nurses")
public class NurseController {

	private static final String MSG_SUCESS_INSERT = "Nurse inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Nurse successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Nurse successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private NurseService nurseService;
	

	@GetMapping
	public String index(Model model) {
		List<Nurse> all = nurseService.findAll();
		model.addAttribute("listNurse", all);
		return "nurse/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Nurse nurse = nurseService.findOne(id).get();
			model.addAttribute("nurse", nurse);
		}
		return "nurse/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Nurse entityNurse) {
		// model.addAttribute("nurse", entityNurse);
		
		return "nurse/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Nurse entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Nurse nurse = null;
		try {
			nurse = nurseService.save(entity);
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
		return "redirect:/nurses/" + nurse.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Nurse entity = nurseService.findOne(id).get();
				model.addAttribute("nurse", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "nurse/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Nurse entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Nurse nurse = null;
		try {
			nurse = nurseService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nurses/" + nurse.getId();
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Nurse entity = nurseService.findOne(id).get();
				nurseService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/nurses/";
	}

}
