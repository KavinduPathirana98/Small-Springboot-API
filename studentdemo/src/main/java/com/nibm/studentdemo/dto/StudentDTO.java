package com.nibm.studentdemo.dto;

public class StudentDTO {


    int sId;
    String sName;
    String sAddress;
    int sAge;
    String sTel;

    public StudentDTO() {
    }

    public StudentDTO(int sId, String sName, String sAddress, int sAge, String sTel) {
        this.sId = sId;
        this.sName = sName;
        this.sAddress = sAddress;
        this.sAge = sAge;
        this.sTel = sTel;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }

}
