package com.serenitydojo.todomvc.actions;

import com.serenitydojo.todomvc.pageobjects.ApplicationHomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Optional;

/**
 * @author yunaz.ramadhan on 12/23/2021
 */
public class FilterTaskActions extends UIInteractionSteps {
  @Step("User choose to show {0} task")
  public void show(String type) throws Throwable {
    List<WebElementFacade> filters = findAll(ApplicationHomePage.FILTERS);
    Optional<WebElementFacade> selected =
        filters.stream().filter(filter -> filter.getText().equals(type)).findAny();
    if (selected.isPresent()) {
      selected.get().click();
    } else {
      throw new Exception("Cannot find filter with type " + type);
    }
  }
}
