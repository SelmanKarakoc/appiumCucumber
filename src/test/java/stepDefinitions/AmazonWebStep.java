package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.BrowserDriver;
import utilities.ConfigReader;

public class AmazonWebStep {
    @Given("Kullanici istenilen {string} e gider")
    public void kullanici_istenilen_e_gider(String url) {
        BrowserDriver.getBrowserDriver().get(ConfigReader.getProperty(url));
    }

}
