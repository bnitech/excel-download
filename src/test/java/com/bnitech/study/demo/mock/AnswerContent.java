package com.bnitech.study.demo.mock;

public class AnswerContent {
	private long questionId;
	private String content;

	public AnswerContent(long questionId, String content) {
		this.questionId = questionId;
		this.content = content;
	}

	public long getQuestionId() {
		return questionId;
	}

	public String getContent() {
		return content;
	}
}
