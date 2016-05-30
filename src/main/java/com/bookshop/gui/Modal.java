package com.bookshop.gui;

import com.bookshop.controllers.ViewController;

public abstract class Modal extends ViewController {

    protected ModalDialog dialog;

    public Modal(ViewConfig config) {
        super(config);
    }

    public void setDialog(ModalDialog dialog) {
        this.dialog = dialog;
    }
}