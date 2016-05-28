package com.bookshop.springfx.gui;

public abstract class Modal extends ViewController {

    protected ModalDialog dialog;

    public Modal(ScreensConfig config) {
        super(config);
    }

    public void setDialog(ModalDialog dialog) {
        this.dialog = dialog;
    }
}