package nana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstrukcjeWarunkowe {
    WebDriver driver;

    /*@BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://haps.pl/Haps/przepis/test?dfp_off=tak");
        driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
    }

    //public void driverQuit() {

        driver.quit();
    }*/
    @Test
    public void ifExample() {
        int liczba = 87;

        if(liczba>100) System.out.println("Liczba" + liczba + "jest większa od 100");
        System.out.println("Koniec testu");
        //WebElement pierwszyA = By.ByXPath("driver.findElement(By.xpath(\"//div[@class=\\\"top_content\\\"]//a[text()='Przegląd']\"));")
         //       if(pierwszyA = null) System.out.println(false);
    }
}
