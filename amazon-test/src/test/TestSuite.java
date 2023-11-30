package test;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;

public class TestSuite extends Utility {

    @Before
    public void openBrowser() {
        //Open the url https://www.amazon.co.uk/
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductNameAndSize() throws InterruptedException {
        sleep(10);
        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.id("twotabsearchtextbox"),"Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        //3. Click on the checkbox brand Dell on the left side
        clickOnCheckBoxAndRadioButton(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        sleep(2);
        List<String> getList = getList(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        //4. Verify that the  30(May be different) products are displayed on the page.
        verifyElements("Verify that the  30(May be different) products are displayed on the page.", "24",String.valueOf(getList.toArray().length));
        //5, Print all product names in the console.
        System.out.println(getList);
        //6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
        clickOnElement(By.xpath("//span[normalize-space()='Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver']"));
        //7. Varify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
        verifyElements("Varify the Product name 'Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...", "Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver", By.xpath("//span[@id='productTitle']"));
    }

    @After
    public void terminate() {
        //Close the Browser.
        closeBrowser();
    }
}
