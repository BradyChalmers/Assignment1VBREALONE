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

        List<AgeGroup> ageGroupList = query.getAgeGroupList();

        for (AgeGroup group : ageGroupList){
            if (group.getCensusYear().equals("1")){
                group.setCensusYear("2016");
            }else if (group.getCensusYear().equals("2")){
                group.setCensusYear("2011");
            }
        }
        request.setAttribute("ageGroups", ageGroupList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./ageGroupList.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
