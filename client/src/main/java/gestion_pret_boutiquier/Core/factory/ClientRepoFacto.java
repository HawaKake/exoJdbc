package gestion_pret_boutiquier.Core.factory;

import gestion_pret_boutiquier.Core.Repository;
import gestion_pret_boutiquier.Data.Entity.Client;
import gestion_pret_boutiquier.Data.Repository.BD.ClientRepoBD;
import gestion_pret_boutiquier.Data.Repository.List.ClientRepoList;

public class ClientRepoFacto {
    private Repository <Client> clientRepo;

    public ClientRepoFacto() {
    }

    public Repository <Client> instanceClientRepoFacto() {
      //return  clientRepo=new ClientRepoList();
      return clientRepo=new ClientRepoBD();
      
      

    }

    
}
