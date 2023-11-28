package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.Objects;

public class TopMenuTest extends Utility {

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']"));
        for (WebElement element : topMenuList) {
            if (Objects.equals(element.getText(), menu)) {
                clickOnElement(By.xpath("//div[@class = 'dropdown-menu']//a[normalize-space()='" + menu + "']"));
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on “Desktops” Tab and click
        sleep(2);
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        sleep(2);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //1.3 Verify the text ‘Desktops’
        verifyElements("Verify the text ‘Desktops’", "Desktops", By.tagName("h2"));
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        sleep(2);
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        sleep(2);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyElements("Verify the text ‘Laptops & Notebooks’", "Laptops & Notebooks", By.tagName("h2"));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        //3.1 Mouse hover on “Components” Tab and click
        sleep(2);
        mouseHoverToElement(By.xpath("//a[normalize-space()='Components']"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        sleep(2);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
        //3.3 Verify the text ‘Components’
        verifyElements("3.3 Verify the text ‘Components’", "Components", By.tagName("h2"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
