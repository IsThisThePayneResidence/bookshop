package com.bookshop.controllers;

import com.bookshop.domain.Product;
import com.bookshop.gui.ViewConfig;
import com.bookshop.services.accounting.api.AccountingService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.bookshop.domain.LanguageModel.Language;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
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
    TableView<Product> table;

    @FXML
    ListView<String> leftMenu;

    @Autowired
    private LanguageController langCtr;

    @Autowired
    private AccountingService accountingService;

    @Value("#{'${menu.entries}'.split(',')}")
    private List<String> menuEntries;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
//        List<Product> products = accountingService.getProducts();
//        ObservableList<Product> data = FXCollections.observableArrayList(products);

//        TableColumn<Product, String> idColumn = new TableColumn<>("ID");
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<Product, String> nameColumn = new TableColumn<>("Имя");
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//        TableColumn<Product, String> phoneColumn = new TableColumn<>("Телефон");
//        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
//
//        TableColumn<Product, String> emailColumn = new TableColumn<>("E-mail");
//        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        table.getColumns().setAll(idColumn, nameColumn, phoneColumn, emailColumn);

//        table.setItems(data);
    }


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
