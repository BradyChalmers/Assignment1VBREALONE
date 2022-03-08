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

        List<String> geoCategory0 = query.getGeoAreaList(0);
        List<String> geoCategory1 = query.getGeoAreaList(1);
        List<String> geoCategory2 = query.getGeoAreaList(2);
        List<String> geoCategory3 = query.getGeoAreaList(3);

        request.setAttribute("category0", geoCategory0);
        request.setAttribute("category1", geoCategory1);
        request.setAttribute("category2", geoCategory2);
        request.setAttribute("category3", geoCategory3);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./geoAreaList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
