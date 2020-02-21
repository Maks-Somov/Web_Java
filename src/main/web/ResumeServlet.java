package main.web;

import main.storage.XMLFileStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ResumeServlet extends javax.servlet.http.HttpServlet {
    public static XMLFileStorage storage = new XMLFileStorage("D:\\\\Web_Java\\\\file_storage");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Writer w = response.getWriter();
        String name = request.getParameter("name");
        w.write(" Hi, how are you? My name ***  "+ name);
        w.close();
     /*   String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        Resume r = null;
        switch (action) {
            case "delete":
                storage.delete(uuid);
                response.sendRedirect("list");
                return;
            case "create":
                r=Resume.EMPTY;
                break;
            case "view":
            case "edit":
                try {
                    r = storage.load(uuid);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }
        request.setAttribute("resume", r);
        request.getRequestDispatcher(
                ("view".equals(action) ? "/WEB-INF/jsp/view.jsp" : "/WEB-INF/jsp/edit.jsp")
        ).forward(request, response);*/
    }
}

