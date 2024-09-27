package gestion_pret_boutiquier.Data.Repository.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestion_pret_boutiquier.Core.Repository;
import gestion_pret_boutiquier.Data.Entity.Client;
import gestion_pret_boutiquier.Data.Entity.Compte;
import gestion_pret_boutiquier.Data.Repository.List.RepoList;

public class CompteRepoBD implements Repository <Compte> {

     Connection conn=null;
    int nbre=0;

    @Override
    public boolean insert(Compte cpt) {
       try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gest_pret_boutiquier","root","");
            Statement statement=conn.createStatement();

            //INSERT INTO `compte` (`login`, `password`, `address`, `etat`) VALUES ('hawa@gmail.com', '1234', 'point e', '1');
        nbre=statement.executeUpdate(String.format("INSERT INTO `compte` (`login`, `password`, `email`, `etat`)  VALUES ('%s', '%s', '%s','%d')",cpt.getLogin(),cpt.getPassword(),cpt.getEmail(),1));
            System.out.println("Connexion Bd etablie");
         } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du Driver");
         } catch (SQLException e) {
            System.out.println("Erreur de Connexion a votre BD");
        }
        return nbre==0;
    }

    @Override
    public List<Compte> selectAll() {
         List<Compte> comptes=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gest_pret_boutiquier","root","");
            Statement statement=conn.createStatement();
            ResultSet rs= statement.executeQuery("SELECT * FROM `compte`");

            while (rs.next()) {
                //ligne de la table classe
                 Compte cpt=new Compte();
                 cpt.setLogin(rs.getString("login"));
                 cpt.setPassword(rs.getString("password"));
                 cpt.setEmail(rs.getString("email"));
                 cpt.setEtat(rs.getInt("etat"));
                 comptes.add(cpt);
             }
        } catch (ClassNotFoundException e) {
            System.out.println("erreur de chargement du driver");;
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a votre BD");
        }
        return  comptes;
       
    }
    
}
