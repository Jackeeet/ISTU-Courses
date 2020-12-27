import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.avito.ru/");

        // выбор категории
        Select categorySelect = new Select(driver.findElement(By.xpath("//select [@id='category']")));
        categorySelect.selectByVisibleText("Оргтехника и расходники");

        // поиск принтера
        driver.findElement(By.xpath("//input [@id='search']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//div [@data-marker = 'search-form/region']")).click();

        // выбор города
        WebElement cityOptions = driver.findElement(By.xpath("//input [@class='suggest-input-3p8yi']"));
        cityOptions.sendKeys("Владивосток ");
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement region = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul [@class='suggest-suggests-bMAdj']/li [@data-marker='suggest(0)']")));
        region.click();
        driver.findElement(By.xpath("//button [@data-marker='popup-location/save-button']")).click();

        // проверка и активация чекбокса
        WebElement checkbox = driver.findElement(By.xpath("//input [@data-marker='delivery-filter/input']"));
        if (!checkbox.isSelected()) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", checkbox);
        }

        // нажатие на кнопку "Показать объявления"
        WebElement submitButton = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [@data-marker='search-filters/submit-button']")));
        submitButton.click();

        // сортировка по убыванию цены
        Select filterSelect = new Select(driver.findElement(By.xpath("//div [@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")));
        filterSelect.selectByValue("2");

        // поиск предметов
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='items-items-38oUm']/div[@data-marker='item']"));
        for (int i = 0; i < 3; i++) {
            System.out.println(items.get(i).findElement(By.xpath("./div/div[@class='iva-item-body-NPl6W']/div[@class='iva-item-titleStep-2bjuh']/a/span")).getText());
            System.out.println(items.get(i).findElement(
                    By.xpath("./div/div[@class='iva-item-body-NPl6W']/div[@class='iva-item-priceStep-2qRpg']/span/span/meta[@itemprop='price']")).getAttribute("content"));
        }
        driver.quit();
    }
}