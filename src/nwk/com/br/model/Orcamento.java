/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Richard Matheus
 */
public class Orcamento {
    private int id;
    private int idFuncionario;
    private int idCliente;
    private Date dhOrcamento;
    private String nomeCliente;
    private String formaPagamento;
    private String subTotal;
    private String desconto;
    private String total;
    private String observacoes;
    
    private List<Produto> result = new ArrayList<Produto>();
    
    private String mensagemerroOrcamento = new String("Campos em branco: \n");
    private boolean valida = true;
    SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");

    
    public String getMensagemerroOrcamento() {
        return mensagemerroOrcamento;
    }

    public void setMensagemerroOrcamento(String mensagemerroProduto) {
        this.mensagemerroOrcamento = mensagemerroProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        //Armazerno somente o codigo de familia.
        int index;
        index = idFuncionario.indexOf("-"); //Pego a posição do -, que indica até vai o cod
        idFuncionario = idFuncionario.substring(0, index).trim(); // armazeno o codigo até o -
        this.idFuncionario = Integer.parseInt(idFuncionario);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDhOrcamento() {
        return dhOrcamento;
    }

    public void setDhOrcamento(String dhOrcamento) {
        try{
            this.dhOrcamento = sdf1.parse(dhOrcamento);
        }catch(Exception e){
            System.out.println("Erro DH cadastro orcamento " + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal.replace(",", ".");
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto.replace(",", ".");
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total.replace(",", ".");
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    public List<Produto> getResult() {
        return result;
    }

    public void setResult(List<Produto> result) {
        this.result = result;
    }
    
    
}
