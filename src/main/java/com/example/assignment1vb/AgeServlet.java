package com.example.assignment1vb;

import com.example.assignment1vb.QueryUtil;
import com.example.assignment1vb.AgeGroup;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AgeServlet", value = "/AgeServlet")
public class AgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //define query variable
        QueryUtil query = new QueryUtil();

        //list ages for first census
        List<AgeGroup> age = query.getAgeList("1");
        for(AgeGroup a:age) {
            //change 1 to 2011
            a.setCensusYear("2011");
        }
        //list ages for second census
        List<AgeGroup> age2 = query.getAgeList("2");
        for(AgeGroup a:age2) {
            //change 2 to 2016
            a.setCensusYear("2016");
        }

        //set request attributes
        request.setAttribute("age2011", age);
        request.setAttribute("age2016", age2);

        //redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("AgeList.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("DatabaseHome.jsp");
        dispatcher.forward(request, response);
    }
}
