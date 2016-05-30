package com.bookshop.application;

import com.bookshop.config.AppConfig;
import com.bookshop.gui.ViewConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.bookshop.*" })
@PropertySource("classpath:application.properties")
@Import({AppConfig.class, ViewConfig.class})
public class Main extends AbstractJavaFxApplication {

    public static void main(String[] args) {
        launchApp(Main.class, args);
    }

}
