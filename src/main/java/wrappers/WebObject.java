package wrappers;

import org.openqa.selenium.By;

/**
 * Created by Dima on 7/29/2018.
 */
public class WebObject {
    public String objectType;
    public String objectValue;
    public By byObject;
    public String objectValueOrig;

    public WebObject(String objType, String objValue) {
        objectType = objType;
        objectValue = objValue;
        switch (objType) {
            case "xpath":
                byObject = By.xpath(objValue);
            case "id":
                byObject = By.id(objValue);
            default:
                break;
        }
        objectValueOrig = objectValue;
    }

    public int returnObjectAmount(Driver driver) {

        return driver.getWebDriver().findElements(byObject).size();

    }

    public WebObject addStringToXpath(String value) {
        objectValue = objectValueOrig;
        String.format(objectValue, value);
        return this;
    }

    public boolean objectExist(Driver driver) {
        return driver.getWebDriver().findElements(byObject).size() > 0;
    }
}
