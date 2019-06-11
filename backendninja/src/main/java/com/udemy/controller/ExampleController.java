package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;



@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	
	
	@Autowired
	@Qualifier("exampleService") 				//nombre del bean (la clase )
	private ExampleService exampleService;		//inyectamos el interfaz

	@Autowired
	@Qualifier("exampleComponent") 		//nombre del bean a inyectar
	private ExampleComponent exampleComponent;

	// Primera forma: para cuando hacemos redirecciones o hay que insertar pocos datos
	@GetMapping("/exampleString") 		// a partir de Spring v4.3
	// @RequestMapping(value="/exampleString", method=RequestMethod.GET) //Anotacion vieja
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}

	// Segunda forma: para cuando hay que insertar datos en las plantillas (muchos datos)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}

}
