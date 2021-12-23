package com.serenitydojo.todomvc.actions;

import com.serenitydojo.todomvc.pageobjects.Pages;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class NavigateActions extends UIInteractionSteps {

  @Step("User open {0} page")
  public void to(Pages page) {
    openPageNamed(page.name());
  }

}
