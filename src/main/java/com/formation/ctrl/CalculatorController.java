package com.formation.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.service.Calculator;

@RestController
public class CalculatorController {
	
	@Autowired
	private Calculator calculator;
	
	@GetMapping("/sum")
	public String sum (@RequestParam Integer a,@RequestParam Integer b) {
		return String.valueOf(calculator.sum(a, b));
	}
}
