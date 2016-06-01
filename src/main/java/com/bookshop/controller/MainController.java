package com.bookshop.controller;

import com.bookshop.domain.LanguageModel.Language;
import com.bookshop.gui.ViewConfig;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
public class MainController extends ViewController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    public MainController(ViewConfig config) {
        super(config);
    }

    @FXML
    Pane content;

    @FXML
    RadioButton engRadio;

    @FXML
    RadioButton ruRadio;

    @FXML
    ToggleGroup langGroup;

    @FXML
    ListView<String> leftMenu;

    @Value("#{'${menu.entries}'.split(',')}")
    private List<String> menuEntries;

    @FXML
    void nextView(ActionEvent event) {
        config.loadSecond();
    }

    @FXML
    void initialize() {

        menuEntries.replaceAll(s -> languageController.getString(s));

        leftMenu.setItems(FXCollections.observableArrayList(menuEntries));

        if (Language.RU.equals(languageController.getLanguage())) {
            engRadio.setSelected(false);
            ruRadio.setSelected(true);
        }
        langGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            changeLanguage();
        });
        leftMenu.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            //// TODO: 5/31/16 This is just for presentation - remove later
            if (newValue.equals(languageController.getString("menu.products"))) {
                config.loadProducts();
            }
        });
    }

    private void changeLanguage() {
        if (engRadio.isSelected())
            languageController.toEnglish();
        else
            languageController.toRussian();
    }
}
