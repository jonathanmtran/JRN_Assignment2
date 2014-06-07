package business;


import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dead
 */
public class CellPhone implements Serializable
{
    //ArrayList productInfo = new ArrayList();
    String code="";
    String name="";
    String imageLoc="";
    String description="";
    String specs="";
    Double price=0.0;
    
    
    public CellPhone(/*String n,String i,String d, String s, Double p*/)
    {
        /*
        name = n;
        imageLoc = i;
        description = d;
        specs = s;
        price = p;
                */
    }
    
    public String getCode(){
        return code;
    }
    
    public void setCode(String c){
        code = c;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public String getImageLoc(){
        return imageLoc;
    }
    public void setImageLoc(String i){
        imageLoc = i;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String d){
        description = d;
    }
    
    public String getSpecs(){
        return specs;
    }
    
    public void setSpecs(String s){
        specs = s;
    }
    
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double p){
        price = p;
    }
    
    public String getPriceCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }    
    
}
