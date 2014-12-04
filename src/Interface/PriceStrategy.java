/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Model.Drugs;

/**
 *
 * @author Pernille
 */
public interface PriceStrategy
{
    //metode til at beregne den endelige pris
    public int calculateFinalPrice(Drugs drug);
    //metode til at beregne den endelige availabiity af drugs
    public int calculateAvailability(Drugs drug);
}
