package com.bookshop.controller;

import com.bookshop.domain.LanguageModel.Language;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

//@Component
@SuppressWarnings("SpringJavaAutowiringInspection")
public class ProductsController extends ViewController {

    private static final Logger logger = LogManager.getLogger(ProductsController.class);

    public ProductsController(ViewConfig config) {
        super(config);
    }

    @FXML
    TableView<Product> table;

    @Autowired
    private LanguageController langCtr;

    @Autowired
    private AccountingService accountingService;

    private ObservableList<Product> data;

    //// TODO: 5/31/16 This is just for presentation - remove later
    @SuppressWarnings("unchecked")
//    @PostConstruct
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

        logger.debug("Table : " + (table == null ? "null" : table.toString()));
        logger.info("Table : " + (table == null ? "null" : table.toString()));
        logger.warn("Table : " + (table == null ? "null" : table.toString()));

        table.getColumns().setAll(typeColumn, nameColumn, authorColumn, numberColumn, sellPriceColumn);

        table.setItems(data);
    }


    @FXML
    void nextView(ActionEvent event) {
        config.loadSecond();
    }

    @FXML
    void initialize() {
        loadProductsData();
    }

}
