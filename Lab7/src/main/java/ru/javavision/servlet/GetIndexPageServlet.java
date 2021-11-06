package ru.javavision.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class GetIndexPageServlet extends HttpServlet {
    private static String index = "/WEB-INF/view/index.jsp";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher(index).forward(req, resp);
    }
}
