package ch.bfh.swos.bookapp.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by rovi on 10.04.2014.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ch.bfh.swos.bookapp.rest.controller")
public class WebConfig {
}
