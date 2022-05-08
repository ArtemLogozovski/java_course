package ru.stqa.javacourse.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.javacourse.addressbook.model.ContactData;
import ru.stqa.javacourse.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupHelper extends HelperBase {

  NavigationHelper navigationHelper = new NavigationHelper(wd);

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage(){
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    navigationHelper.gotoGroupPage();
    return isElementPresent(By.name("selected[]"));
  }

  public boolean isThereAGroupWithName (String groupName) {
    navigationHelper.gotoGroupPage();
    groupName = "Select (" + groupName + ")";
    List<WebElement> elements = wd.findElements(By.name("selected[]"));
    for (int i = 0; i < elements.size(); i++) {
      String elementText = String.valueOf(elements.get(i).getAttribute("title"));
      if (elementText.equals(groupName)) {
        return true;
      }
    }
    return false;
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      GroupData group = new GroupData(name, null, null);
      groups.add(group);
    }
    return groups;
  }
}
