package com.bookshop.controllers;

import com.bookshop.gui.ViewConfig;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import com.bookshop.domain.LanguageModel.Language;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class DashboardController extends ViewController {

    public DashboardController(ViewConfig config) {
        super(config);
    }

    @FXML
    RadioButton engRadio;

    @FXML
    RadioButton ruRadio;

    @FXML
    ToggleGroup langGroup;

    @FXML
    ListView<String> leftMenu;

    @Autowired
    private LanguageController langCtr;

    @Value("#{'${menu.entries}'.split(',')}")
    private List<String> menuEntries;

    @FXML
    void nextView(ActionEvent event) {
        config.loadSecond();
    }

    @FXML
    void initialize() {
        leftMenu.setItems(FXCollections.observableArrayList(menuEntries));
        if (Language.RU.equals(langCtr.getLanguage())) {
            engRadio.setSelected(false);
            ruRadio.setSelected(true);
        }
        langGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                changeLanguage();
            }
        });
    }

    private void changeLanguage() {
        if (engRadio.isSelected())
            langCtr.toEnglish();
        else
            langCtr.toRussian();
    }
}
