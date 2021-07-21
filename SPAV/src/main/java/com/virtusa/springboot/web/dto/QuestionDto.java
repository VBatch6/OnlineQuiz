package com.virtusa.springboot.web.dto;

public class QuestionDto {
	private String title;
	
	private String optionA;
	private String optionB;
	private String optionC;
	private int ans;
	public QuestionDto(String title, String optionA, String optionB, String optionC, int ans) {
		super();
		this.title = title;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.ans = ans;
	}
	public QuestionDto() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public int getAns() {
		return ans;
	}
	public void setAns(int ans) {
		this.ans = ans;
	}
	@Override
	public String toString() {
		return "QuestionDto [title=" + title + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC
				+ ", ans=" + ans + "]";
	}
	
	

}
