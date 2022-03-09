package com.example.assignment1vb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {

    //define db variable
    private DBUtil dbhelper;

    public void init(){
        dbhelper = new DBUtil();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //check if login info is valid
        if(dbhelper.selectUser(request.getParameter("txtUsername"), request.getParameter("txtPassword")))
        {
            //redirect
            RequestDispatcher dispatcher = request.getRequestDispatcher("DatabaseHome.jsp");
            dispatcher.forward(request, response);
        }
        else{
            //redirect
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
