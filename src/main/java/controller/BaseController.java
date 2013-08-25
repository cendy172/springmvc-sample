package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model)
	{
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;

	}

	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public ModelAndView welcomeName(@PathVariable String name, ModelMap model)
	{
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + name);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
