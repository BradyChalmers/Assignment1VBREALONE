package com.example.assignment1vb;

import com.example.assignment1vb.QueryUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "IndividualGeographicServlet", value = "/IndividualGeographicServlet")
public class IndividualGeographicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //define query variable
        QueryUtil query = new QueryUtil();

        //Check database for users desired area
        GeographicArea ga = query.getIndividualGeoArea(request.getParameter("txtCountryName"));

        //check if area was found
        if(ga.getName() == null)
        {
            //redirect
            RequestDispatcher dispatcher = request.getRequestDispatcher("DatabaseHome.jsp");
            dispatcher.forward(request, response);
        }
        else{
            //set request variable
            request.setAttribute("GeoArea", ga);
            //redirect
            RequestDispatcher dispatcher = request.getRequestDispatcher("individualGeoAreaDetails.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
