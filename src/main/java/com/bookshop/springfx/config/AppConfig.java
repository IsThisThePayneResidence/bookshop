package com.bookshop.springfx.config;

import com.bookshop.springfx.gui.ScreensConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.bookshop.springfx.control.LanguageController;
import com.bookshop.springfx.domain.LanguageModel;
import com.bookshop.springfx.domain.MessageModel;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;


@Configuration
@Import(ScreensConfig.class)
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
