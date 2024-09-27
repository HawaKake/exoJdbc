package gestion_pret_boutiquier.Data.Entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Client {
   
    private String telephone;
    private String surname;
    private String address;

    private List<Compte>listCompte;




    public Client() {
    }




    public Client(String surname, String telephone, String address) {
        this.surname = surname;
        this.telephone = telephone;
        this.address = address;
    }




    public void  Add(Compte compte) {
        this.listCompte.add(compte);
      
    }
    
}
