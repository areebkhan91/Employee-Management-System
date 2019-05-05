package POJO;

public class RegistrationPOJO extends LoginPOJO {
private String emailID;
private String fname;
private String lname;
private String address;
private String phoneNo;
private float wage;
private float bonus;

public String getEmailID() {
	return emailID;
}

public void setEmailID(String emailID) {
	this.emailID = emailID;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}

public float getWage() {
	return wage;
}

public void setWage(float wage) {
	this.wage = wage;
}

}
