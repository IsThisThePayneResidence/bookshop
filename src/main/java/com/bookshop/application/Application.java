package com.bookshop.application;

import com.bookshop.config.AppConfig;
import com.bookshop.domain.LanguageModel;
import com.bookshop.gui.ViewConfig;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@Lazy
@PropertySource("classpath:application.properties")
@Import({AppConfig.class, ViewConfig.class})
@EntityScan(value = "com.bookshop.domain")
@EnableJpaRepositories(value = "com.bookshop.repository")
public class Application extends AbstractJavaFxApplication {

    private static final Logger logger = LogManager.getLogger(AbstractJavaFxApplication.class);

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        logger.info("Starting application");

        Platform.setImplicitExit(true);

        ViewConfig screens = context.getBean(ViewConfig.class);
        LanguageModel lang = context.getBean(LanguageModel.class);

        screens.setLangModel(lang);
        screens.setPrimaryStage(stage);
        screens.showMainScreen();
        screens.loadDashboard();
    }
}
