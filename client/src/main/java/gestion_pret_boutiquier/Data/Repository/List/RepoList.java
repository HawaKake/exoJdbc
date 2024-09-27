package gestion_pret_boutiquier.Data.Repository.List;

import java.util.ArrayList;
import java.util.List;

import gestion_pret_boutiquier.Core.Repository;

public class RepoList <T> implements Repository  <T>  {
      protected List<T> data=new ArrayList<>();

    @Override
    public boolean insert(T objet) {
        return data.add(objet);

    }

    @Override
    public List<T> selectAll() {
        return data;
    }

   
    
}
