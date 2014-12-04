/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Jeanette
 */
public class Country
{
    private String country;
    private ArrayList<Country> landList = new ArrayList<>();

    public Country(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return country;
    }

    public ArrayList<Country> Countries()
    {
        landList.add(new Country("Denmark"));
        landList.add(new Country("Columbia"));
        landList.add(new Country("Germany"));
        landList.add(new Country("USA"));
        landList.add(new Country("Afghanistan"));

        return landList;
    }
}
