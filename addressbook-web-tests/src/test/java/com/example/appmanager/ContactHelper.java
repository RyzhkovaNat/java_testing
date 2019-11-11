package com.example.appmanager;

import com.example.models.ContactData;
import com.example.models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {

    private NavigationHelper navigationHelper;

    public ContactHelper(WebDriver driver) {
        super(driver);
        navigationHelper = new NavigationHelper(driver);
    }

    public void submitContactForm() {
        click(By.name("submit"));
    }

    public void populate(ContactData contactData) {
        type((By.name("firstname")), (contactData.getFirstName()));
        type((By.name("lastname")), (contactData.getLastName()));
        type((By.name("address")), (contactData.getAddress()));
        type((By.name("email")), (contactData.getEmail()));
        type((By.name("mobile")), (contactData.getMobilePhone()));
        type((By.name("home")), (contactData.getHomePhone()));
        type((By.name("work")), (contactData.getWorkPhone()));
    }

    public void edit(ContactData contact) {
        editContactById(contact.getId());
        populate(contact);
        submit();
        ReturnToHomePage();
    }

    public void selectById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void delete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submit() {
        click((By.xpath("(//input[@value='Update'])")));
    }

    public void editContactById(int id) {
        driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void submitAlert() {
        driver.switchTo().alert().accept();
    }

    public void ReturnToHomePage() {
        click(By.linkText("home page"));
    }

    public boolean isThereAContact() {
        return isElementPresent((By.name("selected[]")));
    }

    public void create(ContactData contact) {
        navigationHelper.goToContactForm();
        populate(contact);
        submitContactForm();
        ReturnToHomePage();
    }

    public void deleteFromForm(ContactData contact) {
        editContactById(contact.getId());
        delete();
        navigationHelper.homePage();
    }

    public void deleteFromList(ContactData contact) {
        selectById(contact.getId());
        delete();
        submitAlert();
        navigationHelper.homePage();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            String email = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
            String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withEmail(email).withAddress(address).withAllPhones(allPhones);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getAttribute("value");
        String email = driver.findElement(By.name("email")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        navigationHelper.homePage();
        return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName).withEmail(email).withAddress(address).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
