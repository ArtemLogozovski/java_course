package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    app.goTo().groupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Test1").withLastname("Test").withMiddlename("Test").withNickname("TTT").withTitle("test")
            .withCompanyName("testcompany").withAddress("Russia").withHomePhoneNumber("+71231234578")
            .withMobilePhoneNumber("+79876543210").withEmail("test@test.com").withGroup("Test1");
    app.contact().create(contact);
    Set <ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
