package swip.ch17datepicker.jquerydatepicker.v0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import swip.ch15pageflow.v2.framework.Browser;

import java.time.Month;
import java.util.Calendar;


public class BetterDatepicker {

    private final Browser browser;
    private WebElement datepicker;

    public BetterDatepicker(Browser driver) {
        this.browser = driver;
    }


    public void pickDate(Calendar date) {
        show();
        pickYear(date.get(Calendar.YEAR));
        pickMonth(date.get(Calendar.MONTH));
        pickDay(date.get(Calendar.DAY_OF_MONTH));
    }

    public String getDate() {
        return browser.findElement(By.id("datepicker")).getAttribute("value");
    }


    private void show() {
        WebElement element = browser.findElement(By.id("datepicker"));
        element.click();
    }

    private void pickYear(int yearToPick) {
        String year;
        datepicker = browser.findElement(By.id("ui-datepicker-div"));
        year = datepicker.findElement(By.className("ui-datepicker-year"))
            .getText();

        if (Integer.parseInt(year) < yearToPick) {
            while (Integer.parseInt(year) != yearToPick) {
                datepicker.findElement(By.className("ui-datepicker-next")).click();
                datepicker = browser.findElement(By.id("ui-datepicker-div"));
                year = datepicker.findElement(By.className("ui-datepicker-year"))
                    .getText();
            }
        } else if (Integer.parseInt(year) > yearToPick) {
            while (Integer.parseInt(year) != yearToPick) {
                datepicker.findElement(By.className("ui-datepicker-prev")).click();
                datepicker = browser.findElement(By.id("ui-datepicker-div"));
                year = datepicker.findElement(By.className("ui-datepicker-year"))
                    .getText();
            }
        }
    }

    private void pickMonth(int monthToPick) {
        String month = datepicker.findElement(By.className("ui-datepicker-month")).getText();
        if (Month.valueOf(month.toUpperCase()).ordinal() < monthToPick) {
            while (Month.valueOf(month.toUpperCase()).ordinal() != monthToPick) {
                datepicker.findElement(By.className("ui-datepicker-next")).click();
                datepicker = browser.findElement(By.id("ui-datepicker-div"));
                month = datepicker.findElement(By.className("ui-datepicker-month")).getText();
            }
        } else if (Month.valueOf(month.toUpperCase()).ordinal() > monthToPick) {
            while (Month.valueOf(month.toUpperCase()).ordinal() != monthToPick) {
                datepicker.findElement(By.className("ui-datepicker-prev")).click();
                datepicker = browser.findElement(By.id("ui-datepicker-div"));
                month = datepicker.findElement(By.className("ui-datepicker-month")).getText();
            }
        }
    }

    private void pickDay(int dayToPick) {
        browser.findElement(By.id("ui-datepicker-div"))
            .findElement(By.linkText(String.valueOf(dayToPick))).click();

        new FluentWait<>(browser).until(
            (Browser b) -> b.findElements(By.id("ui-datepicker-div")).size() == 0 ||
                !b.findElements(By.id("ui-datepicker-div")).get(0).isDisplayed()
        );
    }
}