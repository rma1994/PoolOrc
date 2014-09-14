/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import nwk.com.br.enums.StatusRepository;

/**
 *
 * @author Richard Matheus
 */
public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
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
    private StatusRepository status;
    
    private String mensagemerroFuncionario = new String("Campos em branco: \n");
    private boolean valida = true;
    
    SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
    
    
    public StatusRepository getStatus() {
        return status;
    }

    public void setStatus(StatusRepository status) {
        this.status = status;
    }
    
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
        if(nome.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"E-mail\n";
        } else {
            this.nome = nome;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        if(cpf.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"CPF\n";
        } else {
            this.cpf = cpf;
        }
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if(rua.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"Rua\n";
        } else {
            this.rua = rua;
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if(numero.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"Numero\n";
        } else {
            this.numero = numero;
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if(bairro.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"Bairro\n";
        } else {
            this.bairro = bairro;
        }
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if(complemento.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"Complemento\n";
        } else {
            this.complemento = complemento;
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep){
        cep = cep.replace("-", "");
        if(cep.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"CEP\n";
        } else {
            this.cep = cep;
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if(cidade.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"Cidade\n";
        } else {
            this.cidade = cidade;
        }
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
        if(telefone.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"Telefone\n";
        } else {
            this.telefone = telefone;
        }
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
        if(email.equals("")){
            this.valida = false;
            this.mensagemerroFuncionario = mensagemerroFuncionario+"E-mail\n";
        } else {
            this.email = email;
        }
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

    public void setDhNascimento(String dhNascimento) {
        try{
            this.dhNascimento = sdf1.parse(dhNascimento);
        }catch(Exception e){
            System.out.println("Erro DH Nascimento Funcionario" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
    }

    public Date getDhContrato() {
        return dhContrato;
    }

    public void setDhContrato(String dhContrato) {
        try{
            this.dhContrato = sdf1.parse(dhContrato);
        }catch(Exception e){
            System.out.println("Erro DH Nascimento Funcionario" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
    }

    public Date getDhDemissao() {
        return dhDemissao;
    }

    public void setDhDemissao(String dhDemissao) {
        try{
            this.dhDemissao = sdf1.parse(dhDemissao);
        }catch(Exception e){
            System.out.println("Erro DH Nascimento Funcionario" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
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
