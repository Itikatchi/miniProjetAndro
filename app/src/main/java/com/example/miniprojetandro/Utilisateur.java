package com.example.miniprojetandro;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    private String log;
    private String mdp;

    public Utilisateur(String log, String mdp) {
        this.log = log;
        this.mdp = mdp;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


}
