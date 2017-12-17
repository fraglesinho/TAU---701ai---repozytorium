package pl.kosmala.tau.labfive.test.java.pl.seleniumpage.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/"
)
public class CucuberTest {}
