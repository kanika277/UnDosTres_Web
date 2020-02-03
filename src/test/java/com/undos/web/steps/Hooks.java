package com.undos.web.steps;

import com.undos.web.util.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void BeforeScenario() {
        BrowserFactory.getInstance().openBrowser("chrome");
    }
    @After
    public void AfterScenario() {
        BrowserFactory.getInstance().closebrowser();
    }
}
