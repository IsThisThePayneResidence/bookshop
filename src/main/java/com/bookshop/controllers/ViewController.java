package com.bookshop.controllers;

import com.bookshop.gui.ViewConfig;

public abstract class ViewController {

    protected ViewConfig config;

    public ViewController(ViewConfig config) {
        this.config = config;
    }
}
