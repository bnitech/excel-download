package com.bnitech.study.demo.mock;

import java.util.List;

public class AnswerDto {
	private long answerId;
	private List<AnswerContent> answerContentList;

	public AnswerDto(long answerId, List<AnswerContent> answerContentList) {
		this.answerId = answerId;
		this.answerContentList = answerContentList;
	}

	public long getAnswerId() {
		return answerId;
	}

	public List<AnswerContent> getAnswerContentList() {
		return answerContentList;
	}
}
