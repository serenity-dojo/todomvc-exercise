package com.serenitydojo.todomvc.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class PageLayoutActions extends UIInteractionSteps {
    public String getHeading() {
        return find(ApplicationHomePage.HEADING).getText();
    }
}
