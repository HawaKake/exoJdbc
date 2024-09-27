package gestion_pret_boutiquier.Core.factory;

import gestion_pret_boutiquier.Core.Repository;
import gestion_pret_boutiquier.Data.Entity.Client;
import gestion_pret_boutiquier.Data.Entity.Compte;
import gestion_pret_boutiquier.Data.Repository.List.ClientRepoList;
import gestion_pret_boutiquier.Data.Repository.List.CompteRepoList;
import gestion_pret_boutiquier.Data.Repository.BD.CompteRepoBD;

public class CompteRepoFacto {

     private Repository <Compte> compteRepo;
     

    public Repository <Compte> instanceCompteRepoFacto() {
      //return compteRepo=new CompteRepoList();
      return compteRepo=new CompteRepoBD();
    
      
      

    }
    
}
