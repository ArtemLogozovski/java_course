package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions () {
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Test", "Test", "Test", "TTT", "test", "testcompany", "Russia", "+71231234578", "+79876543210", "test@test.com", "Test1"));
    }
  }

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoToHomePage();
    List <ContactData> before = app.getContactHelper().getContactsList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(),"Test", "Test", "Test", "TTT", "test", "testcompany", "Russia", "+71231234578", "+79876543210", "test@test.com", null);
    app.getContactHelper().modifyContact(index, contact);
    List <ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
