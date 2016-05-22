/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import domain.Licnost;
import domain.Podrucjerada;
import domain.Skole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marij
 */
public class FilterByCoolStuff implements AlgorithmStep {

    Licnost licnost;
    Podrucjerada profil;

    public Licnost getLicnost() {
        return licnost;
    }

    public void setLicnost(Licnost licnost) {
        this.licnost = licnost;
    }

    public Podrucjerada getProfil() {
        return profil;
    }

    public void setProfil(Podrucjerada profil) {
        this.profil = profil;
    }

    public FilterByCoolStuff(Licnost licnost, Podrucjerada profil) {
        this.licnost = licnost;
        this.profil = profil;
    }

    @Override
    public List<Skole> filtrirajSkole(List<Skole> skole) {
        double snalazenjeRecima;
        double snalazenjeBrojevima;
        double shvatanjeMasina;
        double shvatanjeProstora;
        double pokretnostRukuPrstiju;
        double snalazenjeSljudima;

        double licnaIDrustvenabrigaOljudima;
        double radSaBiljkamaIZivotinjama;
        double tehnika;
        double odbranaBezbednostZastita;
        double BiznisPoslovneUsluge;
        double KulturaUmetnostMediji;
        double tehnologija;
        double zanati;

        snalazenjeRecima = licnost.getSnalazenjeRecima();
        snalazenjeBrojevima = licnost.getSnalazenjeBrojevima();
        shvatanjeMasina = licnost.getShvatanjeMasina();
        shvatanjeProstora = licnost.getShvatanjeOdnosaUProstoru();
        pokretnostRukuPrstiju = licnost.getSpretnostRukuPrstiju();
        snalazenjeSljudima = licnost.getSnalazenjeSaLjudima();

        Podrucjerada pr = null;
        
        if (snalazenjeRecima < 3 && shvatanjeProstora > 3 && shvatanjeMasina > 3 && pokretnostRukuPrstiju > 2 && snalazenjeSljudima < 4) {
            pr = Podrucjerada.podrucje(3);
        } else if (snalazenjeRecima > 2 && pokretnostRukuPrstiju > 2 && snalazenjeSljudima > 3 && snalazenjeBrojevima > 2 && shvatanjeProstora < 3) {
            pr = Podrucjerada.podrucje(15);
        } else {
            pr = Podrucjerada.podrucje(9);
        }
        List<Skole> a = new ArrayList<>();
        int b = 0;
        for (Skole s : skole) {
            if (s.getListPodrucjeRada() == pr.getPodrucjeRada()) {
                a.add(s);
                b++;
            }
            if (b == 5) {
                return a;
            }
        }
        return null;
    }

}
