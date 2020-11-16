package com.bnitech.study.demo.module.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnitech.study.demo.mock.AnswerContent;
import com.bnitech.study.demo.mock.AnswerDto;
import com.bnitech.study.demo.mock.QuestionDto;
import com.bnitech.study.demo.mock.ResultQuestion;

@SpringBootTest
class ExcelSheetTest {

	List<QuestionDto> questionDtoList = new ArrayList<>();
	List<AnswerDto> answerDtoList = new ArrayList<>();

	@BeforeEach
	void init(){
		questionDtoList.add(new QuestionDto(2L, 2,"B"));
		questionDtoList.add(new QuestionDto(3L, 1, "C"));
		questionDtoList.add(new QuestionDto(1L, 1,"A"));

		AnswerContent answerContent1 = new AnswerContent(1L, "VVV");
		AnswerContent answerContent3 = new AnswerContent(3L, "ZZZ");
		AnswerContent answerContent2 = new AnswerContent(2L, "XXX");
		answerDtoList.add(new AnswerDto(100L, Arrays.asList(answerContent1, answerContent2, answerContent3)));
		AnswerContent answerContent6 = new AnswerContent(3L, "EEE");
		AnswerContent answerContent5 = new AnswerContent(2L, "WWW");
		AnswerContent answerContent4 = new AnswerContent(1L, "QQQ");
		answerDtoList.add(new AnswerDto(200L, Arrays.asList(answerContent4, answerContent5, answerContent6)));
	}

	@Test
	void testGrouping(){
		List<ResultQuestion> resultQuestions = new ArrayList<>();
		questionDtoList.sort((qd1, qd2) -> {
			if (qd1.getPageNo() == qd2.getPageNo())
				return (int)(qd1.getQuestionId() - qd2.getQuestionId());
			else
				return qd1.getPageNo() - qd2.getPageNo();
		});

		for (QuestionDto questionDto : questionDtoList) {
			resultQuestions.add(new ResultQuestion(questionDto.getQuestionId()));
		}

		Stream<ResultQuestion> stream = resultQuestions.stream();
		Function<ResultQuestion, Long> classifier = ResultQuestion::getQuestionId;
		Collector<ResultQuestion, ? , Map<Long, List<ResultQuestion>>> collector = Collectors.groupingBy(classifier);
		Map<Long, List<ResultQuestion>> mapByQuestionId = stream.collect(collector);

		for (AnswerDto answerDto : answerDtoList) {
			for (AnswerContent answerContent : answerDto.getAnswerContentList()) {
				mapByQuestionId.get(answerContent.getQuestionId()).get(0).setValue(answerContent.getContent());
			}
		}

		for (Map.Entry<Long, List<ResultQuestion>> longListEntry : mapByQuestionId.entrySet()) {
			System.out.print(longListEntry.getKey()+" : ");
			longListEntry.getValue().get(0).getValues().forEach(System.out::print);
			System.out.println();
		}
	}
}