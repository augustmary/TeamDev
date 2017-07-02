package ua.dev.team.config;

import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    public AppInit() {
        super();
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        WebApplicationContext ctx =  super.createRootApplicationContext();
        Environment env = ctx.getEnvironment();

        return ctx;
    }

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        // Управление жизненным циклом корневого контекста приложения
        servletContext.addListener(new SessionListener());
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
    }

    @Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        final DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return dispatcherServlet;
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{DataConfig.class, SecurityConfig.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    private static class SessionListener implements HttpSessionListener {
        /**
         * Интервал времени.
         */
        private static final int INTERVAL = 30 * 24 * 60 * 60;

        /**
         * Получает уведомление о том, что был создан сеанс.
         * Максимальный интервал активности 1 день.
         *
         * @param sessionEvent Объект класса HttpSessionEvent, содержащий сессию.
         */
        public void sessionCreated(HttpSessionEvent sessionEvent) {
            sessionEvent.getSession().setMaxInactiveInterval(INTERVAL);
        }

        /**
         * Получает уведомление о том, что сессия вскоре будет признана недействительной.
         *
         * @param sessionEvent Объект класса HttpSessionEvent, содержащий сессию.
         */
        public void sessionDestroyed(HttpSessionEvent sessionEvent) {
            sessionEvent.getSession().invalidate();
        }

    }
}
