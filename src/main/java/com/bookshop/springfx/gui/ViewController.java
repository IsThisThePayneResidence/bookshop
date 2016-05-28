package com.bookshop.springfx.gui;

public abstract class ViewController {

    protected ScreensConfig config;

    public ViewController(ScreensConfig config) {
        this.config = config;
    }
}
