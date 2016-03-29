package com.yubaraj.validator;

/**
 * Sample model class.
 * 
 * @author Yuba Raj Kalathoki
 * @since 0.1.0
 */
public class MyModel {
	@QuestionRequired
	private String question;
	private String answer;

	public MyModel(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
