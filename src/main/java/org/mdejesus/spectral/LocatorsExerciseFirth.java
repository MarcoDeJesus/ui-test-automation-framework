package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LocatorsExerciseFirth {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.mx/");

        WebElement elementDropdown = driver.findElement(By.id("searchDropdownBox"));
        Select searchDropdown = new Select(elementDropdown);

        for (WebElement option: searchDropdown.getOptions()) {
            System.out.println(option.getText());
        }

        System.out.println(searchDropdown.isMultiple() ? "It's Multiple Dropdown." : "It's not Multiple Dropdown.");

        System.out.println("The first selected option is: " + searchDropdown.getFirstSelectedOption().getText());

        elementDropdown.click();
        searchDropdown.selectByIndex(0);

        elementDropdown.click();
        Thread.sleep(2000);
        searchDropdown.selectByValue("search-alias=automotive");

        for(WebElement selectedOption : searchDropdown.getAllSelectedOptions()){
            System.out.println("SELECTED OPTIONS: " + selectedOption.getText());
        }

        driver.quit();
    }
}
