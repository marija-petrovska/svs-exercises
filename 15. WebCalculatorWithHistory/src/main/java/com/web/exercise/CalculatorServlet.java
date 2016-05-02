package com.web.exercise;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

	ArrayList<OperationResult> results = new ArrayList<OperationResult>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("com.web.exercise.CalculatorServlet.doGet");
		showResult(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {

		System.out.println("com.web.exercise.CalculatorServlet.doPost");
		showResult(req, resp);
	}

	private void showResult(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		HttpSession session = req.getSession();
		final int number1 = Integer.parseInt(req.getParameter("number1"));
		final int number2 = Integer.parseInt(req.getParameter("number2"));
		final String operation = req.getParameter("operation");

		final OperationResult operationResult = new OperationResult(number1, number2, operation);
		operationResult.calculate();
		
		resp.setContentType("text/html");
		resp.getWriter().println(operationResult);
		
		results.add(operationResult);
		session.setAttribute("history", results);

	}
}
