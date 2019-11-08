package com.example.appmanager;

import com.example.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    private NavigationHelper navigationHelper;

    public ContactHelper(WebDriver driver) {
        super(driver);
        navigationHelper = new NavigationHelper(driver);
    }

    public void submitContactForm() {
        click(By.xpath("(//input[@name='submit'])"));
    }

    public void populate(ContactData contactData) {
        type((By.name("firstname")), (contactData.getFirstName()));
        type((By.name("lastname")), (contactData.getLastName()));
        type((By.name("address")), (contactData.getAddress()));
        type((By.name("email")), (contactData.getEmail()));
        type((By.name("mobile")), (contactData.getPhone()));
    }

    public void edit(int index, ContactData contact) {
        editContact(index);
        populate(contact);
        submit();
        ReturnToHomePage();
    }

    public void deleteFromList(int index) {
        select(index);
        delete();
        submitAlert();
        navigationHelper.homePage();
    }

    public void deleteFromForm(int index) {
        editContact(index);
        delete();
        navigationHelper.homePage();
    }

    public void select(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void delete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submit() {
        click((By.xpath("(//input[@value='Update'])")));
    }

    public void editContact(int index) {
        driver.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
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

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withEmail(null).withAddress(null).withPhone(null);
            contacts.add(contact);
        }
        return contacts;
    }
}
