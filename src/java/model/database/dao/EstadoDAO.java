/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import model.util.Conexao;
import model.database.entities.Estado;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lieds
 */
public class EstadoDAO {    
   /* private String sql = "";
    private ArrayList<Estado> estadoList = new ArrayList<>();

    public List<Estado> select() {                                 
        try {
            this.sql = "SELECT * FROM estado";
                        
            ResultSet data = new Conexao().executeQuery(sql);
            
            while(data.next()) {
                Estado estado = new Estado();
                estado.setId_estado(data.getInt("id_estado"));
                estado.setNome_uf(data.getString("nome_estado"));
                estado.setSigla_uf(data.getString("sigla_uf"));                
                estadoList.add(estado);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CHAMAR A BASE DE DADOS DE ESTADO!");
        }
        
        return estadoList;
    }*/
        
}
