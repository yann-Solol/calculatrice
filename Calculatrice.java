package com.occalculatrice.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculatrice")
public class Calculatrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Calculatrice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double resultat = 0;
		double n1;
		double n2;
		String submit = request.getParameter("submit");
		
		if(request.getParameter("n1") != null && !request.getParameter("n1").isEmpty()){
			n1 = Double.parseDouble(request.getParameter("n1"));
		}else{
			n1 = 0;
		}

		if( request.getParameter("n2") != null && !request.getParameter("n2").isEmpty()){
			n2 = Double.parseDouble(request.getParameter("n2"));
		}else{
			n2 = 0;
		}
		
		String operateur = request.getParameter("op");	
				
		if (operateur.equals("+")){
			resultat = n1 + n2;
		}
		else if (operateur.equals("-")){
			resultat = n1 - n2;
		}
		if (operateur.equals("*")){
			resultat = n1 * n2;
		}
		if (operateur.equals("/") && n2 != 0){
			resultat = n1 / n2;
		}
		
		request.setAttribute("n1", n1);
		request.setAttribute("n2", n2);
		request.setAttribute("op", operateur);
		request.setAttribute("resultat", resultat);
		request.setAttribute("submit", submit);	
				
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/calculatrice.jsp")
				.forward(request, response);
	}

}
