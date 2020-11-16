package com.bnitech.study.demo.mock;

public class QuestionDto {
	private long questionId;
	private int pageNo;
	private String questionTitle;

	public QuestionDto(long questionId, int pageNo, String questionTitle) {
		this.questionId = questionId;
		this.pageNo = pageNo;
		this.questionTitle = questionTitle;
	}

	public long getQuestionId() {
		return questionId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}
}
