/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class Seleciona {

    static final String DATABASE_URL = "jdbc:postgresq://localhost/Aeroporto";
    static Connection con = null;
    static Statement stm = null;
    static ResultSet rs = null;
    static ResultSetMetaData md = null;

    public static void main(String[] args) {

        try {
            con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
            int nroColunas = 0;

            switch (args[0]) {
                case "Piloto":
                    con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
                    stm = con.createStatement();
                    rs = stm.executeQuery("select * from Piloto");
                    md = rs.getMetaData();
                    nroColunas = md.getColumnCount();
                    ArrayList<Piloto> listaPiloto = new ArrayList<Piloto>();

                    while (rs.next()) {
                        Piloto piloto = new Piloto(rs.getString("cpf"), rs.getString("cht"),
                                rs.getString("func"), rs.getString("nome"));
                        listaPiloto.add(piloto);
                    }

                    break;
                case "Aeroporto":
                    con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
                    stm = con.createStatement();
                    rs = stm.executeQuery("select * from Aroporto");
                    md = rs.getMetaData();
                    nroColunas = md.getColumnCount();

                    ArrayList<Aeroporto> listaAeroporto = new ArrayList<Aeroporto>();

                    while (rs.next()) {
                        Aeroporto aeroporto = new Aeroporto(rs.getInt("codigoAero"), rs.getString("cidade"),
                                rs.getString("estado"), rs.getString("pais"), rs.getString("nomeAero"));
                        listaAeroporto.add(aeroporto);
                    }

                    break;
                case "Aeronave":
                    con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
                    stm = con.createStatement();
                    rs = stm.executeQuery("select * from Aeronave");
                    md = rs.getMetaData();
                    nroColunas = md.getColumnCount();

                    ArrayList<Aeronave> listaAeronave = new ArrayList<Aeronave>();

                    while (rs.next()) {
                        Aeronave aeronave = new Aeronave(rs.getInt("IDAero"), rs.getString("modelo"),
                                rs.getInt("capacidade"), rs.getString("tipo"));
                        listaAeronave.add(aeronave);
                    }
                    break;
                case "Voo":
                    con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
                    stm = con.createStatement();
                    rs = stm.executeQuery("select * from Voo");
                    md = rs.getMetaData();
                    nroColunas = md.getColumnCount();

                    ArrayList<Voo> listaVoo = new ArrayList<Voo>();

                    while (rs.next()) {
                        Voo voo = new Voo(rs.getInt("codigo"), rs.getInt("IDAero"), rs.getInt("codAeroOri"), rs.getInt("codAeroDst"));
                        listaVoo.add(voo);
                    }
                    break;
                case "Passageiro":
                    con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
                    stm = con.createStatement();
                    rs = stm.executeQuery("select * from Passageiro");
                    md = rs.getMetaData();
                    nroColunas = md.getColumnCount();

                    ArrayList<Passageiro> listaPassageiro = new ArrayList<Passageiro>();

                    while (rs.next()) {
                        Passageiro passageiro = new Passageiro(rs.getString("cpf"), rs.getString("nome"), rs.getString("passaporte"));
                        listaPassageiro.add(passageiro);
                    }
                    break;
                case "VooInfos":
                    con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
                    stm = con.createStatement();
                    rs = stm.executeQuery("select * from VooInfos");
                    md = rs.getMetaData();
                    nroColunas = md.getColumnCount();

                    ArrayList<VooInfos> listaVooInfos = new ArrayList<VooInfos>();

                    while (rs.next()) {
                        VooInfos vooInfos = new VooInfos(rs.getInt("codVoo"), rs.getDate("dDecolagem"), rs.getDate("dAterissagem"), rs.getInt("qtdPass"));
                        listaVooInfos.add(vooInfos);
                    }
                    break;
                case "Trabalha":
                    con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
                    stm = con.createStatement();
                    rs = stm.executeQuery("select * from Trabalha");
                    md = rs.getMetaData();
                    nroColunas = md.getColumnCount();
                    ArrayList<Trabalha> listaTrabalha = new ArrayList<Trabalha>();

                    while (rs.next()) {
                        Trabalha trabalha = new Trabalha(rs.getString("cpf"), rs.getInt("codigoVoo"));
                        listaTrabalha.add(trabalha);
                    }
                    break;
                case "Viaja":
                    con = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
                    stm = con.createStatement();
                    rs = stm.executeQuery("select * from Viaja");
                    md = rs.getMetaData();
                    nroColunas = md.getColumnCount();
                    ArrayList<Viaja> listaViaja = new ArrayList<Viaja>();

                    while (rs.next()) {
                        Viaja viaja = new Viaja(rs.getString("cpf"), rs.getInt("codigoVoo"), rs.getString("assento"), rs.getString("IDbagagem"));
                        listaViaja.add(viaja);
                    }
                    break;

            }

//            for (int i = 1; i <= nroColunas; i++) {
//                System.out.printf("%s\t\t", md.getColumnName(i));
//            }

//            for (DVD umdvd : listaDVD) {
//                System.out.printf("\n%d\t\t\t%s\t\t%s\t%.2f\n\n\n", umdvd.getSerial(), umdvd.getTitulo(),
//                        umdvd.getDescricao(), umdvd.getDuracao());
//            }
            rs.close();
            stm.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Seleciona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
