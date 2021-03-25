/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financas.model;

/**
 *
 * @author Rodrigo
 */
public class Movimentacao {
    
    private int id;
    private double valor;
    private String dtMov;
    private String dtCadastro;
    private int idTipo;
    private int idCat;
    
    
//id_movimentacao int primary key auto_increment,
//vlr_movimentacao double not null,
//dt_movimentacao date,
//dt_cadastro_mov datetime,
//id_tipo_movimentacao int,
//id_categoria int,

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDtMov() {
        return dtMov;
    }

    public void setDtMov(String dtMov) {
        this.dtMov = dtMov;
    }

    public String getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }
}
