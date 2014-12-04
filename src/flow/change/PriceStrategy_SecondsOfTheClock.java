/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow.change;

import Interface.PriceStrategy;
import Model.Drugs;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Pernille
 */
//prisstrategi der anvender sekundslaget til at afgøre prisen og avaoilabilitien
public class PriceStrategy_SecondsOfTheClock implements PriceStrategy
{

    int finalPrice;
    int finalAvailability;

    @Override
    public int calculateFinalPrice(Drugs drug)
    {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        System.out.println(cal.get(Calendar.SECOND));
        if (Calendar.SECOND != 0)
        {
            finalPrice = (cal.get(Calendar.SECOND)) * 2;
            return finalPrice;

        } else
        {
            finalPrice = (cal.get(Calendar.SECOND) + 1)*2;
            return finalPrice;
        }

    }

    @Override
    public int calculateAvailability(Drugs drug)
    {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        if (Calendar.SECOND != 0)
        {
            finalAvailability = cal.get(Calendar.SECOND);
            return finalAvailability;
        } else
        {
            finalAvailability = cal.get(Calendar.SECOND) + 1;
            return finalAvailability;
        }

    }
}
