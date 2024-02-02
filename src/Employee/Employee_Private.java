/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;




    public class Employee_Private {
    private String EmpId;
    private String EmpFullName;
    private String EmpFatherName;
    private String EmpMotherName;
    private String Birthday;
    private String Status;
    private String Contact1;
    private String Contact2;
    private byte[] Image;
    private String Department;
    private String Address;
    private String Gender;
   // private String PatientIllness;
    
    
    public Employee_Private(){}
    
    public Employee_Private(String id,String empName,String fatherName,String motherName,byte[] img,String birth,String sta,String Con1,String Con2,String depart,String add, String gender)
    {
        this.EmpId = id;
        this.EmpFullName = empName;
        this.EmpFatherName = fatherName;
        this.EmpMotherName = motherName;
        this.Birthday = birth;
        this.Status = sta;
        this.Contact1 = Con1;
        this.Contact2 = Con2;
        this.Image = img;
        this.Address = add;
        this.Department = depart;
        this.Gender = gender;
        
  
    }
//    public String getName()
//    {
//        return Name;
//    }
//    public void setName(String NAME)
//    {
//        this.Name=NAME;
//    }
//    public String getBlood()
//    {
//        return Blood;
//    }
//    public void setBlood(String BLOOD)
//    {
//        this.Blood=BLOOD;
//    }
//    public String getContact()
//    {
//        return Contact;
//    }
//    public void setContact(String CONTACT)
//    {
//        this.Contact=CONTACT;
//    }
//    public String getAddress()
//    {
//        return Address;
//    }
//    public void setAddress(String ADDRESS)
//    {
//        this.Address=ADDRESS;
//    }
//    public String getLastDonation()
//    {
//        return LastDonation;
//    }
//    public void setLastDonation(String LASTDONATION)
//    {
//        this.LastDonation=LASTDONATION;
//    }
//    public byte[] getMyImage()
//    {
//        return Image;
//    }

    public String getEmpId() {
        return EmpId;
    }

    public void setEmpId(String EmpId) {
        this.EmpId = EmpId;
    }

    public String getEmpFullName() {
        return EmpFullName;
    }

    public void setEmpFullName(String EmpFullName) {
        this.EmpFullName = EmpFullName;
    }

    public String getEmpFatherName() {
        return EmpFatherName;
    }

    public void setEmpFatherName(String EmpFatherName) {
        this.EmpFatherName = EmpFatherName;
    }

    public String getEmpMotherName() {
        return EmpMotherName;
    }

    public void setEmpMotherName(String EmpMotherName) {
        this.EmpMotherName = EmpMotherName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getContact1() {
        return Contact1;
    }

    public void setContact1(String Contact1) {
        this.Contact1 = Contact1;
    }

    public String getContact2() {
        return Contact2;
    }

    public void setContact2(String Contact2) {
        this.Contact2 = Contact2;
    }

   

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

   
}
