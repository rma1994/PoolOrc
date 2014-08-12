/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.enums;

/**
 *
 * @author Richard Matheus
 */
public enum StatusRepository {
    ATIVO ("A"),
    INATIVO("I");
    
    private String value;
    
    StatusRepository(String value){
        this.value = value;
    }
    
    public static StatusRepository getByValue(String value){
        StatusRepository result = null;
        for (StatusRepository statusRepository : StatusRepository.values()) {
            if (statusRepository.value.equals(value)){
               result = statusRepository;
               break;
            }
        }
        return result;
    }
    
    public String getValue(){
        return this.value;
    }
}
