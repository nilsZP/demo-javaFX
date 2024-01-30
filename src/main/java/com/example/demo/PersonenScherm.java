package com.example.demo;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonenScherm {
    public static Stage maakPersonenStage(String vereniging, ObservableList<Persoon> lijst) {
        Stage personenStage = new Stage();

        TableView<Persoon> tableView = new TableView<>();
        TableColumn<Persoon,String> gebruikersnaamKolom = new TableColumn<>("Gebruikersnaam");
        TableColumn<Persoon,String> voornaamKolom = new TableColumn<>("Voornaam");
        TableColumn<Persoon,String> familienaamKolom = new TableColumn<>("Familienaam");
        TableColumn<Persoon,String> emailKolom = new TableColumn<>("Email");
        tableView.setMinWidth(400);
        tableView.setMinHeight(530);
        tableView.getColumns().addAll(gebruikersnaamKolom,voornaamKolom,familienaamKolom,emailKolom);
        gebruikersnaamKolom.setCellValueFactory(new PropertyValueFactory("gebruikersnaam"));
        voornaamKolom.setCellValueFactory(new PropertyValueFactory("voornaam"));
        familienaamKolom.setCellValueFactory(new PropertyValueFactory("familienaam"));
        emailKolom.setCellValueFactory(new PropertyValueFactory("email"));
        tableView.setItems(lijst);

        Button opzoekenKnop = new Button("Opzoeken");
        Button detailKnop = new Button("Detail");
        Button toevoegenKnop = new Button("Toevoegen");
        Button verwijderenKnop = new Button("Verwijderen");
        /*detailKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage detailStage = maakDetailStage(tableView.getSelectionModel().getSelectedItem());
                detailStage.show();
            }
        });
        toevoegenKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage toevoegenStage = maakToevoegenStage(lijst);
                toevoegenStage.show();
            }
        });*/
        verwijderenKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lijst.remove(tableView.getSelectionModel().getSelectedIndex());
            }
        });
        /*opzoekenKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage opzoekenStage = maakOpzoekenStage(lijst,tableView);
                opzoekenStage.show();
            }
        });*/


        HBox personenContainer = new HBox(10);
        personenContainer.setPadding(new Insets(15));

        VBox tabelContainer = new VBox();
        tabelContainer.getChildren().addAll(tableView);
        VBox knoppenContainer = new VBox(5);
        knoppenContainer.getChildren().addAll(opzoekenKnop,detailKnop,toevoegenKnop,verwijderenKnop);

        personenContainer.getChildren().addAll(tabelContainer,knoppenContainer);

        personenStage.setTitle("Vereniging " + vereniging + ": leden");
        personenStage.setScene(new Scene(personenContainer,550,550));
        return personenStage;
    }
}
