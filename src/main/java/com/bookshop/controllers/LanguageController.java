package com.bookshop.controllers;


import com.bookshop.domain.LanguageModel;
import com.bookshop.domain.LanguageModel.Language;

public class LanguageController {

    private LanguageModel model;

    public LanguageController(LanguageModel model) {
        this.model = model;
        toEnglish();
    }

    public void toEnglish() {
        model.setBundle(Language.EN);
    }

    public void toRussian() {
        model.setBundle(Language.RU);
    }

    public Language getLanguage() {
        return model.getLanguage();
    }
}
