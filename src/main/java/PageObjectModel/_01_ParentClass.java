package PageObjectModel;

import Utilities.Driver;
import gherkin.lexer.Th;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class _01_ParentClass {

//    In this class we need two thinks one is driver second one is a WebDriverWait

    WebDriver driver;
    WebDriverWait wait;

    public _01_ParentClass(){

        driver = Driver.getDriver();
        wait = new WebDriverWait(driver,10);

    }

//    Click on element method
    public void clickFunction(WebElement element){

        waitUntilVisible(element);
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();

    }

//    Send keys function
    public void sendKeysFunction(WebElement element , String value){

        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);

    }

//    Waiting until element become visible
    public void waitUntilVisible(WebElement elementToWait){

        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }
    public void waitUntilAllElementVisible(List<WebElement> webElementListToWait){

        wait.until(ExpectedConditions.visibilityOfAllElements(webElementListToWait));

    }


//    WaitForClickable
    public void waitUntilClickable(WebElement elmentToWait){

//        wait until clickable is working as if the element is not visible
        wait.until(ExpectedConditions.elementToBeClickable(elmentToWait));
    }

//  Verify element is contains specific text
    public void ElementContainsText(WebElement element , String myText){

        waitUntilVisible(element);
        Assert.assertTrue(element.getText().contains(myText));


    }

    public void waiting(int howLong){
        try {
            Thread.sleep(howLong);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
    }

    public void scrollToElement(WebElement elementToScroll){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", elementToScroll);
    }

    public void clickOnElementInTheDropdown(List<WebElement> list, String whichOption){
        scrollToElement(list.get(list.size()-1));
        for(int i = 0 ; i<list.size() ; i++){
            if(list.get(i).getText().equalsIgnoreCase(whichOption)){
             list.get(i).click();
                break;
            }

        }

    }

    protected void clickOnTheLastElement(List<WebElement> list){
        scrollToElement(list.get(list.size()-1));

        list.get(list.size()-1).click();
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public void clickOnRandomElementInTheDropdown(List<WebElement> webElementList){
        Random random = new Random();
        int index = random.nextInt(webElementList.size());
        webElementList.get(index).click();
    }



}
