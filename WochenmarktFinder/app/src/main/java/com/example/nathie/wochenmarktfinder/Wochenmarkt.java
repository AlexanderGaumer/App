package com.example.nathie.wochenmarktfinder;

public class Wochenmarkt {

    int Id;
    String type;
    String city;
    String address;
    String business_time;
    String contact;
    String offer;
    int favorite;


    public Wochenmarkt(){
    }

    public Wochenmarkt(String type, String city, String address,
                       String business_time, String contact, String offer, int favorite){
        this.type = type;
        this.city = city;
        this.address = address;
        this.business_time = business_time;
        this.contact = contact;
        this.offer = offer;
        this.favorite = favorite;
    }

    public int get_id() {
        return Id;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() { return address; }

    public String getBusiness_time() {
        return business_time;
    }

    public String getContact() {
        return contact;
    }

    public String getOffer() {
        return offer;
    }

    public int getFavorite(){ return favorite;}

    public void set_id(int Id) { this.Id = Id; }

    public void setType(String type) {
        this.type = type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBusiness_time(String business_time) {
        this.business_time = business_time;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setFavorite(int favorite){ this.favorite = favorite;}
}