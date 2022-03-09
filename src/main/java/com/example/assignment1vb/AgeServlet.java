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
        QueryUtil query = new QueryUtil();

        List<AgeGroup> age = query.getAgeList("1");
        for(AgeGroup a:age) {
            a.setCensusYear("2011");
        }
        List<AgeGroup> age2 = query.getAgeList("2");
        for(AgeGroup a:age2) {
            a.setCensusYear("2016");
        }
        request.setAttribute("age2011", age);
        request.setAttribute("age2016", age2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("AgeList.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("DatabaseHome.jsp");
        dispatcher.forward(request, response);
    }
}
