package dataModal;

import java.util.Date;

public class Patient {
    private String hcNumber;
    private String lastName;
    private String firstName;
    private String address;
    private Integer teleNum;
    private Integer insuranceId;
    private Date subDate;

    public Patient(String hcNumber,  String lastName,String firstName, String address, Integer teleNum, Integer insuranceId, Date subDate) {
        this.hcNumber = hcNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.teleNum = teleNum;
        this.insuranceId = insuranceId;
        this.subDate = subDate;
    }

    public String getHcNumber
            () {
        return hcNumber;
    }

    public void setHcNumber(String hcNumber) {
        this.hcNumber = hcNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getaddress()
    {
        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public Integer getteleNum() {

        return teleNum;
    }

    public void setTeleNum(Integer teleNum) {

        this.teleNum = teleNum;
    }

    public Integer getinsuranceId()
    {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {

        this.insuranceId = insuranceId;
    }

    public Date getSubDate() {

        return subDate;
    }

    public void setSubDate() {
        this.subDate = subDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "hcNumber=" + hcNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", teleNum=" + teleNum +
                ", insuranceId=" + insuranceId +
                ", subDate='" + subDate + '\n' +
                '}';
    }
}
