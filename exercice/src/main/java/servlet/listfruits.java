package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listfruits
 */



public class listfruits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// EXERCICE 1 
		List <String> listfruits = new ArrayList<String>();
		
		listfruits.add ("banana");
		listfruits.add ("banane");
		listfruits.add ("ananas");
		listfruits.add ("framboise");
		
		request.setAttribute("fruits", listfruits);
		
		

		// Exercice 2
		
		String parameter = request.getParameter("isGood");

		int value;
		
		if(parameter == null) {
			value = 0;
		}else {
			value=Integer.valueOf(parameter);
		}
		
		if(value == 0) {
			request.setAttribute("isGood", "Ce n'est pas bon !");
		}else if(value ==1) {
			request.setAttribute("isGood", "C'est bon !");
				
		}
		
		
		//EXERCICE3
		
		String parametere = request.getParameter("name");

		int valuee;
		
		if(parametere == null) {
			valuee = 0;
		}else {
			valuee=Integer.valueOf(parametere);
		}
		
		if(valuee == 0) {
			request.setAttribute("name", "bonjour name !");
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/fruits.jsp").forward(request, response);		
		}
	}
		

	
	
	
