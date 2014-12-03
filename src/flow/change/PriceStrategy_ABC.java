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
        System.out.println(drug+"der");
        adjust = random.nextInt(85) + 1;
        System.out.println("adjust = "+adjust);
        if (adjust % 2 == 0)// denne kode tager kun højde for kokain
        {
            middelSum = ((adjust * drug.getBasePrice()) / 100);
            System.out.println("middlesum = " + middelSum);
            finalPrice = drug.getBasePrice() - middelSum;
            System.out.println("Price" + finalPrice);
            finalPrice = finalPrice*goldenNumberFactor(drug);
            System.out.println("endPrice" + finalPrice);
            return finalPrice;
        } else
        {
            middelSum = ((adjust * drug.getBasePrice()) / 100);
            System.out.println("middlesum2 = " + middelSum);
            finalPrice = drug.getBasePrice() + middelSum;
            System.out.println("Price" + finalPrice);
            finalPrice = finalPrice*goldenNumberFactor(drug);
            System.out.println("FinalPrice = " + finalPrice);
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
        System.out.println("Drugs" + drug.getDrugName());
        System.out.println(chance);
//        for (Drugs i : drugArray)
//        {
//            System.out.println("fisk " + i.getDrugName());
//            if (drug.getDrugName().equals(i.getDrugName()))
//            {
                if (chance <= drug.getGoldenNumber())
                {
                    if (chance % 2 == 0)
                    {
                        System.out.println("Factor3" + factor);
                        factor = 10;
                        return factor;
                    } else
                    {
                        System.out.println("Factor2" + factor);
                        factor = 1;
                        return factor;
                    }
                } else
                {
                    System.out.println("Factor1" + factor);
                    factor = 1;
                    return factor;
                }
//            }
//        }
//        System.out.println("Factor0" + factor);
//        return 0;
    }
    @Override
    public int calculateAvailability(Drugs drug)
    {
        System.out.println(drug + "blablabla");
        
        adjustAva = random.nextInt(40) + 15;
        System.out.println("adjustAva " + adjustAva);
        if (adjustAva % 2 == 0)
        {
            middelSumAva = ((adjustAva * drug.getBaseAvailability()) / 100);
            finalAvailability = drug.getBaseAvailability() - middelSumAva;
            System.out.println("middelsum" + middelSumAva + "adjust" + adjustAva);

            System.out.println("availability?" + finalAvailability);
            return finalAvailability;
        } else
        {
            middelSumAva = ((adjustAva * drug.getBaseAvailability()) / 100);
            finalAvailability = drug.getBaseAvailability() + middelSumAva;
            System.out.println("middelsum" + middelSumAva);
            System.out.println("availability" + finalAvailability + "adjust" + adjustAva);
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
