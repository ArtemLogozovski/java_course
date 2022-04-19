package ru.stqa.javacourse.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
    app.getContactHelper().createContact(new ContactData("Petrov", "Ivanov", "Sidorov", "IPS", "test", "testcompany", "Russia", "+73831234578", "+71234567890", "test@test.com", "Test1"), true);
  }

}
