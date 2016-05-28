package com.bookshop.springfx.gui;

import com.bookshop.springfx.config.AppConfig;
import com.bookshop.springfx.domain.LanguageModel;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        launchApp(Main.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        logger.info("Starting application");

        Platform.setImplicitExit(true);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ScreensConfig screens = context.getBean(ScreensConfig.class);
        LanguageModel lang = context.getBean(LanguageModel.class);

        screens.setLangModel(lang);
        screens.setPrimaryStage(stage);
        screens.showMainScreen();
        screens.loadDashboard();
    }
}
