package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletingTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().submitDeletingContacts();
  }

}
