package ua.dev.team.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ua.dev.team.validator.UserValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ua.dev.team.controllers", "ua.dev.team.config",
                                "ua.dev.team.validator"})
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
    private static final String PREFIX = "/WEB-INF/views/";
    private static final String SUFFIX = ".jsp";
    private static final String RESOURCES_URL = "/resources/";
    private static final String LOGIN_URL = "/login";
    private static final String LOGIN_VIEW_NAME = "login";

    @Autowired
    private UserValidator userValidator;

    /** Указывает Spring'у где находятся компоненты представления, и как их отображать. */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setContentType(CONTENT_TYPE);
        viewResolver.setPrefix(PREFIX);
        viewResolver.setSuffix(SUFFIX);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }
    /** Указывает где будут хранится ресурсы. */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry resource) {
        resource.addResourceHandler(RESOURCES_URL + "**").addResourceLocations(RESOURCES_URL);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/validation");
        return messageSource;
    }

    @Override
    public Validator getValidator() {
        return userValidator;
    }

    /**
     * Настройка логин-контроллера.
     * Оказывает помощь в регистрации простого автоматизированного логин-контроллера предварительно
     * сконфигурированных с кодом состояния и вьюшкой.
     *
     * @param viewController Объект класса ViewControllerRegistry.

    @Override
    public void addViewControllers(ViewControllerRegistry viewController) {
        viewController.addViewController(LOGIN_URL).setViewName(LOGIN_VIEW_NAME);
        viewController.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }*/
}
