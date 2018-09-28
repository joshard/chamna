package com.example.root.chamna;

public class item {
    private String Title; //id
    private String Name; //id
    private String Price; //id
    private String Curr; //id private String Title; //id
    private String Bonus; //id
    private String Pic; //id
    private String Seller; //id
    private  String Category;
    private  String Description;
    private String Status; //id
    private String Total; //id
    private String Paymode; //id
    private String Location; //id
    private String Expiry; //id
    private int thumbnails;
     public item(){

     }

    public item(String title, String name, String price, String category, String description, String pic, String seller, String bonus) {
        Title = title;
        Category = category;
        this.Name=name;
        this.Price=price;
        this.Pic=pic;
        this.Seller=seller;
        this.Bonus=bonus;
        Description = description;





    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }
    public String getname() {
        return Name;
    }
    public String getprice() {
        return Price;
    }
    public String getpic() {
        return Pic;
    }
    public String getseller() {
        return Seller;
    }
    public String getbonus() {
        return Bonus;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setname(String name) {
        Name = name;
    }

    public void setprice(String price) {
        Price = price;
    }

    public void setpic(String pic) {
        Pic = pic;
    }

    public void setseller(String seller) {
        Seller = seller;
    }

    public void setbonus(String bonus) {
        Bonus = bonus;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
