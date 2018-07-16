package servlets;

import accounts.entities.UserProfile;
import accounts.service.AccountService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class SignInServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(SignInServlet.class.getName());
    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    //Authentication user (Sign in)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserProfile userProfile = accountService.getUserByLogin(login);
        if (userProfile == null || !userProfile.getPassword().equals(password)) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        accountService.addSession(req.getSession().getId(), userProfile);
        Gson gson = new Gson();
        String json = gson.toJson(userProfile);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    //Sign out
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = req.getSession().getId();
        UserProfile userProfile = accountService.getUserBySessionId(sessionId);
        if (userProfile == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            accountService.deleteSession(sessionId);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Goodbye!");
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
