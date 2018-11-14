package com.example.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Module;
import com.example.model.Patient;
import com.example.model.Student;
import com.example.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {
	//TODO
}
