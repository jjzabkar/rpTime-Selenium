package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

/**
 * User: John
 * Date: 10/23/13
 * Time: 3:54 PM
 */
public class ConfirmationPage extends BasicPageObject {

    private static final String ALLOW_BUTTON_ID = "submit_true";

    private AllowButton allowButton;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Confirmation page should not be opened directly.");
    }

    public HomePage confirm() {
        try {
            getWebDriver().findElement(By.name(ALLOW_BUTTON_ID));
            allowButton = new AllowButton(getWebDriver());
            return allowButton.click();
        } catch (NoSuchElementException nseex) {
            return new HomePage(getWebDriver());
        }
    }

    private class AllowButton extends Button<HomePage> {

        public AllowButton(WebDriver driver) {
            super(driver, ALLOW_BUTTON_ID, true);
        }

        @Override
        public HomePage click() {
            getElement().click();
            return new HomePage(getDriver());
        }

    }
}
