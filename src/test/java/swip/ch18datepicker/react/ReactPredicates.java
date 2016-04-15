package swip.ch18datepicker.react;

import swip.framework.Element;
import swip.framework.ExplicitWait;

import java.util.Optional;
import java.util.function.Predicate;

import static swip.locators.ReactByClassName.CALENDAR;

public enum ReactPredicates implements Predicate<ExplicitWait> {

    CALENDAR_CLOSED {
        @Override
        public boolean test(ExplicitWait explicitWait) {
            Optional<Element> element = explicitWait.optionalElement(CALENDAR);
            return !element.isPresent() || !element.get().isDisplayed();
        }
    }

}
