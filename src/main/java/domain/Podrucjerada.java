/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marij
 */
@Entity
@Table(name = "podrucjerada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Podrucjerada.findAll", query = "SELECT p FROM Podrucjerada p"),
    @NamedQuery(name = "Podrucjerada.findByPodrucjeRada", query = "SELECT p FROM Podrucjerada p WHERE p.podrucjeRada = :podrucjeRada"),
    @NamedQuery(name = "Podrucjerada.findByNazivPodrucjeRada", query = "SELECT p FROM Podrucjerada p WHERE p.nazivPodrucjeRada = :nazivPodrucjeRada")})
public class Podrucjerada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "podrucje_rada")
    private Integer podrucjeRada;
    @Size(max = 40)
    @Column(name = "naziv_podrucje_rada")
    private String nazivPodrucjeRada;

    public Podrucjerada() {
    }

    public Podrucjerada(Integer podrucjeRada) {
        this.podrucjeRada = podrucjeRada;
    }

    public Integer getPodrucjeRada() {
        return podrucjeRada;
    }

    public void setPodrucjeRada(Integer podrucjeRada) {
        this.podrucjeRada = podrucjeRada;
    }

    public String getNazivPodrucjeRada() {
        return nazivPodrucjeRada;
    }

    public void setNazivPodrucjeRada(String nazivPodrucjeRada) {
        this.nazivPodrucjeRada = nazivPodrucjeRada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (podrucjeRada != null ? podrucjeRada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Podrucjerada)) {
            return false;
        }
        Podrucjerada other = (Podrucjerada) object;
        if ((this.podrucjeRada == null && other.podrucjeRada != null) || (this.podrucjeRada != null && !this.podrucjeRada.equals(other.podrucjeRada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Podrucjerada[ podrucjeRada=" + podrucjeRada + " ]";
    }
    public static Podrucjerada podrucje(int id){
        return null;
    }
    
}
