/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.util.List;
import domain.Skole;
/**
 *
 * @author marij
 */
public interface AlgorithmStep {
    
    public List<Skole> filtrirajSkole(List<Skole> skole);
   
}

