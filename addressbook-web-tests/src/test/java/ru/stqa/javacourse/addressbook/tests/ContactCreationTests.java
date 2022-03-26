package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Petrov", "Ivanov", "Sidorov", "IPS", "test", "testcompany", "Russia", "+73831234578", "+71234567890", "test@test.com"));
    app.submitContactCreation();
    app.gotoToHomePage();
    app.logout();
  }

}
