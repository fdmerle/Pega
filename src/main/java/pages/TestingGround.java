package pages;

import wrappers.Driver;
import wrappers.WebObject;

import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by Dima on 7/29/2018.
 */
public class TestingGround {
    private enum objectName {
        login,
        password,
        submit,
        loginResult
    }

    private HashMap<objectName, WebObject> pageObjects;

    public TestingGround(Driver driver) {
        pageObjects = new HashMap<objectName, WebObject>() {
            {
                put(objectName.login, new WebObject("xpath", ""));
                put(objectName.password, new WebObject("xpath", ""));
                put(objectName.submit, new WebObject("xpath", ""));
                put(objectName.loginResult, new WebObject("xpath", ""));
            }
        };


    }

}
