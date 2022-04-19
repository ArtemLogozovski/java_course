package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Test", "Test", "Test", "TTT", "test", "testcompany", "Russia", "+71231234578", "+79876543210", "test@test.com", "Test1"), true);
    }
    app.getNavigationHelper().gotoToHomePage();
    List <ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Test", "Test", "TTT", "test", "testcompany", "Russia", "+71231234578", "+79876543210", "test@test.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoToHomePage();
    List <ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size());

  }
}
