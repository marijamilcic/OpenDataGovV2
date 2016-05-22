/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;
import domain.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author marij
 */
public class RecommendationAlgorithm {
    
    private List<Skole> skole = new ArrayList<>();
    private List<AlgorithmStep> algorithmSteps;
    
    public RecommendationAlgorithm(List<Skole> skole) {
        this.skole = skole;
        algorithmSteps = new ArrayList<>();
    }
    
    public List<Skole> getSkole(){
        algorithmSteps.stream().forEach(step -> {
            step.filtrirajSkole(skole);
        });
        return skole;
    }
    public Podrucjerada Licnost(Licnost licnost, Podrucjerada profil) {
        double snalazenjeRecima;
        double snalazenjeBrojevima;
        double shvatanjeMasina;
        double shvatanjeProstora;
        double pokretnostRukuPrstiju ;
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
               
        
        if(snalazenjeRecima < 3 && shvatanjeProstora >3 && shvatanjeMasina >3 && pokretnostRukuPrstiju >2 && snalazenjeSljudima <4) {
                    return Podrucjerada.podrucje(3);
        }else if(snalazenjeRecima > 2 && pokretnostRukuPrstiju > 2 && snalazenjeSljudima > 3 && snalazenjeBrojevima >2 && shvatanjeProstora <3){
                    return Podrucjerada.podrucje(15);
        }else {
                    return Podrucjerada.podrucje(9);
        }
    }
    
}
    

