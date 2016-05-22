/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author marij
 */
public class Config {
    private String skola_id;
    private String naziv_skole;
    private String podrucje_rada;
    private String smer;
    private String opis;

    public String getSkola_id() {
        return skola_id;
    }

    public void setSkola_id(String skola_id) {
        this.skola_id = skola_id;
    }

    public String getNaziv_skole() {
        return naziv_skole;
    }

    public void setNaziv_skole(String naziv_skole) {
        this.naziv_skole = naziv_skole;
    }

    public String getPodrucje_rada() {
        return podrucje_rada;
    }

    public void setPodrucje_rada(String podrucje_rada) {
        this.podrucje_rada = podrucje_rada;
    }

    public String getSmer() {
        return smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Config(String skola_id, String naziv_skole, String podrucje_rada, String smer, String opis) {
        this.skola_id = skola_id;
        this.naziv_skole = naziv_skole;
        this.podrucje_rada = podrucje_rada;
        this.smer = smer;
        this.opis = opis;
    }
    
}
