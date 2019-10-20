package com.example.appmanager;

import com.example.models.ContactData;
import com.example.models.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    public void enterFormData(ContactData contactData) {
        type((By.name("firstname")), (contactData.getFirstName()));
        type((By.name("lastname")), (contactData.getLastName()));
        type((By.name("address")), (contactData.getAddress()));
        type((By.name("email")), (contactData.getEmail()));
        type((By.name("mobile")), (contactData.getPhone()));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteContactFromList() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void deleteContactFromForm() {
        click((By.xpath("(//input[@value='Delete'])")));
    }

    public void submitUpdateForm() {
        click((By.xpath("(//input[@value='Update'])")));
    }

    public void editContact() {
        click(By.xpath("//img[@alt=\'Edit\']"));
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

    public void createContact(ContactData contact) {
        navigationHelper.goToContactForm();
        enterFormData(contact);
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
            ContactData contact = new ContactData(id, firstName, lastName, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
