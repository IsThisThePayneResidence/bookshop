package com.bookshop.controller;

import com.bookshop.domain.Product;
import com.bookshop.gui.ViewConfig;
import com.bookshop.service.accounting.api.AccountingService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.bookshop.domain.LanguageModel.Language;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
public class DashboardController extends ViewController {

    private static final Logger logger = LogManager.getLogger(DashboardController.class);

    public DashboardController(ViewConfig config) {
        super(config);
    }

    @Autowired
    private LanguageController langCtr;

    @Autowired
    private AccountingService accountingService;

    @FXML
    void initialize() {

    }
}
