package swip.locators;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

/**
 * This enum is a Supplier of ById from Selenium By API.
 */
public enum ReactByXpath implements Supplier<By> {

    TRIGGER_BY("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/input");

    private final By by;

    ReactByXpath(String id) {
        this.by = xpath(id);
    }

    /**
     * @return the by instance variable which is a ById.
     */
    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}