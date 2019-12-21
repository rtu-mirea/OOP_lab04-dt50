package com.company;

import java.sql.Array;
import java.util.ArrayList;

public class Tour {
    private String tourName;
    private String country;
    private String city;
    private String accommodations;//что бы это не значило
    private String hotelName;
    private String dateIn;
    private String dateOut;
    private int excoursionNumber;
    private int price;
    private String companyName;

    public Tour(){
        tourName = "";
        country = "";
        city = "";
        accommodations = "";//что бы это не значило
        hotelName = "";
        dateIn = "";
        dateOut = "";
        excoursionNumber = 0;
        price = 0;
        companyName = "";
    }
    public Tour(String tourName, String country, String city, String accommodations, String hotelName,
                String dateIn, String dateOut, int excoursionNumber, int price, String companyName){
        this.tourName = tourName;
        this.country = country;
        this.city = city;
        this.accommodations = accommodations;//что бы это не значило
        this.hotelName = hotelName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.excoursionNumber = excoursionNumber;
        this.price = price;
        this.companyName = companyName;
    }
    public String getTourName(){return tourName; }
    public String getCountry(){return country;};
    public String getCity(){return city;};
    public String getAccommodations(){return accommodations;}
    public String getHotelName(){return hotelName;}
    public String getDateIn(){return dateIn;}
    public String getDateOut(){return dateOut;}
    public String getCompanyName(){return companyName;}
    public int getExcoursionNumber(){return excoursionNumber;}
    public int getPrice(){return price;}
    public String getCityOfTourName(String tourName){
        if (this.tourName.compareTo(tourName) == 0)
            return this.city;
        else return "";
    }
    public String getCountryOfTourName(String tourName){
        if (this.tourName.compareTo(tourName) == 0)
            return this.country + " " + this.city;
        else return "";
    }
    public boolean compare(Tour tour){
        return this.price == tour.price;
    }
    public static ArrayList<Tour> getOneCompany(ArrayList<Tour> tours, String companyName){
        ArrayList<Tour> res = new ArrayList<Tour>();
        for(Tour tour: tours){
            if (tour.companyName.compareTo(companyName) == 0)
                res.add(tour);
        }
        return res;
    }
    public static ArrayList<Tour> upPrise(ArrayList<Tour> tours, int index){
        tours.get(index).price += tours.get(index).price/10;
        return tours;
    }
    public void increase(){
        tourName = grow(tourName);
        country = grow(country);
        city = grow(city);
        accommodations = grow(accommodations);//что бы это не значило
        hotelName = grow(hotelName);
        dateIn = grow(dateIn);
        dateOut = grow(dateOut);
        companyName = grow(companyName);
    }
    private static String grow(String str){
        for(int i = str.length(); i <= 15; i++)
            str+=" ";
        return str;
    }
}
