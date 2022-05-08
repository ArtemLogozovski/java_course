package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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
    List <ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("Test1").withLastname("Test").withMiddlename("Test").withNickname("TTT").withTitle("test")
            .withCompanyName("testcompany").withAddress("Russia").withHomePhoneNumber("+71231234578")
            .withMobilePhoneNumber("+79876543210").withEmail("test@test.com");
    app.contact().modify(index, contact);
    List <ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
