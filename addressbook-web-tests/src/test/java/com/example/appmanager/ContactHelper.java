package com.example.appmanager;

import com.example.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactForm() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void enterFormData(ContactData contactData) {
        type((By.name("firstname")),(contactData.getFirstName()));
        type((By.name("lastname")),(contactData.getLastName()));
        type((By.name("address")),(contactData.getAddress()));
        type((By.name("email")),(contactData.getEmail()));
        type((By.name("mobile")),(contactData.getPhone()));
    }
}
