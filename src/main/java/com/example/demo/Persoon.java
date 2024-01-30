package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Persoon {
    private SimpleStringProperty gebruikersnaam;
    private SimpleStringProperty voornaam;
    private SimpleStringProperty familienaam;
    private SimpleStringProperty email;
    private SimpleIntegerProperty aantalKinderen;

    public Persoon(String gebruikersnaam, String voornaam, String familienaam, String email, int aantalKinderen) {
        this.gebruikersnaam = new SimpleStringProperty(gebruikersnaam);
        this.voornaam = new SimpleStringProperty(voornaam);
        this.familienaam = new SimpleStringProperty(familienaam);
        this.email = new SimpleStringProperty(email);
        this.aantalKinderen = new SimpleIntegerProperty(aantalKinderen);
    }

    public String getGebruikersnaam() {
        return gebruikersnaam.get();
    }

    public SimpleStringProperty gebruikersnaamProperty() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam.set(gebruikersnaam);
    }

    public String getVoornaam() {
        return voornaam.get();
    }

    public SimpleStringProperty voornaamProperty() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam.set(voornaam);
    }

    public String getFamilienaam() {
        return familienaam.get();
    }

    public SimpleStringProperty familienaamProperty() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam.set(familienaam);
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

    public int getAantalKinderen() {
        return aantalKinderen.get();
    }

    public SimpleIntegerProperty aantalKinderenProperty() {
        return aantalKinderen;
    }

    public void setAantalKinderen(int aantalKinderen) {
        this.aantalKinderen.set(aantalKinderen);
    }
}
