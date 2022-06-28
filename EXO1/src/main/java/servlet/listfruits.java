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
		
		List <String> listfruits = new ArrayList<String>();
		
		listfruits.add ("banana");
		listfruits.add ("banane");
		listfruits.add ("ananas");
		listfruits.add ("framboise");
		
		request.setAttribute("fruits", listfruits);

	
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/fruits.jsp").forward(request, response);
		
	}




}
