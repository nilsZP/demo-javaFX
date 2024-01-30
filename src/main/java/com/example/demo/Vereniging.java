package com.example.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vereniging {
    private SimpleStringProperty naam;
    private SimpleStringProperty telefoonnummer;
    private SimpleStringProperty email;
    private SimpleStringProperty adres;

    private ObservableList<Persoon> personenLijst;

    public Vereniging(String naam, String telefoonnummer, String email, String adres) {
        this.naam = new SimpleStringProperty(naam);
        this.telefoonnummer = new SimpleStringProperty(telefoonnummer);
        this.email = new SimpleStringProperty(email);
        this.adres = new SimpleStringProperty(adres);
        this.personenLijst = FXCollections.observableArrayList();
    }

    public ObservableList<Persoon> getPersonenLijst() {
        return personenLijst;
    }

    public void setPersonenLijst(ObservableList<Persoon> personenLijst) {
        this.personenLijst = personenLijst;
    }

    public String getNaam() {
        return naam.get();
    }

    public SimpleStringProperty naamProperty() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam.set(naam);
    }

    public String getTelefoonnummer() {
        return telefoonnummer.get();
    }

    public SimpleStringProperty telefoonnummerProperty() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer.set(telefoonnummer);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getAdres() {
        return adres.get();
    }

    public SimpleStringProperty adresProperty() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres.set(adres);
    }
}
