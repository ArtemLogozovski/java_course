package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Test", "Test", "TTT", "test", "testcompany", "Russia", "+71231234578", "+79876543210", "test@test.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoToHomePage();
  }
}
