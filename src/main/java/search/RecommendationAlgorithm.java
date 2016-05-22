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
    
}
    

