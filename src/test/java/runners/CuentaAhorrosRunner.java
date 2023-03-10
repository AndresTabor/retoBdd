package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/CuentaAhorros.feature"
        , glue = {"stepsdefinitions"}
        , plugin = {"pretty", "html:target/cucumber/reporte", "json:target/CuentaAhorros.json"})
public class CuentaAhorrosRunner {
}
