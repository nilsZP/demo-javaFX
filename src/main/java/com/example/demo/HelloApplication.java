package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Button startKnop = new Button("Start");
        startKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ObservableList<Vereniging> verenigingenLijst = getVerenigingenLijst();
                VerenigingenScherm.maakVerenigingStage(verenigingenLijst).show();
            }
        });

        VBox root = new VBox(5);
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(startKnop);
        primaryStage.setTitle("Beheer van verenigingen");
        primaryStage.setScene(new Scene(root,430,435));
        primaryStage.show();
    }

    private ObservableList<Vereniging> getVerenigingenLijst() {
        Vereniging vereniging = new Vereniging("Scouts","00762535","scouts@maikl.com","scoutslaan 1");
        Vereniging vereniging1 = new Vereniging("chiro","092733322","chiro@stop.nee","chirolaan 2");
        ObservableList<Vereniging> verenigingenLijst = FXCollections.observableArrayList(vereniging,vereniging1);
        return verenigingenLijst;
    }

    public static void main(String[] args) {
        launch();
    }
}