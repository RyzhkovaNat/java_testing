package com.example.appmanager;

import com.example.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteContactFromList() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void deleteContactFromForm() {
        click((By.xpath("(//input[@name='update'])[3]")));
    }

    public void submitUpdateForm() {
        click((By.xpath("(//input[@name='update'])[2]")));
    }

    public void editContact() {
        click((By.xpath("//img[@alt=\'Edit\']")));
    }

    public void submitAlert() {
        driver.switchTo().alert().accept();
    }

    public void ReturnToHomePage() {
        click(By.linkText("home page"));
    }
}