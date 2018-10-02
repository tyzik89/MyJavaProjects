package servlets;

import accounts.entities.UserProfile;
import accounts.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class SignUpServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(SignUpServlet.class.getName());
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fname = req.getParameter("firstname");
        String lname = req.getParameter("lastname");
        if (login == null || password == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserProfile userProfile = accountService.getUserByLogin(login);
        if (userProfile != null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }
        userProfile = new UserProfile(login, password, email, fname, lname);
        accountService.addNewUser(userProfile);
        accountService.addSession(req.getSession().getId(), userProfile);
        log.info("Пользователь зарегистрирован: " + userProfile.toString());
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
