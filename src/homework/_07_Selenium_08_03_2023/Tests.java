package homework._07_Selenium_08_03_2023;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;
import utility.MyFunction;

import java.time.Duration;
import java.util.List;

public class Tests extends BaseDriver {

    @Test
    public void test1() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement alertsLink = driver.findElement(By.id("Alerts"));
        alertsLink.click();

        System.out.println("Current Url = " + driver.getCurrentUrl());

    }

    @Test
    public void test2() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement alertsLink = driver.findElement(By.id("Alerts"));
        alertsLink.click();

        System.out.println("Current Url = " + driver.getCurrentUrl());

        driver.navigate().back();

        System.out.println("Current Url = " + driver.getCurrentUrl());

        WebElement ajaxLink = driver.findElement(By.id("basicajax"));
        ajaxLink.click();

        System.out.println("Current Url = " + driver.getCurrentUrl());
    }

    @Test
    public void test3() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement findByPlaygroundLink = driver.findElement(By.id("findby"));
        findByPlaygroundLink.click();

        WebElement fifthText = driver.findElement(By.id("p5"));

        System.out.println("The Fifth Text = " + fifthText.getText());

    }

    @Test
    public void test4() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement searchLink = driver.findElement(By.id("search"));
        searchLink.click();

        WebElement headingText = driver.findElement(By.xpath("//h1[text()='The \"Selenium Simplified\" Search Engine']"));

        System.out.println("The Heading= " + headingText.getText());

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search']"));
        searchButton.click();

        System.out.println("Current Url = " + driver.getCurrentUrl());

    }

    @Test
    public void test5() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculateLink = driver.findElement(By.id("calculate"));
        calculateLink.click();

        WebElement firstInput = driver.findElement(By.id("number1"));
        firstInput.sendKeys("23");

        WebElement secondInput = driver.findElement(By.id("number2"));
        secondInput.sendKeys("11");

        WebElement calculateButton = driver.findElement(By.id("calculate"));
        calculateButton.click();

        WebElement result = driver.findElement(By.id("answer"));
        System.out.println("Result = " + result.getText());

    }

    @Test
    public void test6() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlertsLink = driver.findElement(By.id("fakealerttest"));
        fakeAlertsLink.click();

        WebElement showAlertBoxLink = driver.findElement(By.id("fakealert"));
        showAlertBoxLink.click();

        WebElement okButton = driver.findElement(By.id("dialog-ok"));
        okButton.click();

    }

    @Test
    public void test7() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlertsLink = driver.findElement(By.id("fakealerttest"));
        fakeAlertsLink.click();

        WebElement showModalDialogLink = driver.findElement(By.id("modaldialog"));
        showModalDialogLink.click();

        WebElement okButton = driver.findElement(By.id("dialog-ok"));
        okButton.click();

    }

    @Test
    public void test8() {
        driver.get("http://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");

        WebElement normalSuccessMessageLink = driver.findElement(By.id("normal-btn-success"));
        normalSuccessMessageLink.click();

        WebElement closeSuccessMessage = driver.findElement(By.xpath("(//button[@class='close'])[1]"));
        closeSuccessMessage.click();

    }

    @Test
    public void test9() {
        driver.get("http://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");

        WebElement normalSuccessMessageLink = driver.findElement(By.id("normal-btn-success"));
        normalSuccessMessageLink.click();

        WebElement successMessage = driver.findElement(By.cssSelector("[class='alert alert-success alert-normal-success']"));

        WebElement closeSuccessMessage = driver.findElement(By.xpath("(//button[@class='close'])[1]"));
        closeSuccessMessage.click();

        Assert.assertFalse(successMessage.isDisplayed());

    }

    @Test
    public void test10() {
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");

        WebElement normalSuccessMessageLink = driver.findElement(By.id("normal-btn-success"));
        normalSuccessMessageLink.click();

        WebElement successMessage = driver.findElement(By.cssSelector("[class='alert alert-success alert-normal-success']"));

        WebElement closeSuccessMessage = driver.findElement(By.xpath("(//button[@class='close'])[1]"));
        closeSuccessMessage.click();

        Assert.assertFalse(successMessage.isDisplayed());

    }

    @Test
    public void test11() {
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        WebElement daySelect = driver.findElement(By.id("select-demo"));
        Select day = new Select(daySelect);

        int wednesdayEnabled = 0;

        do {
            int randomNumber = (int) (Math.random() * 7) + 1;
            day.selectByIndex(randomNumber);
            WebElement dayVerification = driver.findElement(By.className("selected-value"));
            if (dayVerification.getText().contains("Wednesday")) {
                wednesdayEnabled++;
            }
        } while (wednesdayEnabled != 5);

        System.out.println("Wednesday Number of Views = " + wednesdayEnabled);
    }

    @Test
    public void test12() {
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");

        WebElement inputFormLink = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputFormLink.click();

        WebElement ajaxFormSubmitLink = driver.findElement(By.xpath("(//a[text()='Ajax Form Submit'])[2]"));
        ajaxFormSubmitLink.click();

        WebElement name= driver.findElement(By.id("title"));
        name.sendKeys("Name");

        WebElement comment = driver.findElement(By.id("description"));
        comment.sendKeys("Comment added.");

        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();

        WebElement submitSuccessMessage = driver.findElement(By.id("submit-control"));
        WebElement submitSuccessMessage2 = driver.findElement(By.xpath("//div[text()='Form submited Successfully!']"));

        Assert.assertEquals("Form submited unsuccessfully!",submitSuccessMessage.getText(),"Form submited Successfully!");

        System.out.println("Submit Success Message = " + submitSuccessMessage.getText());
    }
    @Test
    public void test13() {
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");

        WebElement listBoxLink = driver.findElement(By.xpath("//a[text()='List Box']"));
        listBoxLink.click();

        WebElement bootstrapListBoxLink = driver.findElement(By.xpath("(//a[text()='Bootstrap List Box'])[2]"));
        bootstrapListBoxLink.click();

        WebElement bootstrapDuallistBox = driver.findElement(By.xpath("//li[text()='bootstrap-duallist ']"));
        bootstrapDuallistBox.click();

        WebElement rightArrow= driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-right']"));
        rightArrow.click();

        WebElement dapibusAcFacilisisInBox = driver.findElement(By.xpath("(//li[text()='Dapibus ac facilisis in'])[1]"));
        dapibusAcFacilisisInBox.click();

        rightArrow.click();

    }




















    @Test
    public void test20() {
        driver.get("http://en.wikipedia.org/wiki/FIFA_World_Cup");

        WebElement attendanceLink = driver.findElement(By.xpath("//*[@id=\"toc-Attendance\"]/a/div"));
        attendanceLink.click();

        List<WebElement> hosts = driver.findElements(By.xpath("//td[@style='text-align:left' or @style='text-align: left']"));

        for (WebElement host : hosts) {
            System.out.println("host.getText() = " + host.getText());
        }
        System.out.println("hosts.size() = " + hosts.size());

    }
}
