package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.group().list().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test1"));
    }
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Test1").withLastname("Test").withMiddlename("Test").withNickname("TTT").withTitle("test")
              .withCompanyName("testcompany").withAddress("Russia").withHomePhoneNumber("+71231234578")
              .withMobilePhoneNumber("+79876543210").withEmail("test@test.com").withGroup("Test1"));
    }
  }

  @Test
  public void testContactModification() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Test1").withLastname("Test").withMiddlename("Test").withNickname("TTT").withTitle("test")
            .withCompanyName("testcompany").withAddress("Russia").withHomePhoneNumber("+71231234578")
            .withMobilePhoneNumber("+79876543210").withEmail("test@test.com");
    app.contact().modify(contact);
    Set <ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
