/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rodrigo
 */
public class Conecta {
    
    public Connection getConnection(){
    
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdcontrolefinancas", "root","k2s8c9j4");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }
}
