package com.bnitech.study.demo.mock;

import java.util.ArrayList;
import java.util.List;

public class ResultQuestion {
	private long questionId;
	private List<String> values = new ArrayList<>();

	public ResultQuestion(long questionId) {
		this.questionId = questionId;
	}

	public void setValue(String value) {
		this.values.add(value);
	}

	public long getQuestionId() {
		return questionId;
	}

	public List<String> getValues() {
		return values;
	}
}
