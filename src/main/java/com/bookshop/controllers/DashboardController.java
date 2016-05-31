package com.bookshop.controllers;

import com.bookshop.application.AbstractJavaFxApplication;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.bookshop.domain.LanguageModel.Language;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
public class DashboardController extends ViewController {

    private static final Logger logger = LogManager.getLogger(DashboardController.class);

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

    ObservableList<Product> data;

    @Value("#{'${menu.entries}'.split(',')}")
    private List<String> menuEntries;

    //// TODO: 5/31/16 This is just for presentation - remove later
    @SuppressWarnings("unchecked")
    @FXML
    public void loadProductsData() {
        List<Product> products = accountingService.getProducts();
        data = FXCollections.observableArrayList(products);

        TableColumn<Product, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Product, String> numberColumn = new TableColumn<>("Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Product, String> buyPriceColumn = new TableColumn<>("Number");
        buyPriceColumn.setCellValueFactory(new PropertyValueFactory<>("buyPrice"));

        TableColumn<Product, String> sellPriceColumn = new TableColumn<>("Price");
        sellPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));

        table.getColumns().setAll(typeColumn, nameColumn, authorColumn, numberColumn, sellPriceColumn);

        table.setItems(data);
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
        langGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            changeLanguage();
        });
        leftMenu.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            //// TODO: 5/31/16 This is just for presentation - remove later
            if (newValue.equals("Products")) {
                loadProductsData();
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
