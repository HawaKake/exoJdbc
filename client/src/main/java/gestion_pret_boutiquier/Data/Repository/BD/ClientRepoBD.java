package gestion_pret_boutiquier.Data.Repository.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestion_pret_boutiquier.Core.DataBaseImpl;
import gestion_pret_boutiquier.Core.Repository;
import gestion_pret_boutiquier.Data.Entity.Client;
import gestion_pret_boutiquier.Data.Entity.Compte;
import gestion_pret_boutiquier.Data.Repository.List.RepoList;

public class ClientRepoBD extends DataBaseImpl implements  Repository <Client>  {
    Connection conn=null;
    int nbre=0;

    @Override
    public boolean insert(Client cl) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gest_pret_boutiquier","root","");
            Statement statement=conn.createStatement();
        nbre=statement.executeUpdate(String.format("INSERT INTO client (telephone, address, surname) VALUES ('%s', '%s', '%s')",cl.getTelephone(),cl.getAddress(),cl.getSurname()));
            System.out.println("Connexion Bd etablie");
         } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du Driver");
         } catch (SQLException e) {
            System.out.println("Erreur de Connexion a votre BD");
        }
        return nbre==0;
    }


    



    @Override
    public List<Client> selectAll() { 
         List<Client> clients=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gest_pret_boutiquier","root","");
            Statement statement=conn.createStatement();
            ResultSet rs= statement.executeQuery("SELECT * FROM `client`");

            while (rs.next()) {
                //ligne de la table classe
                 Client cl=new Client();
                 cl.setSurname(rs.getString("surname"));
                 cl.setTelephone(rs.getString("telephone"));
                 cl.setAddress(rs.getString("address"));
                 clients.add(cl);
             }
        } catch (ClassNotFoundException e) {
            System.out.println("erreur de chargement du driver");;
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a votre BD");
        }
        return  clients;
    }


 
    
}
