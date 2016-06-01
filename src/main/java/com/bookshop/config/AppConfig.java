package com.bookshop.config;

import com.bookshop.controller.LanguageController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.bookshop.domain.LanguageModel;
import com.bookshop.domain.MessageModel;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;


@Configuration
@ComponentScan("com.bookshop")
@PropertySource("classpath:application.properties")
public class AppConfig {

//    @Bean
//    public AccountingService accountingService() {
//        return new AccountingServiceImpl();
//    }

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
