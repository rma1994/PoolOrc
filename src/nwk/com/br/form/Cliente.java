/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.form;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Richard Matheus
 */
@Entity
@Table(name = "CLIENTE", catalog = "", schema = "POOLORC")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    //@NamedQuery(name = "Cliente.findByTipoCliente", query = "SELECT c FROM Cliente c WHERE c.tipoCliente = :tipoCliente"),
    @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM Cliente c WHERE c.nomeCliente = :nomeCliente"),
    @NamedQuery(name = "Cliente.findByCpfCnpjCliente", query = "SELECT c FROM Cliente c WHERE c.cpfCnpjCliente = :cpfCnpjCliente"),
    //@NamedQuery(name = "Cliente.findByRuaCliente", query = "SELECT c FROM Cliente c WHERE c.ruaCliente = :ruaCliente"),
    //@NamedQuery(name = "Cliente.findByBairroCliente", query = "SELECT c FROM Cliente c WHERE c.bairroCliente = :bairroCliente"),
    //@NamedQuery(name = "Cliente.findByNumeroEndCliente", query = "SELECT c FROM Cliente c WHERE c.numeroEndCliente = :numeroEndCliente"),
    //@NamedQuery(name = "Cliente.findByComplementoCliente", query = "SELECT c FROM Cliente c WHERE c.complementoCliente = :complementoCliente"),
    //@NamedQuery(name = "Cliente.findByCepCliente", query = "SELECT c FROM Cliente c WHERE c.cepCliente = :cepCliente"),
    //@NamedQuery(name = "Cliente.findByCidadeCliente", query = "SELECT c FROM Cliente c WHERE c.cidadeCliente = :cidadeCliente"),
    //@NamedQuery(name = "Cliente.findByEstadoCliente", query = "SELECT c FROM Cliente c WHERE c.estadoCliente = :estadoCliente"),
    @NamedQuery(name = "Cliente.findByTelefoneCliente", query = "SELECT c FROM Cliente c WHERE c.telefoneCliente = :telefoneCliente"),
    //@NamedQuery(name = "Cliente.findByCelularCliente", query = "SELECT c FROM Cliente c WHERE c.celularCliente = :celularCliente"),
    @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente"),
    //@NamedQuery(name = "Cliente.findByAtivoCliente", query = "SELECT c FROM Cliente c WHERE c.ativoCliente = :ativoCliente"),
    /*@NamedQuery(name = "Cliente.findByObservacoesCliente", query = "SELECT c FROM Cliente c WHERE c.observacoesCliente = :observacoesCliente")*/})
public class Cliente implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private BigDecimal idCliente;
    //@Column(name = "TIPO_CLIENTE")
    //private String tipoCliente;
    @Column(name = "NOME_CLIENTE")
    private String nomeCliente;
    @Column(name = "CPF_CNPJ_CLIENTE")
    private String cpfCnpjCliente;
    //@Column(name = "RUA_CLIENTE")
    //private String ruaCliente;
    //@Column(name = "BAIRRO_CLIENTE")
    //private String bairroCliente;
    //@Column(name = "NUMERO_END_CLIENTE")
    //private String numeroEndCliente;
    //@Column(name = "COMPLEMENTO_CLIENTE")
    //private String complementoCliente;
    //@Column(name = "CEP_CLIENTE")
    //private String cepCliente;
    //@Column(name = "CIDADE_CLIENTE")
    //private String cidadeCliente;
    //@Column(name = "ESTADO_CLIENTE")
    //private String estadoCliente;
    @Column(name = "TELEFONE_CLIENTE")
    private String telefoneCliente;
    //@Column(name = "CELULAR_CLIENTE")
    //private String celularCliente;
    @Column(name = "EMAIL_CLIENTE")
    private String emailCliente;
    //@Basic(optional = false)
    //@Column(name = "ATIVO_CLIENTE")
    //private Character ativoCliente;
    //@Column(name = "OBSERVACOES_CLIENTE")
    //private String observacoesCliente;

    public Cliente() {
    }

    public Cliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    /*public Cliente(BigDecimal idCliente, Character ativoCliente) {
        this.idCliente = idCliente;
        this.ativoCliente = ativoCliente;
    }*/

    public BigDecimal getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigDecimal idCliente) {
        BigDecimal oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    /*public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        String oldTipoCliente = this.tipoCliente;
        this.tipoCliente = tipoCliente;
        changeSupport.firePropertyChange("tipoCliente", oldTipoCliente, tipoCliente);
    }*/

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        String oldNomeCliente = this.nomeCliente;
        this.nomeCliente = nomeCliente;
        changeSupport.firePropertyChange("nomeCliente", oldNomeCliente, nomeCliente);
    }

    public String getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(String cpfCnpjCliente) {
        String oldCpfCnpjCliente = this.cpfCnpjCliente;
        this.cpfCnpjCliente = cpfCnpjCliente;
        changeSupport.firePropertyChange("cpfCnpjCliente", oldCpfCnpjCliente, cpfCnpjCliente);
    }

    /*public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        String oldRuaCliente = this.ruaCliente;
        this.ruaCliente = ruaCliente;
        changeSupport.firePropertyChange("ruaCliente", oldRuaCliente, ruaCliente);
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        String oldBairroCliente = this.bairroCliente;
        this.bairroCliente = bairroCliente;
        changeSupport.firePropertyChange("bairroCliente", oldBairroCliente, bairroCliente);
    }

    public String getNumeroEndCliente() {
        return numeroEndCliente;
    }

    public void setNumeroEndCliente(String numeroEndCliente) {
        String oldNumeroEndCliente = this.numeroEndCliente;
        this.numeroEndCliente = numeroEndCliente;
        changeSupport.firePropertyChange("numeroEndCliente", oldNumeroEndCliente, numeroEndCliente);
    }

    public String getComplementoCliente() {
        return complementoCliente;
    }

    public void setComplementoCliente(String complementoCliente) {
        String oldComplementoCliente = this.complementoCliente;
        this.complementoCliente = complementoCliente;
        changeSupport.firePropertyChange("complementoCliente", oldComplementoCliente, complementoCliente);
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        String oldCepCliente = this.cepCliente;
        this.cepCliente = cepCliente;
        changeSupport.firePropertyChange("cepCliente", oldCepCliente, cepCliente);
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        String oldCidadeCliente = this.cidadeCliente;
        this.cidadeCliente = cidadeCliente;
        changeSupport.firePropertyChange("cidadeCliente", oldCidadeCliente, cidadeCliente);
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        String oldEstadoCliente = this.estadoCliente;
        this.estadoCliente = estadoCliente;
        changeSupport.firePropertyChange("estadoCliente", oldEstadoCliente, estadoCliente);
    }*/

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        String oldTelefoneCliente = this.telefoneCliente;
        this.telefoneCliente = telefoneCliente;
        changeSupport.firePropertyChange("telefoneCliente", oldTelefoneCliente, telefoneCliente);
    }

    /*public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        String oldCelularCliente = this.celularCliente;
        this.celularCliente = celularCliente;
        changeSupport.firePropertyChange("celularCliente", oldCelularCliente, celularCliente);
    }*/

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        String oldEmailCliente = this.emailCliente;
        this.emailCliente = emailCliente;
        changeSupport.firePropertyChange("emailCliente", oldEmailCliente, emailCliente);
    }

    /*public Character getAtivoCliente() {
        return ativoCliente;
    }

    public void setAtivoCliente(Character ativoCliente) {
        Character oldAtivoCliente = this.ativoCliente;
        this.ativoCliente = ativoCliente;
        changeSupport.firePropertyChange("ativoCliente", oldAtivoCliente, ativoCliente);
    }

    public String getObservacoesCliente() {
        return observacoesCliente;
    }

    public void setObservacoesCliente(String observacoesCliente) {
        String oldObservacoesCliente = this.observacoesCliente;
        this.observacoesCliente = observacoesCliente;
        changeSupport.firePropertyChange("observacoesCliente", oldObservacoesCliente, observacoesCliente);
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nwk.com.br.form.Cliente[ idCliente=" + idCliente + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
