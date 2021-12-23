package com.serenitydojo.todomvc.actions;

import com.serenitydojo.todomvc.pageobjects.ApplicationHomePage;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.util.List;

public class PageLayoutActions extends UIInteractionSteps {
  public String getHeading() {
    return find(ApplicationHomePage.HEADING).getText();
  }

  public List<String> getTasks(){
    return findAll(ApplicationHomePage.TASKS).textContents();
  }
}
