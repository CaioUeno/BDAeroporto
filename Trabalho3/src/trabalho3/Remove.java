/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class Remove {

    static final String DATABASE_URL = "jdbc:postgresq://localhost/Aeroporto";
    static Connection con = null;

    public static void main(String[] args) {

        String tabela = args[0];

        try {

            con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");

            PreparedStatement remove = null;

            switch (tabela) {

                case "Piloto":
                    remove = con.prepareStatement("delete from piloto where cpf = ?");
                    remove.setString(1, args[1]);
                    break;

                case "Aeroporto":
                    remove = con.prepareStatement("delete from piloto where codigoAero = ?");
                    remove.setInt(1, Integer.parseInt(args[1]));
                    break;

                case "Aeronave":
                    remove = con.prepareStatement("delete from piloto where IDAero = ?");
                    remove.setInt(1, Integer.parseInt(args[1]));
                    break;
                case "Voo":
                    remove = con.prepareStatement("delete from piloto where codigo = ?");
                    remove.setInt(1, Integer.parseInt(args[1]));
                    break;
                case "Passageiro":
                    remove = con.prepareStatement("delete from piloto where cpf = ?");
                    remove.setString(1, args[1]);
                    break;
                case "VooInfos":
                    remove = con.prepareStatement("delete from piloto where codigoVoo = ?");
                    remove.setInt(1, Integer.parseInt(args[1]));
//                    insere.setDate(2, );
                    break;
                case "Trabalha":
                    remove = con.prepareStatement("delete from piloto where cpf = ?");
                    remove.setString(1, args[1]);
                    break;
                case "Viaja":
                    remove = con.prepareStatement("delete from piloto where cpf = ?");
                    remove.setString(1, args[1]);
                    break;

            }

            int qtdeLinhasAfetadas = remove.executeUpdate();
            System.out.println("Linhas Afetadas: " + qtdeLinhasAfetadas);

            remove.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Remove.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
