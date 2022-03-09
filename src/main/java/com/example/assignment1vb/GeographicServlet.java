package com.example.assignment1vb;

import com.example.assignment1vb.QueryUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "GeographicServlet", value = "/GeographicServlet")
public class GeographicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //define query variable
        QueryUtil query = new QueryUtil();

        //fill different category variables
        List<String> cat1 = query.getGeographicList(0);
        List<String> cat2 = query.getGeographicList(1);
        List<String> cat3 = query.getGeographicList(2);
        List<String> cat4 = query.getGeographicList(3);

        //get value from cmb box
        String userChoice = request.getParameter("cmbCategory");

        //check value to load request variable
        switch (userChoice){
            case "0":
                request.setAttribute("category", cat1);
                break;
            case "1":
                request.setAttribute("category", cat2);
                break;
            case "2":
                request.setAttribute("category", cat3);
                break;
            case "3":
                request.setAttribute("category", cat4);
                break;
        }

        //redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("categoryArea.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
