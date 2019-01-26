package servlet;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Calcul;

//etant donne que les informations ne sont pas sensibles, on peut passer par la methode GET

public class Result extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Result(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/resultat.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //on gere les champs vides en passant par une variable temporaire qui accepte la valeur null
        String tmp = request.getParameter("nb1");
        if(tmp == ""){
            tmp = "0";
        }
        int a = Integer.parseInt(tmp);
        tmp = request.getParameter("nb2");
        if (tmp == ""){
            tmp = "0";
        }
        int b = Integer.parseInt(tmp);
        int op = Integer.parseInt(request.getParameter("oper"));

        Calcul calc = new Calcul(a,b,op);
        String res = calc.toString();

        request.setAttribute("res", res);

        this.getServletContext().getRequestDispatcher("/resultat.jsp").forward(request, response);
    }
}
