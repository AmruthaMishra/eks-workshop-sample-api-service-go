package com.healthcare.healthcare;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Mongo database annotation.
@Document(collection= "patient")
public class Patient {

 @Id
 private int id;
 private String name;
 private String age;
	private String address;
	private String country;
	private String phoneno;

 public Patient() { }

 public int getId() {
     return id;
 }
 public void setId(int id) {
     this.id = id;
 }
 public String getName() {
     return name;
 }
 public void setName(String name) {
     this.name = name;
 }
	 public String getAge() {
     return age;
 }
 public void setAge(String age) {
     this.age = age;
 }
	
 public String getAddress() {
     return address;
 }
 public void setAddress(String address) {
     this.address = address;
 }
	 public String getCountry() {
     return country;
 }
 public void setCountry(String country) {
     this.country = country;
 }
	 public String getPhoneNo() {
     return phoneno;
 }
 public void setPhoneNo(String phoneno) {
     this.phoneno = phoneno;
 }

 @Override
 public String toString() {
     return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", country=" + country + ", phoneno=" + phoneno + "]";
 }
}
