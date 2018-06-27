package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> parameterMap = getUrlParameters(req);
        //resp.getWriter().println(PageGenerator.instance().getPage("mirror.html", parameterMap));
        resp.getWriter().println(req.getParameter("key"));
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = getUrlParameters(req);
        resp.getWriter().println(PageGenerator.instance().getPage("mirror.html", pageVariables));
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private static Map<String, Object> getUrlParameters(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<String, Object>();
        StringBuilder builder = new StringBuilder();

        Map<String, String[]> stringMap = request.getParameterMap();
        for (String s : stringMap.keySet()) {
            builder.append(String.join(" ", request.getParameterValues(s))).append(" ");
        }
        pageVariables.put("parameters", builder);
        return pageVariables;
    }
}
