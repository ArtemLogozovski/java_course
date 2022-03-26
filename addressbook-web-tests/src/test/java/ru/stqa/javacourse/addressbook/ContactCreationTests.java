package ru.stqa.javacourse.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Petrov", "Ivanov", "Sidorov", "IPS", "test", "testcompany", "Russia", "+73831234578", "+71234567890", "test@test.com"));
    submitContactCreation();
    gotoToHomePage();
    logout();
  }

}
