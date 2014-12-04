/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jeanette
 */
public class Country
{
    private String country;

    public Country(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return country;
    }

    @Override
    public String toString()
    {
        return country;
    }


}
