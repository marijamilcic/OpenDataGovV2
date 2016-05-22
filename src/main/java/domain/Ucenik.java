/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marij
 */
@Entity
@Table(name = "ucenik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ucenik.findAll", query = "SELECT u FROM Ucenik u"),
    @NamedQuery(name = "Ucenik.findById", query = "SELECT u FROM Ucenik u WHERE u.id = :id"),
    @NamedQuery(name = "Ucenik.findByIme", query = "SELECT u FROM Ucenik u WHERE u.ime = :ime"),
    @NamedQuery(name = "Ucenik.findByPrezime", query = "SELECT u FROM Ucenik u WHERE u.prezime = :prezime"),
    @NamedQuery(name = "Ucenik.findByJmbg", query = "SELECT u FROM Ucenik u WHERE u.jmbg = :jmbg"),
    @NamedQuery(name = "Ucenik.findByKorisnickoIme", query = "SELECT u FROM Ucenik u WHERE u.korisnickoIme = :korisnickoIme"),
    @NamedQuery(name = "Ucenik.findByLozinka", query = "SELECT u FROM Ucenik u WHERE u.lozinka = :lozinka"),
    @NamedQuery(name = "Ucenik.findByToken", query = "SELECT u FROM Ucenik u WHERE u.token = :token")})
public class Ucenik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "jmbg")
    private String jmbg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "korisnicko_ime")
    private String korisnickoIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lozinka")
    private String lozinka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "token")
    private String token;

    public Ucenik() {
    }

    public Ucenik(Long id) {
        this.id = id;
    }

    public Ucenik(Long id, String ime, String prezime, String jmbg, String korisnickoIme, String lozinka, String token) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @JsonIgnore
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ucenik)) {
            return false;
        }
        Ucenik other = (Ucenik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Ucenik[ id=" + id + " ]";
    }
    
}
