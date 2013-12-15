package ch.bfh.swos.bookapp.service.config;

import ch.bfh.swos.bookapp.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by rovi on 13.12.13.
 */
@Configuration
@ComponentScan("ch.bfh.swos.bookapp.service.impl")
@Import(PersistenceConfig.class)
public class ServiceConfig {

}
