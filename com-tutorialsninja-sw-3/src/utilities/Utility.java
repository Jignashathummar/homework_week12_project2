package utilities;
/**
 * Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in it’
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * Click on checkbox with condition
     */
    public void clickOnCheckBoxAndRadioButton(By by) {
        WebElement element = driver.findElement(by);
        if (!element.isSelected()) {
            element.click();
        }
    }


    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
        /*WebElement emailfield = driver.findElement(by);
        emailfield.sendKeys(text);*/
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        /*WebElement webElement = driver.findElement(by);
        String text = webElement.getText();
        return text;*/
        return driver.findElement(by).getText();
    }

    //******************************** DropDown Menu Without Select Tag ********************************************//
    public void dropDownWithList(By by, String option) {
        List<WebElement> list = driver.findElements(by);
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }
    //*************************** Select Class Methods ***************************************//

    /**
     * Select dropdown using value
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //Create an object of select class
        Select select = new Select(dropDown);
        //Select by value
        select.selectByValue(value);
    }

    /**
     * Select dropdown using text
     */

    public void selectByVisibleTextFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //Create an object of select class
        Select select = new Select(dropDown);
        //Select by value
        select.selectByVisibleText(value);
    }

    /**
     * Select dropdown using Index
     */
    public void selectByIndexFromDropDown(By by, Integer value) {
        WebElement dropDown = driver.findElement(by);
        //Create an object of select class
        Select select = new Select(dropDown);
        //Select by value
        select.selectByIndex(value);
    }

    /**
     * Verify that list is in decending order
     */
    public boolean verifyTheListIsDescendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isDescending = true;

        for (int i = 0; i < list.size() - 1; i++) {
             System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) {
                System.out.println("SAI");
                isDescending = false;
            }
        }
        return isDescending;
    }

    /**
     * Verify that list is in Ascending order
     */
    public boolean verifyTheListIsAscendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAscending = true;

        for (int i = 0; i < list.size() - 1; i++) {
            // System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAscending = false;
            }
        }
        return isAscending;
    }

    //*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will use to Verify Actual and Expected Result
     */
    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    public void verifyElements(String displayMessage, String expectedMessage, String actualValue) {
        Assert.assertEquals(displayMessage, expectedMessage, actualValue);
    }

    /**
     * Clear webElement
     */

    public void clearElement(By by) {
        driver.findElement(by).clear();
    }

    public void sleep(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
