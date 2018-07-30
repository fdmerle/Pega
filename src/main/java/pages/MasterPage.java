package pages;

import wrappers.Driver;
import wrappers.WebObject;

/**
 * Created by Dima on 7/29/2018.
 */
public class MasterPage {

    public void doClick(Driver driver, WebObject webObject) {
        driver.getWebDriver().findElement(webObject.byObject).click();
 }


    public void enterText(Driver driver, WebObject webObject, String textToEnter){

        driver.getWebDriver().findElement(webObject.byObject).sendKeys(textToEnter);

    }
}
