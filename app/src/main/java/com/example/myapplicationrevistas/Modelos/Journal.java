package com.example.myapplicationrevistas.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Journal {

    //Propiedas del journal
    private String journal_id;
    private String portada;
    private String abbreviation;
    private String description;
    private String journalThumbnail;
    private String name;
    public Journal(JSONObject a) throws JSONException {
        setJournal_id(a.getString("journal_id").toString());
        setPortada(a.getString("portada").toString());
        //setAbbreviation(a.getString("abbreviation").toString());
        setDescription(a.getString("description").toString());
        setJournalThumbnail(a.getString("journalThumbnail").toString());
        setName(a.getString("name").toString());
    }
    public static ArrayList<Journal> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Journal> journals = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            journals.add(new Journal(datos.getJSONObject(i)));
        }
        return journals;
    }

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJournalThumbnail() {
        return journalThumbnail;
    }

    public void setJournalThumbnail(String journalThumbnail) {
        this.journalThumbnail = journalThumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
