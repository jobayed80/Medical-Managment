/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import Employee.*;




    public class Patient_Private {
    private String P_Id;
    private String P_FullName;
    private String P_FatherName;
    private String age;
    private String Contact;
    private String Doctor_Name;
    private String Address;
    private String Reg_Date;
    private String Gender;
    private String Patient_Illness;
    
    
    public Patient_Private(){}
    
    public Patient_Private(String id,String P_Name,String P_fatherName,String add,String con,String AGE,String gender,String patientIllness,String doctorN, String regDate)
    {
        this.P_Id = id;
        this.P_FullName = P_Name;
        this.P_FatherName = P_fatherName;
        this.age = AGE;      
        this.Contact = con;
        this.Address = add;
        this.Reg_Date = regDate;
        this.Doctor_Name = doctorN;
        this.Gender = gender;
        this.Patient_Illness = patientIllness;
        
  
    }
    
    public String getP_Id() {
        return P_Id;
    }

    public void setP_Id(String P_Id) {
        this.P_Id = P_Id;
    }

    public String getP_FullName() {
        return P_FullName;
    }

    public void setP_FullName(String P_FullName) {
        this.P_FullName = P_FullName;
    }

    public String getP_FatherName() {
        return P_FatherName;
    }

    public void setP_FatherName(String P_FatherName) {
        this.P_FatherName = P_FatherName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getDoctor_Name() {
        return Doctor_Name;
    }

    public void setDoctor_Name(String Doctor_Name) {
        this.Doctor_Name = Doctor_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getReg_Date() {
        return Reg_Date;
    }

    public void setReg_Date(String Reg_Date) {
        this.Reg_Date = Reg_Date;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPatient_Illness() {
        return Patient_Illness;
    }

    public void setPatient_Illness(String Patient_Illness) {
        this.Patient_Illness = Patient_Illness;
    }

    


    }