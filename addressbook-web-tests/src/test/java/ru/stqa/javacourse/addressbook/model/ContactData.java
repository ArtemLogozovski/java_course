package ru.stqa.javacourse.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String companyName;
  private final String address;
  private final String homePhoneNumber;
  private final String mobilePhoneNumber;
  private final String email;
  private final String group;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String companyName, String address, String homePhoneNumber, String mobilePhoneNumber, String email, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.companyName = companyName;
    this.address = address;
    this.homePhoneNumber = homePhoneNumber;
    this.mobilePhoneNumber = mobilePhoneNumber;
    this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddleName() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhoneNumber() {
    return homePhoneNumber;
  }

  public String getMobilePhoneNumber() {
    return mobilePhoneNumber;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) && Objects.equals(middlename, that.middlename);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, middlename);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            '}';
  }

  public String getGroup() {return group;}
}
