package com.example.demo;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
        });*/
        toevoegenKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage toevoegenStage = maakToevoegenStage(lijst);
                toevoegenStage.show();
            }
        });
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

    public static Stage maakToevoegenStage(ObservableList<Persoon> lijst) {
        Stage persoonToevoegenStage = new Stage();
        GridPane persoonToevoegenContainer = new GridPane();

        persoonToevoegenContainer.setHgap(5);
        persoonToevoegenContainer.setVgap(5);
        persoonToevoegenContainer.setPadding(new Insets(10));

        Label gebruikersnaamLabel = new Label("Gebruikersnaam: ");
        persoonToevoegenContainer.add(gebruikersnaamLabel,0,0);
        TextField gebruikersnaamVeld = new TextField();
        persoonToevoegenContainer.add(gebruikersnaamVeld,1,0);

        Label voornaamLabel = new Label("Voornaam: ");
        persoonToevoegenContainer.add(voornaamLabel,0,1);
        TextField voornaamVeld = new TextField();
        persoonToevoegenContainer.add(voornaamVeld,1,1);

        Label familienaamLabel = new Label("Familienaam: ");
        persoonToevoegenContainer.add(familienaamLabel,0,2);
        TextField familienaamVeld = new TextField();
        persoonToevoegenContainer.add(familienaamVeld,1,2);

        Label emailLabel = new Label("Email: ");
        persoonToevoegenContainer.add(emailLabel,0,3);
        TextField emailVeld = new TextField();
        persoonToevoegenContainer.add(emailVeld,1,3);

        Label aantalkinderenLabel = new Label("Aantal kinderen: ");
        persoonToevoegenContainer.add(aantalkinderenLabel,0,4);
        Spinner<Integer> aantalKinderenVeld = new Spinner<>(0,50,0);
        persoonToevoegenContainer.add(aantalKinderenVeld,1,4);

        Button toevoegenKnop = new Button("Toevoegen");
        persoonToevoegenContainer.add(toevoegenKnop,0,5);
        toevoegenKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lijst.add(new Persoon(gebruikersnaamVeld.getText(),voornaamVeld.getText(),familienaamVeld.getText(),
                        emailVeld.getText(),aantalKinderenVeld.getValue()));
                persoonToevoegenStage.close();
            }
        });

        persoonToevoegenStage.setTitle("Lid toevoegen");
        persoonToevoegenStage.setScene(new Scene(persoonToevoegenContainer,800,400));

        return persoonToevoegenStage;
    }

    public static Stage maakDetailScherm(Persoon persoon) {
        Stage detailStage = new Stage();
        VBox detailContainer = new VBox(5);
        detailContainer.setPadding(new Insets(10));

        Label gebruikersnaamLabel = new Label("Gebruikersnaam: " + persoon.getGebruikersnaam());
        Label voornaamLabel = new Label("Voornaam: " + persoon.getVoornaam());
        Label familienaamLabel = new Label("Familienaam: " + persoon.getFamilienaam());
        Label emailLabel = new Label("Email: " + persoon.getEmail());
        Label aantalkinderenLabel = new Label("Aantal kinderen: " + persoon.getAantalKinderen());

        Button sluitKnop = new Button("Sluiten");
        sluitKnop.setOnMouseClicked(mouseEvent -> {
            detailStage.close();
        });

        detailContainer.getChildren().addAll(gebruikersnaamLabel,voornaamLabel,familienaamLabel,emailLabel,aantalkinderenLabel,sluitKnop);
        detailStage.setTitle("Details van " + persoon.getGebruikersnaam() + ":");
        detailStage.setScene(new Scene(detailContainer,800,400));

        return detailStage;
    }
}
