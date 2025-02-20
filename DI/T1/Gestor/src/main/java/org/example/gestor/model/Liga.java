package org.example.gestor.model;

import java.io.Serializable;


public class Liga implements Serializable {
    private String idLeague;
    private String strLeague;
    private String strSport;

    public Liga(String idLeague, String strLeague, String strSport) {
        this.idLeague = idLeague;
        this.strLeague = strLeague;
        this.strSport = strSport;
    }

    public Liga() {
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    @Override
    public String toString() {
        return idLeague +" - " +strLeague;
    }
}
