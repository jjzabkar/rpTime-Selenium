package com.roosterpark.rptime.selenium.control.complex.list.contract;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.ContractsPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/22/13
 * Time: 2:28 PM
 */
public class ContractLink extends Link<ContractsPage> {

    private String id;

    public ContractLink(WebDriver driver, String id) {
        super(driver, id);
        this.id = id;
    }

    @Override
    public ContractsPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new ContractsPage(getDriver());
    }

    public String getId() {
        return id;
    }

}