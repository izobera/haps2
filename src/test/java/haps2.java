import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class haps2 {
    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    //  @AfterEach
    public void driverQuit() {

        driver.quit();
    }

    /* @Test
     public void getMethod() {
         driver.get("http://haps.pl/Haps/0,0.html");
         driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click(); //aktualności
 //        Assert.assertTrue(.isDisplayed());
         driver.findElement(By.id("e1")).click();

     }
     @Test
     public void getSearch() {
         driver.get("http://haps.pl/Haps/0,0.html");
         driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
         System.out.println("IAB check");
         driver.findElement(By.xpath("//nav[@id='rwdNav']//li[@id='e2']")).click();
         System.out.println("na skróty check");
         driver.findElement(By.xpath("//nav[@id='rwdNav']//li[@id='e3']")).click();
         System.out.println("przepisy wideo check");
         driver.findElement(By.xpath("//nav[@id='rwdNav']//li[@id='e4']")).click();
         System.out.println("posiłki check");
     }

     */
// IAB Sprawdzenie czy "Zaufani Partnerzy" wysyłają cookie euconsent - druk do konsoli
    @Test
    public void getMy () {
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name=\"q\"]")).click();
        WebElement element = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        element.sendKeys("Kopytka - przepis na udany obiad. Jak je zrobić? Wyjaśniamy haps");
        element.submit();
        driver.findElement(By.xpath("//div[@class=\"r\"]/a")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"rodoNotificationWrapper\"]//a[1]")).click();
        driver.findElement(By.xpath("//div[@class=\"details_footer--1oDeu\"]//b")).click();;
        System.out.println(driver.manage().getCookieNamed("euconsent"));
        driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
        System.out.println("IAB check");
    }

    @Test
    public void getLogo() {
        driver.get("http://haps.pl/Haps/7,167251,25327475,kopytka-przepis-na-udany-obiad-jak-je-zrobic-wyjasniamy.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
        System.out.println("IAB check");
        driver.findElement(By.xpath("//div[@class='imgw']//img"));
        System.out.println("Mamy logo");
    }

    @Test
    public void getLogoP() {

        driver.get("http://haps.pl/Haps/7,167251,25327475,kopytka-przepis-na-udany-obiad-jak-je-zrobic-wyjasniamy.html");
        driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
        System.out.println("IAB check");
        driver.findElement(By.xpath("//div[@class='imgw']//img"));
        System.out.println("Mamy logo na stronie przepisu");
    }
    //belka górna gazeta.pl
    @Test
    public void getBelka() {
        driver.get("http://haps.pl/Haps/7,167251,25327475,kopytka-przepis-na-udany-obiad-jak-je-zrobic-wyjasniamy.html");
        driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
        System.out.println("IAB check");
        System.out.println(driver.findElement(By.xpath("//div[@class=\"gridWrap\"]")));
        driver.findElement(By.xpath("//div[@class=\"gridWrap\"]/ul[@class=\"c0\"]/li[@class=\"home bar\"]")).click();

    }

    //autor/awarat
    @Test
    public void getAvatar() {
        driver.get("http://haps.pl/Haps/7,167251,25327475,kopytka-przepis-na-udany-obiad-jak-je-zrobic-wyjasniamy.html");
        driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
        System.out.println("IAB check");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"author_and_date\"]"));
        System.out.println("mamy to" + elements);
    }
    //dodawanie ocen
    @Test
    public void getValue() {
        driver.get("http://haps.pl/Haps/2,170951,5d97018e4660cd00015de599,DAC_Dunajska_Streda_Cracovia,,178661860,6735.html?dfp_off=tak");
        driver.findElement(By.xpath("//div[@class=\"notify big active\"]/p")).click();
        System.out.println("IAB X");
        WebElement ValueOfStars = driver.findElement(By.xpath("//div[@class='rateRecipe__numberOfVotes']"));
        System.out.println(ValueOfStars.getText());
        driver.findElement(By.xpath("//div[@class=\"rateRecipe__button rateRecipe__button-js-openStars\"]")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class=\"rateRecipe\"]//label[@for=\"4-star\"]")).click();

    }
}
