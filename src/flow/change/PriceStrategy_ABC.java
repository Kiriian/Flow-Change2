/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow.change;

import Interface.PriceStrategy;
import Model.Drugs;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Pernille
 */
// denne klasse implementerer interface og indeholder prisstrategi for opgave a-c

public class PriceStrategy_ABC implements PriceStrategy
{
    private Random random = new Random();
    private ArrayList<Drugs> drugArray;
    private String drug;
    private int factor;
    private int adjust;
    private int adjustAva;
    private int middelSum;
    private int finalPrice;
    private int middelSumAva;
    private int finalAvailability;
    

    @Override
    public int calculateFinalPrice(Drugs drug)
    {        
        adjust = random.nextInt(85) + 1;
        if (adjust % 2 == 0)// denne kode tager kun højde for kokain
        {
            middelSum = ((adjust * drug.getBasePrice()) / 100);
            finalPrice = drug.getBasePrice() - middelSum;
            finalPrice = finalPrice*goldenNumberFactor(drug);
            return finalPrice;
        } else
        {
            middelSum = ((adjust * drug.getBasePrice()) / 100);
            finalPrice = drug.getBasePrice() + middelSum;
            finalPrice = finalPrice*goldenNumberFactor(drug);
            return finalPrice;
        }
    }
    public int getBasePrice(Drugs drug)
    {
        int temp = 0;
        for (Drugs i : drugArray)
        {
            if (drug.getDrugName().equals(i.getDrugName()))
            {
                temp = i.getBasePrice();
            }
        }
        return temp;
    }
    // beregner faktor til at gange på prisen. Faktor 10 hvis goldennumber er i in range.
    
    public int goldenNumberFactor(Drugs drug)
    {
        Random rand = new Random();
        int chance = rand.nextInt(100);
                if (chance <= drug.getGoldenNumber())
                {
                    if (chance % 2 == 0)
                    {
                        factor = 10;
                        return factor;
                    } else
                    {
                        factor = 1;
                        return factor;
                    }
                } else
                {
                    factor = 1;
                    return factor;
                }
    }
    @Override
    public int calculateAvailability(Drugs drug)
    {
        adjustAva = random.nextInt(40) + 15;
        if (adjustAva % 2 == 0)
        {
            middelSumAva = ((adjustAva * drug.getBaseAvailability()) / 100);
            finalAvailability = drug.getBaseAvailability() - middelSumAva;
            return finalAvailability;
        } else
        {
            middelSumAva = ((adjustAva * drug.getBaseAvailability()) / 100);
            finalAvailability = drug.getBaseAvailability() + middelSumAva;
            return finalAvailability;
        }
    }
    
    public int getBaseAvailiablity(Drugs drug)
    {
        int temp = 0;
        for (Drugs i : drugArray)
        {
            if (drug.getDrugName().equals(i.getDrugName()))
            {
                temp = i.getBaseAvailability();
                break;
            }

        }
        return temp;
    }
    
}
