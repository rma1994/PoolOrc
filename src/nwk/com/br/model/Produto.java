/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Richard Matheus
 */
public class Produto {
    private String id;
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
    private String total;
    private String quantidade;
    private String desconto;
    private int linha;
    
    private String mensagemerroProduto = new String("Campos em branco: \n");
    private boolean valida = true;
    SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");

    public String getMensagemerroProduto() {
        return mensagemerroProduto;
    }

    public void setMensagemerroProduto(String mensagemerroProduto) {
        this.mensagemerroProduto = mensagemerroProduto;
    }

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.equals("")){
            this.valida = false;
            this.mensagemerroProduto = mensagemerroProduto + "ID\n";
        } else {
            this.id = id;
        }
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
        if(descricao.equals("")){
            this.valida = false;
            this.mensagemerroProduto = mensagemerroProduto + "Descrição\n";
        } else {
            this.descricao = descricao;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if(marca.equals("")){
            this.valida = false;
            this.mensagemerroProduto = mensagemerroProduto + "Marca\n";
        } else {
            this.marca = marca;
        }
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        //Armazerno somente o codigo de familia.
        int index;
        index = familia.indexOf("-"); //Pego a posição do -, que indica até vai o cod
        familia = familia.substring(0, index); // armazeno o codigo até o -
        
        this.familia = familia;
    }

    public String getSimilar() {
        return similar;
    }

    public void setSimilar(String similar) {
        //Armazerno somente o codigo de familia.
        int index;
        index = similar.indexOf("-"); //Pego a posição do -, que indica até vai o cod
        similar = similar.substring(0, index);// armazeno o codigo até o -
        
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
        if(valorVenda.equals("")){
            this.valida = false;
            this.mensagemerroProduto = mensagemerroProduto + "Valor de Venda\n";
        } else {
            this.valorVenda = valorVenda;
        }
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

    public void setDhCadastro(String dhCadastro) {
        try{
            this.dhCadastro = sdf1.parse(dhCadastro);
        }catch(Exception e){
            System.out.println("Erro DH Nascimento Funcionario" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
}
