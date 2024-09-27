package gestion_pret_boutiquier.Data.Entity;




    



import java.util.List;
import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class Compte {
   
    private String email;
    private String login;
    private String password;
    private int etat;
    private Client client;
    public Compte() {
    }
    public Compte(String email, String login, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.etat = 1;
    }

}