package com.bookshop.controller;

import com.bookshop.addons.EditableTableCell;
import com.bookshop.domain.Product;
import com.bookshop.gui.ViewConfig;
import com.bookshop.service.accounting.api.AccountingService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Product, String> brandColumn = new TableColumn<>("Name");
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        brandColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Product, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Product, Long> numberColumn = new TableColumn<>("Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        numberColumn.setCellFactory(EditableTableCell.forTableColumn(Long.class));

        TableColumn<Product, Double> buyPriceColumn = new TableColumn<>("Number");
        buyPriceColumn.setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
        buyPriceColumn.setCellFactory(EditableTableCell.forTableColumn(Double.class));

        TableColumn<Product, Double> sellPriceColumn = new TableColumn<>("Price");
        sellPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        sellPriceColumn.setCellFactory(EditableTableCell.forTableColumn(Double.class));

        table.setItems(data);
        table.getColumns().setAll(typeColumn, nameColumn, authorColumn, brandColumn, numberColumn, sellPriceColumn);
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
