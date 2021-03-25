/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financas.dao;

import br.com.financas.jdbc.Conecta;
import br.com.financas.model.Categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;


/**
 *
 * @author Rodrigo
 */
public class CategoriasDAO {

    private Connection con;

    public CategoriasDAO() {
        this.con = new Conecta().getConnection();
    }

//Metodo cadastrarCategoria
    public void cadastrarCategoria(Categorias obj) {
        try {

            //criar comando sql
            String sql = "insert into categoria (ds_categoria) values (?)";

            // conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());

            //executa o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }

//Metodo alterarCategoria
    public void alterarCategoria(Categorias obj) {
        try {

            //criar comando sql
            String sql = "update categoria set ds_categoria=? where id_categoria=?";

            // conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setInt(2, obj.getId());

            //executa o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
            
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
        
    }

//Metodo excluirCategoria
    public void excluirCategoria(Categorias obj) {
        try {

            //criar comando sql
            String sql = "delete from categoria where id_categoria =?";

            // conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //executa o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
        
    }

    public List<Categorias> listarCategorias() {

        try {
            //criar a lista
            List<Categorias> lista = new ArrayList<>();

            //criar comando sql e executar
            String sql = "select * from categoria";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categorias obj = new Categorias();
                obj.setId(rs.getInt("id_categoria"));
                obj.setDescricao(rs.getString("ds_categoria"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return null;
        }

    }
}

//Metodo listarClientes

