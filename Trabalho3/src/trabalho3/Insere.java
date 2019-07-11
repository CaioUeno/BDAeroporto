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
public class Insere {

    static final String DATABASE_URL = "jdbc:postgresq://localhost/Aeroporto";
    static Connection con = null;

    public static void main(String[] args) {

        String tabela = args[0];

        try {

            con = DriverManager.getConnection(DATABASE_URL, "USUARIO", "SENHA");
            PreparedStatement insere = null;

            switch (tabela) {
                case "Piloto":
                    insere = con.prepareStatement("insert into "
                            + "Piloto(cpf,cht,func,nome) " + "values (?,?,?,?)");
                    insere.setString(1, args[1]);
                    insere.setString(2, args[2]);
                    insere.setString(3, args[3]);
                    insere.setString(4, args[4]);
                    break;

                case "Aeroporto":
                    insere = con.prepareStatement("insert into "
                            + "Aeroporto(codigoAero,cidade,estado,pais,nomeAero) " + "values (?,?,?,?,?)");
                    insere.setInt(1, Integer.parseInt(args[1]));
                    insere.setString(2, args[2]);
                    insere.setString(3, args[3]);
                    insere.setString(4, args[4]);
                    insere.setString(5, args[5]);
                    break;

                case "Aeronave":
                    insere = con.prepareStatement("insert into "
                            + "Aeronave(IDAero,modelo,capacidade,tipo) " + "values (?,?,?,?)");
                    insere.setInt(1, Integer.parseInt(args[1]));
                    insere.setString(2, args[2]);
                    insere.setInt(3, Integer.parseInt(args[3]));
                    insere.setString(4, args[4]);
                    break;
                case "Voo":
                    insere = con.prepareStatement("insert into "
                            + "Voo(codigo,IDAero,codAeroOri,codAeroDst) " + "values (?,?,?,?)");
                    insere.setInt(1, Integer.parseInt(args[1]));
                    insere.setInt(2, Integer.parseInt(args[2]));
                    insere.setInt(3, Integer.parseInt(args[3]));
                    insere.setInt(4, Integer.parseInt(args[4]));
                    break;
                case "Passageiro":
                    insere = con.prepareStatement("insert into "
                            + "Passageiro(cpf,nome,passaporte) " + "values (?,?,?)");
                    insere.setString(1, args[1]);
                    insere.setString(2, args[2]);
                    insere.setString(3, args[3]);
                    break;
                case "VooInfos":
                    insere = con.prepareStatement("insert into "
                            + "VooInfos(codigoVoo,dDcolagem,dAterissagem,qtdPass) " + "values (?,?,?,?)");
                    insere.setInt(1, Integer.parseInt(args[1]));
//                    insere.setDate(2, );
                    break;
                case "Trabalha":
                    insere = con.prepareStatement("insert into "
                            + "Trabalha(cpf,codigoVoo) " + "values (?,?)");
                    insere.setString(1, args[1]);
                    insere.setInt(2, Integer.parseInt(args[2]));
                    break;
                case "Viaja":
                    insere = con.prepareStatement("insert into "
                            + "Viaja(cpf,codigoVoo,assento,IDbagagem) " + "values (?,?,?,?)");
                    insere.setString(1, args[1]);
                    insere.setInt(2, Integer.parseInt(args[2]));
                    insere.setString(3, args[3]);
                    insere.setString(4, args[4]);
                    break;

            }

            int qtdeLinhasAfetadas = insere.executeUpdate();
            System.out.println("Linhas Afetadas: " + qtdeLinhasAfetadas);

            insere.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Insere.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
