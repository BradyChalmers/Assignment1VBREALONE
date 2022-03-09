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

        List<String> name = query.getGeographicList(0);
        List<String> code = query.getGeographicList(1);
        List<String> level = query.getGeographicList(2);
        List<String> totalPopulation = query.getGeographicList(3);

        request.setAttribute("category0", name);
        request.setAttribute("category1", code);
        request.setAttribute("category2", level);
        request.setAttribute("category3", totalPopulation);

        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
