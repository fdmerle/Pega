package pages;

import wrappers.Driver;
import wrappers.WebObject;

import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by Dima on 7/29/2018.
 */
public class TestingGround extends MasterPage {


    private enum objectName {
        login,
        password,
        submit,
        loginResult,
    }

    private HashMap<objectName, WebObject> pageObjects;

    public TestingGround(Driver driver) {
        pageObjects = new HashMap<objectName, WebObject>() {
            {
                put(objectName.login, new WebObject("id", "usr"));
                put(objectName.password, new WebObject("id", "pwd"));
                put(objectName.submit, new WebObject("xpath", ".//input[@type='submit']"));
                put(objectName.loginResult, new WebObject("xpath", ".//h3[text()='%s']"));

            }
        };
    }

    public void loginToPage(Driver driver, String login, String password) {
        enterText(driver, pageObjects.get(objectName.login), login);
        enterText(driver, pageObjects.get(objectName.password), password);

    }

    public void submitLogin(Driver driver) {
        doClick(driver, pageObjects.get(objectName.submit));

    }

    public boolean loginSuccessfull(Driver driver, String value) {

        return pageObjects.
                get(objectName.loginResult).
                addStringToXpath(value).
                objectExist(driver);
    }
}


