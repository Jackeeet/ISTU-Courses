package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.net.URLEncoder;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

public class Definitions {
    static WebDriver driver;
    static WebElement cityOptions, checkbox;
    static Wait<WebDriver> fluentWait;

    @Before
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Пусть("открыт ресурс авито")
    public static void getAvito() {
        driver.get("https://www.avito.ru/");
    }

    @И("в выпадающем списке категорий выбрана {itemCategory}")
    public static void setCategory(ItemCategories category) {
        Select categorySelect = new Select(driver.findElement(By.xpath("//select [@id='category']")));
        categorySelect.selectByValue(category.value);
    }

    @И("в поле поиска введено значение {word}")
    public static void enterItem(String itemName) {
        driver.findElement(By.xpath("//input [@id='search']")).sendKeys(itemName);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public static void clickRegion() {
        driver.findElement(By.xpath("//div [@data-marker = 'search-form/region']")).click();
    }

    @Тогда("в поле регион введено значение {word}")
    public static void enterRegion(String region) {
        cityOptions = driver.findElement(By.xpath("//input [@class='suggest-input-3p8yi']"));
        cityOptions.sendKeys(region);
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement regionOption = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul [@class='suggest-suggests-bMAdj']/li [@data-marker='suggest(0)']")));
        regionOption.click();
    }

    @И("нажата кнопка показать объявления")
    public static void clickRegionItems() {
        driver.findElement(By.xpath("//button [@data-marker='popup-location/save-button']")).click();
    }

    // не очень понятно, что именно здесь должно происходить, т. к. страница открывается автоматически
    // поэтому я решила проверить, что url открывшейся страницы
    // содержит введенное в поисковую строку слово
    @Тогда("открылась страница результаты по запросу {word}")
    public static void showPage(String pageName) throws Exception {
        String url = driver.getCurrentUrl();
        String encodedPageName = URLEncoder.encode(pageName, "UTF-8");

        Pattern pattern = Pattern.compile(encodedPageName);
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find()) {
            throw new Exception("url открытой страницы не соответствует ожидаемому");
        }
    }

    // чекбокса "только с фотографией" на странице нет, поэтому
    // активируется чекбокс "с Авито доставкой"
    @И("активирован чекбокс с авито доставкой")
    public static void activateCheckbox() {
        checkbox = driver.findElement(By.xpath("//input [@data-marker='delivery-filter/input']"));
        if (!checkbox.isSelected()) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", checkbox);
        }
        WebElement submitButton = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [@data-marker='search-filters/submit-button']")));
        submitButton.click();
    }

    @И("в выпадающем списке сортировка выбрано значение {sortOption}")
    public static void setSortOption(SortOptions option) {
        Select filterSelect = new Select(driver.findElement(By.xpath("//div [@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")));
        filterSelect.selectByValue(option.value);
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public static void printItems(Integer itemCount) {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='items-items-38oUm']/div[@data-marker='item']"));
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items.get(i).findElement(By.xpath("./div/div[@class='iva-item-body-NPl6W']/div[@class='iva-item-titleStep-2bjuh']/a/span")).getText());
            System.out.println(items.get(i).findElement(
                    By.xpath("./div/div[@class='iva-item-body-NPl6W']/div[@class='iva-item-priceStep-2qRpg']/span/span/meta[@itemprop='price']")).getAttribute("content"));
        }
    }

    @After
    public static void after() {
        driver.quit();
    }

    @ParameterType(".*")
    public ItemCategories itemCategory(String category) {
        return ItemCategories.valueOf(category);
    }

    @ParameterType(".*")
    public SortOptions sortOption(String option) {
        return SortOptions.valueOf(option);
    }
}
