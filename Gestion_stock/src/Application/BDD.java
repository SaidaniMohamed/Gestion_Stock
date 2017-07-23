package Application;

import java.net.Socket;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDD {

    Connection connection;
    Statement statment;
    String SQL;
    String url;
    public String username;
    public String password;
    Socket client;
    int Port;
    String Host;

    public BDD(String dataBase, String username, String password, String Host, int Port) {
        this.url = "jdbc:mysql://" + Host + ":" + Port + "/" + dataBase;
        this.password = password;
        this.Host = Host;
        this.Port = Port;
    }

    //fonction pour crier une connexion entre l'application et la base de donneé
    public Connection connexionDatabase() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("connection !!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println("pas de connexion avec la base de donnee" + e.getMessage());
            System.err.println(e.getMessage());//e.getMessage pour afficher ou ce trouve l erreur !
        }
        return connection;
    }

    public Connection closeconnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    //pour l exicution d'une raquete      
    public ResultSet executionQuery(String sql) {
        connexionDatabase();
        ResultSet resultSet = null;
        try {
            statment = connection.createStatement();
            resultSet = statment.executeQuery(sql);
            System.out.println(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultSet;
    }

    // pour exicuter la requete de mis a jour  ^-^
    public String executionUpdate(String sql) {
        connexionDatabase();
        String result = "";
        try {
            statment = connection.createStatement();
            statment.executeUpdate(sql);
            result = sql;
        } catch (SQLException ex) {
            result = ex.toString();
        }
        return result;
    }

    //pour afficher tous les contenue da la table ^-^
    public ResultSet querySelectAll(String nomTable) {
        // connexionDatabase();
        SQL = " select  *  from  " + nomTable;
        System.out.println(SQL);
        return this.executionQuery(SQL);

    }

    //pour afficher tout le contenue de table avec des paramétres ^-^
    public ResultSet querySelectAll(String nomTable, String etat) {
        connexionDatabase();
        SQL = " select * from " + nomTable + " where " + etat;
        return this.executionQuery(SQL);
    }

    //
    public ResultSet querySelect(String[] nomColonne, String nomTable) {
        connexionDatabase();

        SQL = "select ";
        for (int i = 0; i < nomColonne.length; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }
        SQL += "from" + nomTable;
        return this.executionQuery(SQL);

    }

    public ResultSet fcSelectCommand(String[] nomColonne, String nomTable, String etat) {
        connexionDatabase();
        int i;
        SQL = "SELECT * ";
//        for (i = 0; i < nomColonne.length; i++) {
//            SQL += nomColonne[i];
//        }
        SQL += " from " + nomTable + " where " + etat;
        return this.executionQuery(SQL);
    }

//insertion des donnees 
    public String queryInsert(String nomTable, String[] contenuTableau) {
        connexionDatabase();

        SQL = "insert into " + nomTable + "values (";

        for (int i = 0; i <= contenuTableau.length - 1; i++) {
            SQL += "'" + contenuTableau[i] + ",";
            if (i < contenuTableau.length - 1) {
                SQL = ",";
            }
        }
        SQL += ")";
        return this.executionUpdate(SQL);
    }

    public String queryInsert(String nomTable, String[] nomColonne, String[] contenuTableau) {
        connexionDatabase();

        SQL = "INSERT INTO " + nomTable + "(";
        System.out.println("la requete est0 : " + SQL);
        for (int i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
                System.out.println(SQL);
            }
        }

        SQL += ") VALUES (";
        for (int i = 0; i <= contenuTableau.length - 1; i++) {
            SQL += "'" + contenuTableau[i] + "'";
            if (i < contenuTableau.length - 1) {
                SQL += ",";
            }
        }
        SQL += ")";
        System.out.println(SQL);
        return this.executionUpdate(SQL);
    }

    //
    public String queryUpdate(String nomTable, String[] nomColonne, String[] contenuTableau, String etat) {
        connexionDatabase();
        int i;
        try {
            SQL = " update " + nomTable + " set ";
            for (i = 0; i <= nomColonne.length; i++) {
                SQL += nomColonne[i] + "='" + contenuTableau[i] + "'";
                if (i < nomColonne.length - 1) {
                    SQL += ",";
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        SQL += " where " + etat;
        return this.executionUpdate(SQL);
    }

    //fonction pour les requet supprimer :
    public String queryDelete(String nomtable) {
        connexionDatabase();
        SQL = "delete from " + nomtable;
        return this.executionUpdate(SQL);
    }

    // fonction pour requette supprimer avec condition ^^
    public String queryDelete(String nomTable, String etat) {
        connexionDatabase();
        SQL = "delete from " + nomTable + " where " + etat;
        return this.executionUpdate(SQL);
    }

    public static void main(String args[]) {
        BDD bdd = new BDD("gestion_de_stock", "amine", "amine", "localhost", 3306);
        bdd.username = "amine";
        bdd.password = "amine";
        bdd.connexionDatabase();
        System.out.println(bdd.querySelectAll("utilisateur").toString());

    }
}
