package com.bookshop.application;

import com.bookshop.config.AppConfig;
import com.bookshop.domain.LanguageModel;
import com.bookshop.gui.ViewConfig;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class AbstractJavaFxApplicationSupport extends Application {

    private static String[] savedArgs;

    protected ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(getClass(), savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);

    }

    @Override
    public void start(Stage stage) throws Exception {
//        logger.info("Starting application");

        Platform.setImplicitExit(true);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ViewConfig screens = context.getBean(ViewConfig.class);
        LanguageModel lang = context.getBean(LanguageModel.class);

        screens.setLangModel(lang);
        screens.setPrimaryStage(stage);
        screens.showMainScreen();
        screens.loadDashboard();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    protected static void launchApp(Class<? extends AbstractJavaFxApplicationSupport> appClass, String[] args) {
        AbstractJavaFxApplicationSupport.savedArgs = args;
        Application.launch(appClass, args);
    }
}
