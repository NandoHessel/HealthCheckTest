package br.sp.fernandohessel.tasks.prod;

import org.hamcrest.core.StringStartsWith;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HealthCheckIT {

    WebDriver driver = new ChromeDriver();

    private By text = By.id("version");

    @Test
    public void HealthChech() {
        try {
            //Acessar o endereço
            driver.navigate().to("http://localhost:9999/tasks/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String build = driver.findElement(text).getText();

            Assert.assertTrue(build.startsWith("build"));
        } finally {
            driver.quit();
        }


    }
}
