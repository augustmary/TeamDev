package ua.dev.team.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ua.dev.team.controllers", "ua.dev.team.config",
                                "ua.dev.team.validator"})
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
    private static final String PREFIX = "/WEB-INF/views/";
    private static final String SUFFIX = ".jsp";
    private static final String RESOURCES_URL = "/resources/";

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
}
