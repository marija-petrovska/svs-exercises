package com.web.exercise;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/history")
public class HistoryCalculatorServlet extends HttpServlet {

	ArrayList<OperationResult> results = new ArrayList<OperationResult>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("com.web.exercise.HistoryCalculatorServlet.doGet");
		showHistory(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("com.web.exercise.HistoryCalculatorServlet.doPost");
		showHistory(req, resp);
	}

	private void showHistory(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		HttpSession session = req.getSession();
		results = (ArrayList<OperationResult>) session.getAttribute("history");

		resp.setContentType("text/plain");
		for (OperationResult result : results) {
			resp.getWriter().println(result);
		}
	}
}
