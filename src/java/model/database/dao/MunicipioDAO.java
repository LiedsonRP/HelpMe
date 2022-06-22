/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import model.util.Conexao;
import model.database.entities.Municipio;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lieds
 */
public class MunicipioDAO {
    private String sql = "";
    private ArrayList<Municipio> municipioList = new ArrayList<>();
    
    public List<Municipio> select() {        
        try {
            sql = "SELECT * FROM municipio";
            ResultSet data = new Conexao().executeQuery(sql);
            
            while (data.next()) {
                Municipio municipio = new Municipio();
                municipio.setId_cidade(data.getInt("id_cidade"));
                municipio.setNome_cidade(data.getString("nome_cidade"));
                municipio.setFk_id_estado(data.getInt("fk_id_estado"));
                municipioList.add(municipio);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CHAMAR A BASE DE DADOS DE MUNICIPIO!");
        }
        
        return municipioList;
    }
}
