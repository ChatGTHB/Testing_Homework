package homework._06_Selenium_08_03_2023;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;
import utility.MyFunction;

import java.time.Duration;
import java.util.List;


public class Tests extends BaseDriver {
    @Test
    public void scenerio1() {

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        Actions actions = new Actions(driver);

        WebElement integersOnlyRadioInput = driver.findElement(By.id("integerSelect"));

        for (int i = 0; i < 5; i++) {

            int randomNumber1 = (int) (Math.random() * 100);
            int randomNumber2 = (int) (Math.random() * 99) + 1;

            WebElement firstNumber = driver.findElement(By.id("number1Field"));

            if (i == 0) {
                firstNumber.sendKeys(String.valueOf(randomNumber1));
                Action action = actions.
                        moveToElement(firstNumber).
                        click().
                        keyDown(Keys.TAB).
                        keyUp(Keys.TAB).
                        sendKeys(Integer.toString(randomNumber2)).
                        build();
                action.perform();
            } else {
                Action action = actions.
                        moveToElement(firstNumber).
                        click().
                        keyDown(Keys.BACK_SPACE).
                        keyUp(Keys.BACK_SPACE).
                        keyDown(Keys.BACK_SPACE).
                        keyUp(Keys.BACK_SPACE).
                        sendKeys(Integer.toString(randomNumber1)).
                        keyDown(Keys.TAB).
                        keyUp(Keys.TAB).
                        sendKeys(Integer.toString(randomNumber2)).
                        build();
                action.perform();
                MyFunction.wait(1);

                for (int j = 0; j < 5; j++) {

                    WebElement operationMenu = driver.findElement(By.id("selectOperationDropdown"));

                    Select operationSelect = new Select(operationMenu);
                    operationSelect.selectByIndex(j);

                    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
                    calculateButton.click();

                    WebElement calculateAnswer = driver.findElement(By.id("numberAnswerField"));

                    switch (j) {
                        case 0:
                            Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf(randomNumber1 + randomNumber2));
                            break;
                        case 1:
                            Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf(randomNumber1 - randomNumber2));
                            break;
                        case 2:
                            Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf(randomNumber1 * randomNumber2));
                            break;
                        case 3:
                            integersOnlyRadioInput.click();
                            Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf((randomNumber1 / randomNumber2)));
                            break;
                        case 4:
                            Assert.assertEquals(calculateAnswer.getAttribute("value"), "" + randomNumber1 + randomNumber2);
                            break;
                    }

                    WebElement clearButton = driver.findElement(By.id("clearButton"));
                    clearButton.click();
                    MyFunction.wait(1);
                }
            }
        }
    }

    @Test
    public void scenerio2() {

        driver.get("https://www.youtube.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchBox.sendKeys("Selenium");

        Action action = actions.
                moveToElement(searchBox).
                click().
                keyDown(Keys.ENTER).
                keyUp(Keys.ENTER).
                build();
        action.perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> videos = driver.findElements(By.cssSelector(".style-scope ytd-video-renderer"));

        while (videos.size() < 80) {
            js.executeScript("window.scrollBy(0,3000);");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".style-scope ytd-video-renderer")));
            videos = driver.findElements(By.cssSelector(".style-scope ytd-video-renderer"));
        }
        videos.get(80).click();
        MyFunction.wait(3);
        System.out.println("Title = " + driver.getTitle());

        waitAndClose();
    }
}


