import accounts.AccountService;
import accounts.UserProfile;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.MirrorRequestServlet;
import servlets.SessionsServlet;
import servlets.UsersServlet;
import servlets.sign_up_in.SignInServlet;
import servlets.sign_up_in.SignUpServlet;

public class Main {

    /*задание #1
    public static void main(String[] args) throws Exception {
        //Создание сервера
        Server server = new Server(8080);

        //Создание сервлет-контейнера
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        //Создание объекта-сервлета
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        MirrorRequestServlet mirrorRequestServlet = new MirrorRequestServlet();

        //Помещение сервлета в сервлет-контейнер
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");
        context.addServlet(new ServletHolder(mirrorRequestServlet), "/mirror");

        //Передаём в сервер сервлет-контейнер
        server.setHandler(context);
        //Запуск сервера
        server.start();

        System.out.println("Server started");

        //Присоединение основного потока Main к серверу Jetti(Чтобы Main не завершился)
        server.join();
    }*/

    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();
//        accountService.addNewUser(new UserProfile("admin"));
//        accountService.addNewUser(new UserProfile("test"));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/api/v1/users");
//        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/v1/sessions");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        //обращение к статическим ресурсам
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("templates");
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        Server server = new Server(8080);
        server.setHandler(handlers);
        server.start();
        System.out.println("Server started");
        server.join();
    }
}
