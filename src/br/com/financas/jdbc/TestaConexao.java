/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financas.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class TestaConexao {
    public static void main(String[] args) {
        
        try {
            new Conecta().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não conectado"+e);
        }
    }
}
