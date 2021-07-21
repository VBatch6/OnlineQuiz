package com.virtusa.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.virtusa.springboot.model.QuestionForm;
import com.virtusa.springboot.model.Result;
import com.virtusa.springboot.service.QuizService;
import com.virtusa.springboot.web.dto.QuestionDto;


@Controller
public class MainController {
	@Autowired
	Result result;
	
	Boolean submitted = false;
	
    @Autowired
	private QuizService quizservice;
	
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/makequiz")
	public String makequiz( Model m) {
		
		QuestionDto question= new QuestionDto();
		m.addAttribute("question", question);
		
		return "makequiz.html";
	}
	
	@PostMapping("/savequestions")
	public String savequestions(@ModelAttribute("question") QuestionDto questiondto) {
		System.out.println(questiondto);
		quizservice.save(questiondto);
		return "redirect:/makequiz";
	}
	
	@GetMapping("/Takequiz")
	public String takequiz( Model m) {
		/*if(username.equals("")) {
			ra.addFlashAttribute("warning", "You must enter your name");
			return "redirect:/";
		
		System.out.println(username);
		result.setUsername(username);*/
		submitted = false;
		QuestionForm qForm = quizservice.getQuestions();
		//System.out.println(qForm);
		m.addAttribute("qForm", qForm);
		
		return "quiz";
	}
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m) {
		System.out.println(qForm);
		if(!submitted) {
		
			result.setTotalCorrect(quizservice.getResult(qForm));
			quizservice.saveScore(result);
			submitted = true;
		}
		m.addAttribute("result", result);
		
		
		return "result.html";
	}
	


}