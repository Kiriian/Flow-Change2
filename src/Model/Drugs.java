/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interface.PriceStrategy;
import java.util.ArrayList;

/**
 *
 * @author Pernille
 */
public class Drugs
{

    private String drugName;
    private int basePrice;
    private int baseAvailability;
    private int goldenNumber;
    private PriceStrategy priceStrategy;

    public Drugs(String drugName, int basePrice, int baseAvailability, int goldenNumber, PriceStrategy priceStrategy)
    {
        this.drugName = drugName;
        this.basePrice = basePrice;
        this.baseAvailability = baseAvailability;
        this.goldenNumber = goldenNumber;
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPriceStrategy()
    {
        return priceStrategy;
    }

    public int getGoldenNumber()
    {
        return goldenNumber;
    }

    public void setGoldenNumber(int goldenNumber)
    {
        this.goldenNumber = goldenNumber;
    }

    public String getDrugName()
    {
        return drugName;
    }

    public void setDrugName(String drugName)
    {
        this.drugName = drugName;
    }

    public int getBasePrice()
    {
        return basePrice;
    }

    public void setBasePrice(int basePrice)
    {
        this.basePrice = basePrice;
    }

    public int getBaseAvailability()
    {
        return baseAvailability;
    }

    public void setBaseAvailability(int baseAvailability)
    {
        this.baseAvailability = baseAvailability;
    }

    public int calFinal()
    {
        System.out.println(this + "didilido");
        
        return priceStrategy.calculateFinalPrice(this);
    }
    
    public int calAvailibality()
    {
        System.out.println(this+"lad");
        return priceStrategy.calculateAvailability(this);
    }
    
    @Override
    public String toString()
    {
        return drugName;
    }
    public String sellString()
    {
        return drugName+", "+baseAvailability;
    }
}
