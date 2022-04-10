package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Petrov", "Ivanov", "Sidorov", "IPS", "test", "testcompany", "Russia", "+73831234578", "+71234567890", "test@test.com", "Test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoToHomePage();
  }

}
