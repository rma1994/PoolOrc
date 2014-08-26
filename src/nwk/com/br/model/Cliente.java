/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.model;

import nwk.com.br.enums.StatusRepository;

/**
 *
 * @author Richard Matheus
 */
public class Cliente {
    private int id;
    private String tipoCliente;
    private StatusRepository status;
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
    
    private String mensagemerroCliente = new String("Campos em branco: \n");
    private boolean valida = true;

    public void setMensagemerroCliente(String mensagemerroCliente) {
        this.mensagemerroCliente = mensagemerroCliente;
    }

    public String getMensagemerroCliente() {
        return mensagemerroCliente;
    }
    
    public void setIsValida(boolean valida){
        this.valida = valida;
    }

    public boolean isValida() {
        return valida;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        if(tipoCliente.equals("") || tipoCliente.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"Tipo Cliente\n";
        } else {
        this.tipoCliente = tipoCliente;
        }
    }

    public StatusRepository getStatus() {
        return status;
    }

    public void setStatus(StatusRepository status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.equals("") || nome.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"Nome\n";
        } else {
        this.nome = nome;
        }
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        if(cpf_cnpj.equals("") || cpf_cnpj.equals(null) || cpf_cnpj.equals("   .   .   -  ") || cpf_cnpj.equals("  .   .   /    -  ")){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"CPF/CNPJ\n";
        } else {
            cpf_cnpj = cpf_cnpj.replace(".", "");
            cpf_cnpj = cpf_cnpj.replace("-", "");
            cpf_cnpj = cpf_cnpj.replace("/", "");
            this.cpf_cnpj = cpf_cnpj;
        }
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if(rua.equals("") || rua.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"Rua\n";
        } else {
        this.rua = rua;
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if(numero.equals("") || numero.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"Numero\n";
        } else {
        this.numero = numero;
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if(bairro.equals("") || bairro.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"Bairro\n";
        } else {
        this.bairro = bairro;
        }
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
        if(cep.equals("") || cep.equals(null) || cep.equals("     -   ")){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"CEP\n";
        } else {
            cep = cep.replace("-", "");
            this.cep = cep;
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if(cidade.equals("") || cidade.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"Cidade\n";
        } else {
        this.cidade = cidade;
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if(estado.equals("") || estado.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"Estado\n";
        } else {
        this.estado = estado;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone.equals("") || telefone.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"Telefone\n";
        } else {
            telefone = telefone.replace("(","");
            telefone = telefone.replace(")","");
            telefone = telefone.replace("-","");
            this.telefone = telefone;
        }
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        celular = celular.replace("(","");
        celular = celular.replace(")","");
        celular = celular.replace(" ","");
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.equals("") || email.equals(null)){
            this.valida = false;
            this.mensagemerroCliente = mensagemerroCliente+"E-mail\n";
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
    
}
