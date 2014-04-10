package ch.bfh.swos.bookapp.rest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by rovi on 13.12.13.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[]{ServiceConfig.class};
        return new Class<?>[]{}; // empty since pivotalcf does not yet support xml less config (usees web.xml instead)
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[]{WebConfig.class};
        return new Class<?>[]{}; // empty since pivotalcf does not yet support xml less config (usees web.xml instead)
    }

    @Override
    protected String[] getServletMappings() {
//        return new String[]{"/rest/*"};
        return new String[]{}; // empty since pivotalcf does not yet support xml less config (usees web.xml instead)
    }
}