/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.model;

import java.util.Date;
import nwk.com.br.enums.StatusRepository;

/**
 *
 * @author Richard Matheus
 */
public class Funcionario {
    private int id;
    private String nome;
    private String cpf_cnpj;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String telefone;
    private String celular;
    private String email;
    private String observacoes;
    private Date dhNascimento;
    private Date dhContrato;
    private Date dhDemissao;
    private String numcarteiratrab;
    private String seriecarteiratrab;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDhNascimento() {
        return dhNascimento;
    }

    public void setDhNascimento(Date dhNascimento) {
        this.dhNascimento = dhNascimento;
    }

    public Date getDhContrato() {
        return dhContrato;
    }

    public void setDhContrato(Date dhContrato) {
        this.dhContrato = dhContrato;
    }

    public Date getDhDemissao() {
        return dhDemissao;
    }

    public void setDhDemissao(Date dhDemissao) {
        this.dhDemissao = dhDemissao;
    }

    public String getNumcarteiratrab() {
        return numcarteiratrab;
    }

    public void setNumcarteiratrab(String numcarteiratrab) {
        this.numcarteiratrab = numcarteiratrab;
    }

    public String getSeriecarteiratrab() {
        return seriecarteiratrab;
    }

    public void setSeriecarteiratrab(String seriecarteiratrab) {
        this.seriecarteiratrab = seriecarteiratrab;
    }
    
}
