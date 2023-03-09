package homework._06_Selenium_08_03_2023;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;
import utility.MyFunc;

public class Tests extends BaseDriver {
    @Test
    public void scenerio1() {

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        Actions actions = new Actions(driver);

        int randomNumber1 = (int) (Math.random() * 100);
        int randomNumber2 = (int) (Math.random() * 100);

        WebElement firstNumber = driver.findElement(By.id("number1Field"));
        firstNumber.sendKeys(String.valueOf(randomNumber1));

        Action action = actions.
                moveToElement(firstNumber).
                click().
                keyDown(Keys.TAB).
                keyUp(Keys.TAB).
                sendKeys(Integer.toString(randomNumber2)).
                build();
        action.perform();
        for (int i = 0; i < 5; i++) {
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
                        Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf(((double) randomNumber1 / (double) randomNumber2)));
                        break;
                    case 4:
                        Assert.assertEquals(calculateAnswer.getAttribute("value"), "" + randomNumber1 + randomNumber2);
                        break;
                }

                WebElement clearButton = driver.findElement(By.id("clearButton"));
                clearButton.click();
                MyFunc.bekle(1);
            }
        }
    }
    @Test
    public void scenerio2() {
        System.out.println("deneme");
        System.out.println("deneme");
        System.out.println("deneme");
        System.out.println("deneme");
        System.out.println("deneme");
        System.out.println("deneme");
        System.out.println("deneme");
        System.out.println("deneme");
    }
}


