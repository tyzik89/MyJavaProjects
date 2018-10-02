<<<<<<< HEAD

public class Main {

    public static void main(String[] args) {

=======
import accounts.entities.UserProfile;
import accounts.service.AccountService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.ProfileServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import servlets.WebSocketChatServlet;

public class Main {

    public static void main(String[] args) throws Exception {

        /*-------*/
        AccountService accountService = new AccountService();
        accountService.addNewUser(
                new UserProfile("vova", "1234", "vova@mail.ru", "Vladimir", "Sukmanov"));
        /*-------*/

        //Создаём хранилище сервлетов
        ServletContextHandler servletHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //Добавляем сервлеты в хранилище
        servletHandler.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        servletHandler.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        servletHandler.addServlet(new ServletHolder(new ProfileServlet(accountService)), "/profile");
        servletHandler.addServlet(new ServletHolder(new WebSocketChatServlet()), "/chat");


        //Для обращения к статическим ресурсам
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        //Путь хранения статических файлов
        resourceHandler.setResourceBase("resources/templates");
        //resourceHandler.setWelcomeFiles(new String[]{"index.html"});

        //Обработчик статических ресурсов и сервлетов одновременно
        HandlerList handlerList = new HandlerList();
        //Порядок следования очень важен - либо первым обрабатывается запросы к статическим файлам,
        //а затем запросы к сервлетам, либо наоборот
        //handlerList.setHandlers(new Handler[]{servletHandler, resourceHandler});
        handlerList.setHandlers(new Handler[]{ resourceHandler, servletHandler});

        //Создание сервера на порте 8080
        Server server = new Server(8080);
        server.setHandler(handlerList);

        //Запуск сервера
        server.start();
        //Сервер не завершается
        server.join();
>>>>>>> 0857d5935b1aa324f8f0ddfde0c879e45201c5a8
    }
}
