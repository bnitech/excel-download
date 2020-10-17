package com.bnitech.study.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/")
@RestController
public class MainController {

	@GetMapping(path = "/")
	public void getMainPage(HttpServletResponse response) throws IOException {
		response.sendRedirect("/api/v1/excel/car");
	}
}
