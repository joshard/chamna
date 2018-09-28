package com.example.root.chamna;

public class order {
    private String id; //id
    private String itemId; //id
    private String buyerId; //id
    private String shareId; //id private String Title; //id
    private String shareAmt; //id
    private String buyReg; //id
    private String buyRegAmt; //id
    private  String shareReg;
    private  String shareRegAmt;
    private String Status; //id
    private String lastAct; //id
    private String lastActBy; //id
    private String lastActTime; //id
    private String Pic; //itemPic
    private String Name; //itemPic
    private String delLoc; //id
    private String delMode; //id
    private String payMode; //itemPic
    private String bonusTot; //itemPic
    private String Seller; //itemPic

    public order(){
        order or = new order(getOrderItemId(),getOrderBuyer(),getOrderShareId(),"Juros Reg By..","",getOrderLastAct(),getOrderLastActBy(),getOrderPic(),getOrderName(),getOrderBonus());

     }

    public order(String itemid, String buyerid, String shareid, String buyreg, String sharereg,String lastact, String lastactby, String pic, String name, String bonustot) {
        this.itemId = itemid;
        this.buyerId = buyerid;
        this.shareId=shareid;
    //    this.shareAmt=shareamt;
        this.buyReg=buyreg;
    //    this.buyRegAmt=buyregamt;
        this.shareReg=sharereg;
  //      this.shareRegAmt = shareregamt;
        this.lastAct=lastact;
        this.lastActBy=lastactby;
        this.Pic=pic;
        this.Name = name;
        this.bonusTot = bonustot;




    }

    public String getOrderName() {
        return Name;
    }

    public String getOrderPic() {
        return Pic;
    }

    public String getOrderItemId() {
        return itemId;
    }
    public String getOrderBuyer() {
        return buyerId;
    }
    public String getOrderShareId() {
        return shareId;
    }
    public String getOrderBonus() {
        return bonusTot;
    }
    public String getOrderLastAct() {
        return lastAct;
    }
    public String getOrderLastActBy() {
        return lastActBy;
    }
    public String getOrderSeller() {
        return Seller;
    }

    public void setOrderName(String name) {
        Name = name;
    }

    public void setOrderPic(String name) {
        Name = name;
    }

    public void setOrderBuyer(String buy) {
        buyerId= buy;
    }

    public void setOrderBonus(String pic) {
        bonusTot = pic;
    }

    public void setOrderShareId(String seller) {
        shareId = seller;
    }

    public void setOrderLastAct(String bonus) {
        lastAct = bonus;
    }

    public void setOrderLastActBy(String category) {
        lastActBy = category;
    }
    public void setOrderSeller(String category) {
        Seller = category;
    }


}
