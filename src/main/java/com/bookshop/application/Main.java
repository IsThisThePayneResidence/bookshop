package com.bookshop.application;

import com.bookshop.config.AppConfig;
import com.bookshop.domain.LanguageModel;
import com.bookshop.gui.ViewConfig;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        launchApp(Main.class, args);
    }

}
