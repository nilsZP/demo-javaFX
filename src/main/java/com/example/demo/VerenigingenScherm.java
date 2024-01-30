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

public class VerenigingenScherm {
    public static Stage maakVerenigingStage(ObservableList<Vereniging> lijst) {
        Stage verenigingStage = new Stage();

        TableView<Vereniging> tableView = new TableView<>();
        TableColumn<Vereniging,String> naamKolom = new TableColumn<>("Naam");
        TableColumn<Vereniging,String> telefoonKolom = new TableColumn<>("Telefoon");
        TableColumn<Vereniging,String> adresKolom = new TableColumn<>("Adres");
        TableColumn<Vereniging,String> emailKolom = new TableColumn<>("Email");
        tableView.setMinWidth(400);
        tableView.setMinHeight(530);
        tableView.getColumns().addAll(naamKolom,telefoonKolom,adresKolom,emailKolom);
        naamKolom.setCellValueFactory(new PropertyValueFactory("naam"));
        telefoonKolom.setCellValueFactory(new PropertyValueFactory("telefoonnummer"));
        adresKolom.setCellValueFactory(new PropertyValueFactory("adres"));
        emailKolom.setCellValueFactory(new PropertyValueFactory("email"));
        tableView.setItems(lijst);

        Button opzoekenKnop = new Button("Opzoeken");
        Button detailKnop = new Button("Detail");
        Button toevoegenKnop = new Button("Toevoegen");
        Button verwijderenKnop = new Button("Verwijderen");
        Button personenKnop = new Button("Leden");
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
        personenKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage personenStage = PersonenScherm.maakPersonenStage(tableView.getSelectionModel().getSelectedItem().getNaam(),tableView.getSelectionModel().getSelectedItem().getPersonenLijst());
                personenStage.show();
            }
        });

        HBox verenigingContainer = new HBox(10);
        verenigingContainer.setPadding(new Insets(15));

        VBox tabelContainer = new VBox();
        tabelContainer.getChildren().addAll(tableView);
        VBox knoppenContainer = new VBox(5);
        knoppenContainer.getChildren().addAll(opzoekenKnop,detailKnop,toevoegenKnop,verwijderenKnop,personenKnop);

        verenigingContainer.getChildren().addAll(tabelContainer,knoppenContainer);

        verenigingStage.setTitle("Verenigingen");
        verenigingStage.setScene(new Scene(verenigingContainer,550,550));
        return verenigingStage;
    }
}
