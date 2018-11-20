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
import com.example.model.MedicalRecord;
import com.example.service.PatientService;
import com.example.service.MedicalRecordService;

@Controller
@RequestMapping("/medicalRecords")
public class MedicalRecordController {
	
	
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@Autowired
	private PatientService patientService; //patient service

	// Primeira tela da pagina de MedicalRecords
	@GetMapping
	public String index(Model model) {
		List<MedicalRecord> all = medicalRecordService.findAll();
		model.addAttribute("listMedicalRecord", all);
		model.addAttribute("");
		return "medicalRecord/index";
	}
	
	// Tela de Show MedicalRecord
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			MedicalRecord medicalRecord = medicalRecordService.findOne(id).get();
			model.addAttribute("medicalRecord", medicalRecord);
		}
		return "medicalRecord/show";
	}

	// Tela com Formulario de New MedicalRecord
	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute MedicalRecord entityMedicalRecord, 
			             @ModelAttribute Patient entityPatient) {
		// model.addAttribute("medicalRecord", entityMedicalRecord);
		List<Patient> all = patientService.findAll();
		model.addAttribute("patients", all);
		
		return "medicalRecord/form";
	}
	
	// Processamento do formulario New MedicalRecord (ou Alter MedicalRecord) 
	@PostMapping
	public String create(@Valid @ModelAttribute MedicalRecord entityMedicalRecord, 
			             @Valid @ModelAttribute Patient entityPatient,
			             BindingResult result, RedirectAttributes redirectAttributes) {
		MedicalRecord medicalRecord = null;
		String pagina_retorno = "redirect:/medicalRecords/" ;
	
		try {
			medicalRecord = medicalRecordService.save(entityMedicalRecord);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
			pagina_retorno = pagina_retorno + medicalRecord.getId();
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		
		return pagina_retorno;
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		
		try {
			if (id != null) {
				List<Patient> all = patientService.findAll();
				model.addAttribute("patients", all);
				
				MedicalRecord entity = medicalRecordService.findOne(id).get();
				model.addAttribute("medicalRecord", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "medicalRecord/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute MedicalRecord entity, BindingResult result, 
			             RedirectAttributes redirectAttributes) {
		MedicalRecord medicalRecord = null;
		try {
			medicalRecord = medicalRecordService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/medicalRecords/" + medicalRecord.getId();
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				MedicalRecord entity = medicalRecordService.findOne(id).get();
				medicalRecordService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/medicalRecords/";
	}
	
	private static final String MSG_SUCESS_INSERT = "MedicalRecord inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "MedicalRecord successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted MedicalRecord successfully.";
	private static final String MSG_ERROR = "Erro na inserção do MedicalRecord";


}
