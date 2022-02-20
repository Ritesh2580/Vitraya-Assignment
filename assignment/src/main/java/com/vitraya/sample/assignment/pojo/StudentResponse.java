package com.vitraya.sample.assignment.pojo;

public class StudentResponse implements java.io.Serializable 
{
    public Boolean success=true;
    public Boolean isException=false;
    public Boolean isError=false;
    public Boolean hasResult=false;
    public String exception="";
    public String error="";
    public Object result=null;
}