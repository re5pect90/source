package swip.ch15pageflow.pages.v1;

import org.openqa.selenium.By;
import swip.framework.Browser;

import static swip.locators.ClassName.SEARCH_BUTTON;
import static swip.locators.Id.SEARCH_INPUT;
import static swip.locators.Id.SECOND_NAVBAR;

public class BookstoreHomepage {

    private Browser browser;

    public BookstoreHomepage(Browser browser) {
        browser.get("/bookstore/");
        this.browser = browser;
    }

    public void searchBook(String bookname) {
        browser.setInputText(SEARCH_INPUT, bookname);
        browser.untilFound(SECOND_NAVBAR)
            .untilFound(SEARCH_BUTTON).click();
        browser.untilFound(() -> By.partialLinkText(bookname))
            .click();
    }

}