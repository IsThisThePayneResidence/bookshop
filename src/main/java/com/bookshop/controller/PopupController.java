package com.bookshop.controller;

import com.bookshop.domain.MessageModel;
import com.bookshop.gui.Modal;
import com.bookshop.gui.ViewConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class PopupController extends Modal {

    public PopupController(ViewConfig config) {
        super(config);
    }

    @Autowired
    private MessageModel model;

    @FXML
    TextField messageTf;

    @FXML
    void initialize() {
        messageTf.setText(model.getMessage());
    }

    @FXML
    void clickedOk(ActionEvent event) {
        dialog.close();
    }

    @FXML
    void onApply(ActionEvent event) {
        model.setMessage(messageTf.getText());
    }
}
