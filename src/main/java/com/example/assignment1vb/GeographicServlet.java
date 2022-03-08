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

        QueryUtil query = new QueryUtil();

        List<String> cat0 = query.getGeographicList(0);
        List<String> cat1 = query.getGeographicList(1);
        List<String> cat2 = query.getGeographicList(2);
        List<String> cat3 = query.getGeographicList(3);

        request.setAttribute("category0", cat0);
        request.setAttribute("category1", cat1);
        request.setAttribute("category2", cat2);
        request.setAttribute("category3", cat3);

        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
