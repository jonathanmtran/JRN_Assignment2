/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

/**
 *
 * @author dead
 */



public class User {
    
    private String firstName, lastName, email;
    
    public User()
    {
        firstName = "";
        lastName = "";
        email = "";
    }
    
    public void setFirstName(String f)
    {
        firstName = f;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String l)
    {
        lastName = l;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setEmail(String e)
    {
        email = e;
    }
    
    public String getEmail()
    {
        return email;
    }
}
