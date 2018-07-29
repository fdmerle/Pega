package pages;

import wrappers.Driver;
import wrappers.WebObject;

/**
 * Created by Dima on 7/29/2018.
 */
public class MasterPage {

    public void doClick(Driver driver, WebObject webObject) {
        driver.waitToBeClickable(webObject.byObject, 10);
        driver.getWebDriver().findElement(webObject.byObject).click();
 }


    public void enterText(Driver driver, WebObject webObject, String textToEnter){

        driver.waitElementToBeVisible(webObject.objectValue,10);
        driver.getWebDriver().findElement(webObject.byObject).sendKeys(textToEnter);

    }
}
