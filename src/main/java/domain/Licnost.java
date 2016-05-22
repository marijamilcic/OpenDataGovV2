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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marij
 */
@Entity
@Table(name = "licnost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licnost.findAll", query = "SELECT l FROM Licnost l"),
    @NamedQuery(name = "Licnost.findByIdlicnosti", query = "SELECT l FROM Licnost l WHERE l.idlicnosti = :idlicnosti"),
    @NamedQuery(name = "Licnost.findBySnalazenjeRecima", query = "SELECT l FROM Licnost l WHERE l.snalazenjeRecima = :snalazenjeRecima"),
    @NamedQuery(name = "Licnost.findBySnalazenjeBrojevima", query = "SELECT l FROM Licnost l WHERE l.snalazenjeBrojevima = :snalazenjeBrojevima"),
    @NamedQuery(name = "Licnost.findByShvatanjeMasina", query = "SELECT l FROM Licnost l WHERE l.shvatanjeMasina = :shvatanjeMasina"),
    @NamedQuery(name = "Licnost.findBySnalazenjeSaLjudima", query = "SELECT l FROM Licnost l WHERE l.snalazenjeSaLjudima = :snalazenjeSaLjudima"),
    @NamedQuery(name = "Licnost.findByShvatanjeOdnosaUProstoru", query = "SELECT l FROM Licnost l WHERE l.shvatanjeOdnosaUProstoru = :shvatanjeOdnosaUProstoru"),
    @NamedQuery(name = "Licnost.findBySpretnostRukuPrstiju", query = "SELECT l FROM Licnost l WHERE l.spretnostRukuPrstiju = :spretnostRukuPrstiju")})
public class Licnost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlicnosti")
    private Integer idlicnosti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "snalazenjeRecima")
    private long snalazenjeRecima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "snalazenjeBrojevima")
    private long snalazenjeBrojevima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shvatanjeMasina")
    private long shvatanjeMasina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "snalazenjeSaLjudima")
    private long snalazenjeSaLjudima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShvatanjeOdnosaUProstoru")
    private long shvatanjeOdnosaUProstoru;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SpretnostRukuPrstiju")
    private long spretnostRukuPrstiju;

    public Licnost() {
    }

    public Licnost(Integer idlicnosti) {
        this.idlicnosti = idlicnosti;
    }

    public Licnost(Integer idlicnosti, long snalazenjeRecima, long snalazenjeBrojevima, long shvatanjeMasina, long snalazenjeSaLjudima, long shvatanjeOdnosaUProstoru, long spretnostRukuPrstiju) {
        this.idlicnosti = idlicnosti;
        this.snalazenjeRecima = snalazenjeRecima;
        this.snalazenjeBrojevima = snalazenjeBrojevima;
        this.shvatanjeMasina = shvatanjeMasina;
        this.snalazenjeSaLjudima = snalazenjeSaLjudima;
        this.shvatanjeOdnosaUProstoru = shvatanjeOdnosaUProstoru;
        this.spretnostRukuPrstiju = spretnostRukuPrstiju;
    }

    public Integer getIdlicnosti() {
        return idlicnosti;
    }

    public void setIdlicnosti(Integer idlicnosti) {
        this.idlicnosti = idlicnosti;
    }

    public long getSnalazenjeRecima() {
        return snalazenjeRecima;
    }

    public void setSnalazenjeRecima(long snalazenjeRecima) {
        this.snalazenjeRecima = snalazenjeRecima;
    }

    public long getSnalazenjeBrojevima() {
        return snalazenjeBrojevima;
    }

    public void setSnalazenjeBrojevima(long snalazenjeBrojevima) {
        this.snalazenjeBrojevima = snalazenjeBrojevima;
    }

    public long getShvatanjeMasina() {
        return shvatanjeMasina;
    }

    public void setShvatanjeMasina(long shvatanjeMasina) {
        this.shvatanjeMasina = shvatanjeMasina;
    }

    public long getSnalazenjeSaLjudima() {
        return snalazenjeSaLjudima;
    }

    public void setSnalazenjeSaLjudima(long snalazenjeSaLjudima) {
        this.snalazenjeSaLjudima = snalazenjeSaLjudima;
    }

    public long getShvatanjeOdnosaUProstoru() {
        return shvatanjeOdnosaUProstoru;
    }

    public void setShvatanjeOdnosaUProstoru(long shvatanjeOdnosaUProstoru) {
        this.shvatanjeOdnosaUProstoru = shvatanjeOdnosaUProstoru;
    }

    public long getSpretnostRukuPrstiju() {
        return spretnostRukuPrstiju;
    }

    public void setSpretnostRukuPrstiju(long spretnostRukuPrstiju) {
        this.spretnostRukuPrstiju = spretnostRukuPrstiju;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlicnosti != null ? idlicnosti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licnost)) {
            return false;
        }
        Licnost other = (Licnost) object;
        if ((this.idlicnosti == null && other.idlicnosti != null) || (this.idlicnosti != null && !this.idlicnosti.equals(other.idlicnosti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Licnost[ idlicnosti=" + idlicnosti + " ]";
    }
    
}
