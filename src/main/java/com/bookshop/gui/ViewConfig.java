package com.bookshop.gui;

import com.bookshop.controller.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import com.bookshop.domain.LanguageModel;

import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;


@Configuration
public class ViewConfig implements Observer {

    private static final Logger logger = LogManager.getLogger(ViewConfig.class);

    @Value("${ui.window.title}")
    private String windowTitle;

    @Value("#{'${ui.window.css.path}'.split(',')}")
    private List<String> styleFiles;

    @Value("${ui.window.width}")
    private Integer width;

    @Value("${ui.window.height}")
    private Integer height;

    private Stage stage;
    private Scene scene;
    private LanguageModel lang;
    private StackPane root;

    public void setPrimaryStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public void setLangModel(LanguageModel lang) {
        if (this.lang != null) {
            this.lang.deleteObserver(this);
        }
        lang.addObserver(this);
        this.lang = lang;
    }

    public ResourceBundle getBundle() {
        return lang.getBundle();
    }

    public void showMainScreen() {
        root = new StackPane();
        for (String styleFile : styleFiles) {
            root.getStylesheets().add(styleFile);
        }
        root.getStyleClass().add("main-window");
        scene = new Scene(root, width, height);
        stage.setScene(scene);
        //// TODO: 5/26/16 Set to false if responsive designs starts lagging
//        stage.setResizable(false);

        stage.setOnHiding(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                System.exit(0);
                // TODO you could add code to open an "are you sure you want to exit?" dialog
            }
        });

        stage.setTitle(windowTitle);
        stage.show();
    }

    public void setTitle(String title) {
        stage.setTitle(title);
    }

    private void setNode(String name, Node node) {
        root.getChildren().forEach(child -> {
            if (child.getId().equals("root")) {
                StackPane root = (StackPane) child;
                traceTreeAndReplaceNode(root, name, node);
            }
        });
    }

    private void traceTreeAndReplaceNode(Pane root, String nodeId, Node node) {
        root.getChildren().replaceAll(child -> {
            if (child.getId() != null && child.getId().equals(nodeId)) {
                return node;
            }
            return child;
        });
        root.getChildren().forEach(child -> {
            if (child != null && child instanceof Pane) {
                traceTreeAndReplaceNode((Pane) child, nodeId, node);
            }
        });
    }

    private void setRootNode(Node node) {
        root.getChildren().setAll(node);
    }

    private void setNodeOnTop(Node node) {
        root.getChildren().add(node);
    }

    public void removeNode(Node node) {
        root.getChildren().remove(node);
    }

    public void loadDashboard() {
        setNode("content", getNode(dashboardController(), getClass().getResource("dashboard.fxml")));
    }

    public void loadProducts() {
        setNode("content", getNode(productsController(), getClass().getResource("products.fxml")));
    }

    public void loadMain() {
        setRootNode(getNode(mainController(), getClass().getResource("main.fxml")));
    }

    public void loadSecond() {
        setRootNode(getNode(secondPresentation(), getClass().getResource("Second.fxml")));
    }

    public void loadPopup() {
        ModalDialog modal = new ModalDialog(popupPresentation(), getClass().getResource("Popup.fxml"), stage.getOwner(), lang.getBundle());
        modal.setTitle(lang.getBundle().getString("popup.title"));

        for (String styleFile : styleFiles) {
            modal.getStyleSheets().add(styleFile);
        }

        modal.show();
    }

    @Bean
    @Scope("prototype")
    DashboardController dashboardController() {
        return new DashboardController(this);
    }

    @Bean
    @Scope("prototype")
    MainController mainController() {
        return new MainController(this);
    }

    @Bean
    @Scope("prototype")
    ProductsController productsController() {
        return new ProductsController(this);
    }

    @Bean
    @Scope("prototype")
    SecondViewController secondPresentation() {
        return new SecondViewController(this);
    }

    @Bean
    @Scope("prototype")
    PopupController popupPresentation() {
        return new PopupController(this);
    }

    private Node getNode(final ViewController control, URL location) {
        FXMLLoader loader = new FXMLLoader(location, lang.getBundle());
        loader.setControllerFactory(aClass -> control);

        try {
            return (Node) loader.load();
        } catch (Exception e) {
            logger.error("Error casting node", e);
            return null;
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void update(Observable o, Object arg) {
        loadMain();
    }
}
