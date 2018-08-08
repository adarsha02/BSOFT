package com.sahil;

public class Users {
    private int AccountNum;
    private String ClientFirstName;
    private String ClientMiddleName;
    private String ClientLastName;
    private String ClientSex;
    private int ClientCitizenshipNum;
    private int ClientContactNum;
    private boolean isDeleted;
    private double ClientAmount;
    public Users(int AccountNum,String ClientFirstName, String ClientMiddleName, String ClientLastName, String ClientSex, int ClientCitizenshipNum, int ClientContactNum, boolean isDeleted, double ClientAmount)
    {
        this.AccountNum =AccountNum;
        this.ClientFirstName=ClientFirstName;
        this.ClientMiddleName=ClientMiddleName;
        this.ClientLastName=ClientLastName;
        this.ClientSex=ClientSex;
        this.ClientCitizenshipNum=ClientCitizenshipNum;
        this.ClientContactNum=ClientContactNum;
        this.isDeleted=isDeleted;
        this.ClientAmount=ClientAmount;
    }
    public int getAccountNum()
    {
        return AccountNum;
    }
    public String getClientFirstName()
    {
        return ClientFirstName;
    }
    public String getClientMiddleName()
    {
        return ClientMiddleName;
    }
    public String getClientLastName()
    {
        return ClientLastName;
    }
    public String getClientSex()
    {
        return ClientSex;
    }
    public int getClientCitizenshipNum()
    {
        return ClientCitizenshipNum;
    }
    public int getClientContactNum()
    {
        return ClientContactNum;
    }
    public boolean getisdeleted()
    {
        return isDeleted;
    }
    public double getClientAmount(){return ClientAmount;}

}
