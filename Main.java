import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\duz30\\OneDrive\\Рабочий стол\\veb driver\\chromedriver_win32\\chromedriver.exe");
        int big = 0;

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            for (int i = 0; i < 10; i++) {


            driver.get("https://mozgion.ru/test-trenazher-na-skorost-reakcii/");
            Thread.sleep(1000);
            WebElement element = driver.findElement(By.xpath("/html/body/main/article/div[2]/div[1]"));
            Actions actions = new Actions(driver);

            for (int a = 0; a < 5; a++) {
                Thread.sleep(500);
                actions.scrollByAmount(1,9999);
                actions.moveToElement(element).click().build().perform();
                wait.until(ExpectedConditions.textToBePresentInElement(element,"Кликайте!"));
                actions.moveToElement(element).click().build().perform();
            }
            WebElement element2 = driver.findElement(By.xpath("/html/body/main/article/div[2]/div[1]/div/div[6]/span[1]/span"));
            String result = element2.getText();
            int full = Integer.parseInt(result);
            big = big+ full;

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Thread.sleep(500);
            driver.quit();
        }

        System.out.println("Средний результат для 'textToBePresentInElement': " + big/10);



    }
}


