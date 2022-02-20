package com.vitraya.sample.assignment.pojo;

public class Student{
    private Integer rollNumber;
    private String name;
    private String address;

    public Student(Integer rollNumber,String name,String address)
    {
        this.rollNumber=rollNumber;
        this.name=name;
        this.address=address;
    }    

    public void setName(String name)
    {
        this.name=name;
    }

    public void setAddress(String address)
    {
        this.address=address;
    }

    public void setRollNumber(Integer rollNumber )
    {
        this.rollNumber=rollNumber;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public Integer getRollNumber()
    {
        return this.rollNumber;
    }

    public Boolean isValid()
    {
        return (this.name==null||this.address==null||this.name.length()==0||this.address.length()==0)? false : true;
    }

}
