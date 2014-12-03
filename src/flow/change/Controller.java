/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow.change;

import Filehandler.FileHandler;
import Interface.PriceStrategy;
import java.util.Random;
import Model.Drugs;
import Model.Person;
import java.util.ArrayList;

/**
 *
 * @author Jeanette
 */
public class Controller
{

    private Random random = new Random();
    private ArrayList<Drugs> drugArray = new ArrayList<>();
    private ArrayList<Person> userArray = new ArrayList<>();
    private ArrayList<Drugs> yourDrugs = new ArrayList<>();
    private String drugName;
    private int finalPrice;
    private int days;
    private int totalPrice;
    private PriceStrategy PriceStrategy_OldMemory = new PriceStrategy_OldMemory();
    private PriceStrategy PriceStrategy_ABC = new PriceStrategy_ABC();
    private PriceStrategy PriceStrategy_SecondsOfTheClock = new PriceStrategy_SecondsOfTheClock();
    private PriceStrategy PriceStrategy_SimpleTwoChoice = new PriceStrategy_SimpleTwoChoice();

    public void addDrugs()
    {
        drugArray.add(new Drugs("Concain", 1200, 30, 10, PriceStrategy_OldMemory));
        drugArray.add(new Drugs("Heroin", 1600, 15, 15, PriceStrategy_ABC));
        drugArray.add(new Drugs("Amphetamine", 200, 50, 7, PriceStrategy_ABC));
        drugArray.add(new Drugs("Acid", 550, 33, 5, PriceStrategy_ABC));
        drugArray.add(new Drugs("AngelDust", 400, 60, 7, PriceStrategy_ABC));
        drugArray.add(new Drugs("CrystalMeth", 800, 38, 12, PriceStrategy_ABC));
        drugArray.add(new Drugs("Hash", 180, 100, 4, PriceStrategy_SimpleTwoChoice));
        drugArray.add(new Drugs("Weed", 150, 115, 5, PriceStrategy_ABC));
        drugArray.add(new Drugs("Mushrooms", 120, 95, 7, PriceStrategy_SecondsOfTheClock));
        drugArray.add(new Drugs("Valium", 290, 80, 7, PriceStrategy_ABC));
    }

    public ArrayList<Drugs> getDrugs()
    {
        return drugArray;
    }

    public int calculateFinalPrice(Drugs drug)
    {
        return drug.calFinal();

    }

    public int calculateFinalAvailability(Drugs drug)
    {

        return drug.calAvailibality();
    }

    public void buyDrugs(Drugs drug, int quantity)
    {
        if (!yourDrugs.isEmpty())
        {
            for (Drugs i : yourDrugs)
            {
                if (drug.getDrugName().equals(i.getDrugName()))
                {
                    i.setBaseAvailability(i.getBaseAvailability() + quantity);
                    System.out.println(yourDrugs.toString() + "fisk");
                    break;
                }
            }
        } else
        {
            drug.setBaseAvailability(quantity);
            yourDrugs.add(drug);
            System.out.println(yourDrugs.toString() + "hello");
        }

    }

    public boolean load(String filename)
    {
//        drugArray = FileHandler.loadDrugs("Drugs.txt");

        if (drugArray == null)
        {
            return false;
        } else
        {
            return true;
        }
    }

    public boolean save(String filename)
    {
        FileHandler.save(userArray, "highscore.txt");

        if (userArray == null)
        {
            return false;
        } else
        {
            return true;
        }
    }

    public int sellDrugs(String drugName)
    {
        Drugs temp = null;
        for (Drugs dObject : yourDrugs)
        {
            if (dObject.getDrugName().equals(drugName))
            {
                temp = dObject;
                return temp.getBaseAvailability();
            }
        }
        return 0;
    }

    public int travel(String username, int score)
    {
        if (days == 20)
        {
            addPerson(username);
            return days;
        } else
        {
            days++;
            return days;
        }
    }

    public void addPerson(String userName)
    {
        userArray.add(new Person(userName));

        FileHandler.save(userArray, "highscore.txt");
    }

    public int totalPrice(Drugs drug, int quantity)
    {
        return totalPrice = calculateFinalPrice(drug) * quantity;
    }

}