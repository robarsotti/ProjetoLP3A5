/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financas.dao;

import br.com.financas.jdbc.Conecta;
import br.com.financas.model.Movimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class MovimentacaoDAO {
    
    private Connection con;

    public MovimentacaoDAO() {
        this.con = new Conecta().getConnection();
    }
    //Metodo cadastrarMovimentacao
    public void cadastrarMovimentacao(Movimentacao obj) {
        try {

            //criar comando sql
            String sql = "insert into movimentacao (vlr_movimentacao, dt_movimentacao, id_tipo_movimentacao, id_categoria)\n" +
"values (?, ?, ?, ?)";

            // conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, obj.getValor());
            stmt.setString(2, obj.getDtMov());
            stmt.setInt(3, obj.getIdTipo());
            stmt.setInt(4, obj.getIdCat());
            

            //executa o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }
    
    //Metodo alterar movimentacao
    public void alterarMovimentacao(Movimentacao obj) {
        try {

            //criar comando sql
            String sql = "update movimentacao set vlr_movimentacao=? where id_movimentacao=?";

            // conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, obj.getValor());
            stmt.setInt(2, obj.getId());

            //executa o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
            
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
        
    }
    
    //Metodo excluir movimentacao
    public void excluirMovimentacao(Movimentacao obj) {
        try {

            //criar comando sql
            String sql = "delete from movimentacao where id_movimentacao =?";

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
    
    public List<Movimentacao> listarMovimentacao() {

        try {
            //criar a lista
            List<Movimentacao> lista = new ArrayList<>();

            //criar comando sql e executar
            String sql = "select * from movimentacao";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimentacao obj = new Movimentacao();
                obj.setId(rs.getInt("id_movimentacao"));
                obj.setValor(rs.getDouble("vlr_movimentacao"));
                obj.setDtMov(rs.getString("dt_movimentacao"));
                obj.setDtCadastro(rs.getString("dt_cadastro_mov"));
                obj.setIdTipo(rs.getInt("id_tipo_movimentacao"));
                obj.setIdCat(rs.getInt("id_categoria"));
                

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return null;
        }

    }
}
