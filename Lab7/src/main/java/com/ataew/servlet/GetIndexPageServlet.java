package com.ataew.servlet;

import com.ataew.model.World;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetIndexPageServlet extends HttpServlet {

    private final static String index = "/WEB-INF/view/index.jsp";

    private  List<World> worlds;

    @Override
    public void init() throws ServletException {
        worlds = new CopyOnWriteArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("worlds", worlds);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        final String text = req.getParameter("text");
        final String symbol = req.getParameter("symbol");

        StringBuilder str = new StringBuilder(text);
        char c = symbol.charAt(0);

        int j = 3;

        for (int i = 0; i < text.length(); i++) {
            if (i == j) {
                j += 3;
                str.setCharAt(i, c);
            }
        }

        final World world = new World(String.valueOf(str), symbol);
        worlds.add(world);
        doGet(req, resp);
    }

    private boolean requestIsValid(final HttpServletRequest req) {

        final String name = req.getParameter("name");
        final String age = req.getParameter("age");

        return name != null && name.length() > 0 && age != null && age.length() > 0 && age.matches("[+]?\\d+");
    }
}
