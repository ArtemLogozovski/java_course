package ru.stqa.javacourse.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletingTests extends TestBase {

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
  public void testContactDeletion() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List <ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
