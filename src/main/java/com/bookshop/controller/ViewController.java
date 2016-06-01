package com.bookshop.controller;

import com.bookshop.gui.ViewConfig;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ViewController {

    @Autowired
    protected LanguageController languageController;

    protected ViewConfig config;

    public ViewController(ViewConfig config) {
        this.config = config;
    }
}
