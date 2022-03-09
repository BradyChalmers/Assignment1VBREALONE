package com.example.assignment1vb;

import com.example.assignment1vb.QueryUtil;
import com.example.assignment1vb.GeographicArea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GeographicDetailsServlet", value = "/GeographicDetailsServlet")
public class GeographicDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QueryUtil query = new QueryUtil();

        List<GeographicArea> geographicAreaDetails = query.getGeographicDetailsList();

        for (GeographicArea area : geographicAreaDetails){
            switch (area.getLevel()){
                case "0":

                    List<String> nestedAreas = new ArrayList<String>();

                    for (GeographicArea nestedArea : geographicAreaDetails){
                        if (nestedArea.getLevel().equals("1")){
                            nestedAreas.add(nestedArea.getName());
                        }
                    }
                    area.setNestedAreas(nestedAreas);
                    break;

                case "1":

                    List<String> provinceAreas = new ArrayList<String>();

                    for (GeographicArea nestedArea : geographicAreaDetails){
                        if(nestedArea.getLevel().equals("2") && nestedArea.getAltCode().substring(0,2).equals(nestedArea.getAltCode())){
                            provinceAreas.add(nestedArea.getName());
                        }
                    }
                    area.setNestedAreas(provinceAreas);
                    break;

                case "2":

                    List<String> deepSubNestedAreas = new ArrayList<String>();

                    for (GeographicArea subNestedArea : geographicAreaDetails){
                        if (subNestedArea.getLevel().equals("3") && subNestedArea.getAltCode().substring(2,5).equals(subNestedArea.getAltCode())){
                            deepSubNestedAreas.add(subNestedArea.getName());
                        }
                    }
                    area.setNestedAreas(deepSubNestedAreas);
                    break;

                default:
                    break;
            }
        }

        request.setAttribute("geographicArea", geographicAreaDetails);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./geoAreaDetails.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
