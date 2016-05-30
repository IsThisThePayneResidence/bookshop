package com.bookshop.config;

import com.bookshop.controllers.LanguageController;
import com.bookshop.gui.ViewConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.bookshop.domain.LanguageModel;
import com.bookshop.domain.MessageModel;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;


@Configuration
@Import(ViewConfig.class)
public class AppConfig {

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }

    @Bean
    LanguageModel languageModel() {
        return new LanguageModel();
    }

    @Bean
    LanguageController languageController() {
        return new LanguageController(languageModel());
    }

    @Bean
    MessageModel messageModel() {
        return new MessageModel();
    }
}
