package com.serenitydojo.todomvc.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class Navigate extends UIInteractionSteps {

    public void toTheTodoMVCnHomePage() {
        openUrl("http://todomvc.com/examples/react/#/");
    }
}
