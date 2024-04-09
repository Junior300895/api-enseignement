package sn.esp.enseignement.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Compte {

    @Id
    @Column(name= "login")
    private String login;

    @Column(name= "mot_de_passe")
    private String mot_de_passe;
    
    @Column(name= "roles")
    private String roles;

    public Compte() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getRoles() {
        return roles;
    }

    public void setRole(String role) {
        this.roles = role;
    }

}
