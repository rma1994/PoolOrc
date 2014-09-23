/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.calculos;

import java.math.BigDecimal;
import java.util.List;
import nwk.com.br.model.Produto;

/**
 *
 * @author Richard Matheus
 */
public class OrcamentoCalc {
    
    public BigDecimal somarProdutos(List<Produto> produtolist){
        BigDecimal result = new BigDecimal("0");
        
        for(Produto produto : produtolist){
            BigDecimal valor = new BigDecimal(produto.getTotal());
            result = result.add(valor);
        }
        
        return result;
    }
    
    public BigDecimal valorTotal(String subtotal, String desc){
        BigDecimal result = new BigDecimal("0");
        
        BigDecimal desconto = new BigDecimal(desc);
        BigDecimal sub = new BigDecimal(subtotal);
        
        //Subtrai de subtotal o valor de desconto
        result = sub.subtract(desconto);
        return result;
    }
}
