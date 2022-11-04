package task30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindLocatorClass {

    public WebElement getWebElementByLocatorParameter(WebDriver webDriver,LocationByType type, String locatorParameter)
    {
        WebElement element = null;
        switch (type)
        {
            case ID:
            element = webDriver.findElement(By.id(locatorParameter));
            case CLASS:
                element = webDriver.findElement(By.className(locatorParameter));
                break;
            case NAME:
                element = webDriver.findElement(By.name(locatorParameter));
                break;
            case TAGNAME:
                element = webDriver.findElement(By.tagName(locatorParameter));
                break;
            case LINK:
                element = webDriver.findElement(By.linkText(locatorParameter));
                break;
            case PARTIALLINK:
                element = webDriver.findElement(By.partialLinkText(locatorParameter));
                break;
            case CSS:
                element = webDriver.findElement(By.cssSelector(locatorParameter));
                break;
            case XPATH:
                element = webDriver.findElement(By.xpath(locatorParameter));
                break;
            default:
                System.out.println("Wrong location type");
        }
        return element;
    }
}
