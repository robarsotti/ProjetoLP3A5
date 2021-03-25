/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financas.dao;


import br.com.financas.jdbc.Conecta;
import br.com.financas.model.TipoMovimentacao;
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
public class TipoMovimentacaoDAO {

    private Connection con;

    public TipoMovimentacaoDAO() {
        this.con = new Conecta().getConnection();
    }

//Metodo cadastrarCategoria
    public void cadastrarTipoMov(TipoMovimentacao obj) {
        try {

            //criar comando sql
            String sql = "insert into tipoMovimentacao (ds_tipo_mov) values (?)";

            // conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getTipo());

            //executa o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }

//Metodo alterarCategoria
    public void alterarTipoMov(TipoMovimentacao obj) {
        try {

            //criar comando sql
            String sql = "update tipoMovimentacao set ds_tipo_mov=? where id_tipo_movimentacao=?";

            // conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getTipo());
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
    public void excluirTipoMov(TipoMovimentacao obj) {
        try {

            //criar comando sql
            String sql = "delete from tipoMovimentacao where id_tipo_movimentacao =?";

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

    public List<TipoMovimentacao> listarTipoMov() {

        try {
            //criar a lista
            List<TipoMovimentacao> lista = new ArrayList<>();

            //criar comando sql e executar
            String sql = "select * from tipoMovimentacao";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TipoMovimentacao obj = new TipoMovimentacao();
                obj.setId(rs.getInt("id_tipo_movimentacao"));
                obj.setTipo(rs.getString("ds_tipo_mov"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return null;
        }

    }
}
