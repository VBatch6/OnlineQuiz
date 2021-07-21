package com.virtusa.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.virtusa.springboot.model.QuestionForm;
import com.virtusa.springboot.model.Result;
import com.virtusa.springboot.repository.ResultRepo;
import com.virtusa.springboot.model.Question;

import com.virtusa.springboot.repository.QuestionRepo;
import com.virtusa.springboot.web.dto.QuestionDto;

@Component
@Service
public class QuizService {
	private QuestionRepo questionrepo;
	
	@Autowired
	private Question question;
	@Autowired
	QuestionForm qForm;
	@Autowired
	Result result;
	@Autowired
	ResultRepo rRepo;
	
	
	public QuizService(QuestionRepo questionrepo) {
		super();
		this.questionrepo = questionrepo;
	}
	

	public QuestionForm getQuestions() {
		List<Question> allQues = questionrepo.findAll();
		/*List<Question> qList = new ArrayList<Question>();
		
		Random random = new Random();
		
		for(int i=0; i<5; i++) {
			int rand = random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}*/

		qForm.setQuestions(allQues);
		
		return qForm;
	}
	

	public Question save(QuestionDto questiondto) {
		//System.out.println(questiondto);
		Question question=new Question(questiondto.getTitle(),questiondto.getOptionA(),questiondto.getOptionB(),questiondto.getOptionC(),questiondto.getAns());
		return questionrepo.save(question);
		
    	/*User user=new User(registrationDto.getUsername(),registrationDto.getEmail(),
    			passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getRoles());
		System.out.println(registrationDto.getRoles());
    	userRepository.save(user);*/
		
	}
	public int getResult(QuestionForm qForm) {
		System.out.println(qForm);
		int correct = 0;
		
		for(Question q: qForm.getQuestions())
			if(q.getAns() == q.getChose())
				correct++;
		
		return correct;
	}
	public void saveScore(Result result) {
		Result saveResult = new Result();
		System.out.println(result.getTotalCorrect());
		//saveResult.setUsername(result.getUsername());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(saveResult);
	}
	
	

}
