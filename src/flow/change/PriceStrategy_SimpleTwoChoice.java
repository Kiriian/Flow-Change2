/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow.change;

import Interface.PriceStrategy;
import Model.Drugs;

/**
 *
 * @author Pernille
 */
// vi har ikke nået at lave denne prisstrategi
public class PriceStrategy_SimpleTwoChoice implements PriceStrategy
{

    @Override
    public int calculateFinalPrice(Drugs drug)
    {
       return 0;
    }

    @Override
    public int calculateAvailability(Drugs drug)
    {
       return 0;
    }
    
}
