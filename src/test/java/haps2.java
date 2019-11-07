import com.sun.org.apache.xpath.internal.objects.XBoolean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.xml.bind.Element;
import java.util.List;
import java.util.NoSuchElementException;
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

    void wypiszTekst(String tekst){
        System.out.println(tekst);
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
        driver.get("http://haps.pl/Haps/2,170951,5da6e705980cbd00016a0db2,DAC_Dunajska_Streda_Cracovia,,178661860,6735.html?dfp_off=tak");
        driver.findElement(By.xpath("//div[@class=\"notify big active\"]/p")).click();
        System.out.println("IAB X");
        WebElement ValueOfStars = driver.findElement(By.xpath("//div[@class='rateRecipe__numberOfVotes']"));
        System.out.println(ValueOfStars.getText());
        driver.findElement(By.xpath("//div[@class=\"rateRecipe__button rateRecipe__button-js-openStars\"]")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class=\"rateRecipe\"]//label[@for=\"4-star\"]")).click();

    }

    //PT 10 Wyświetlanie belki potrawy zgodnie z sekcjami użytymi - test działa tylko jeśli wszystkie pola występują
    @Test
    public void getSSpecial() {
        driver.get("http://haps.pl/Haps/przepis/test?dfp_off=tak");
        driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
        System.out.println("IAB check");
        driver.findElement(By.xpath("//div[@class=\"top_content\"]//a[text()='Przegląd']"));
        driver.findElement(By.xpath("//div[@class=\"preparationInfo\"]"));
        System.out.println("Przegląd jest");
        driver.findElement(By.xpath("//div[@class=\"top_content\"]//a[text()='Składniki']"));
        driver.findElement(By.xpath("//div[@class=\"preparationSteps\"]//strong[text()='Składniki']"));
        System.out.println("Składniki są");
        driver.findElement(By.xpath("//div[@class=\"top_content\"]//a[text()='Kroki']"));
        driver.findElement(By.xpath("//div[@class=\"preparationSteps\"]//h3[text()='SPOSÓB PRZYGOTOWANIA']"));
        System.out.println("Kroki są");
        driver.findElement(By.xpath("//div[@class=\"top_content\"]//a[text()='Wartości odżywcze']"));
        driver.findElement(By.xpath("//div[@class=\"preparationSteps__col1\"]//h3[@class=\"nutritionalValues__title\"]"));
        System.out.println("Wartości są");
        driver.findElement(By.xpath("//div[@class=\"top_content\"]//a[text()='Komentarze']"));
        driver.findElement(By.xpath("//div[@class=\"content_wrap\"]//span[@class=\"head\"]"));
        System.out.println("Komentarze są");
        wypiszTekst("Koniec testu nananana");

        }
        @Test
                public void myTest() {
            driver.get("http://haps.pl/Haps/przepis/test?dfp_off=tak");
            driver.findElement(By.xpath("//div[@class='buttonBox']//button")).click();
            System.out.println("IAB check");
            WebElement pierElem = driver.findElement(By.xpath("//div[@class=\"top_content\"]//a[text()='Przegląd']"));
            WebElement pierElemB = driver.findElement(By.xpath("//div[@class=\"preparationInfo\"]"));
            private boolean czyNana() /= null;
            System.out.println("true");
            sprawdz = pierElem + pierElemB;

        }
        boolean czyNana()
    }



