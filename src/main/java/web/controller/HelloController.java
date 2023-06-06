package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {

		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Java pre-project. Задача 2.3.1");
		messages.add("Today: " + getToday());
		model.addAttribute("messages", messages);
		return "index";
	}

	public String getToday() {// Get the current date
		LocalDate currentDate = LocalDate.now();
		System.out.println("currentDate -> " + currentDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMM yyyy");
		return currentDate.format(formatter);
	}
	
}