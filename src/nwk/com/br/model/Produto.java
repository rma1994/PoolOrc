/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.model;

import java.util.Date;

/**
 *
 * @author Richard Matheus
 */
public class Produto {
    private int id;
    private String idFabricante;
    private String descricao;
    private String marca;
    private String familia;
    private String similar;
    private String valorCompra;
    private String valorVenda;
    private String porcentagem;
    private String observacoes;
    private Date dhCadastro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(String idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getSimilar() {
        return similar;
    }

    public void setSimilar(String similar) {
        this.similar = similar;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDhCadastro() {
        return dhCadastro;
    }

    public void setDhCadastro(Date dhCadastro) {
        this.dhCadastro = dhCadastro;
    }
    
}
