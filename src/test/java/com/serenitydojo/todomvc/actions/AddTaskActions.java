package com.serenitydojo.todomvc.actions;

import com.serenitydojo.todomvc.pageobjects.ApplicationHomePage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

/**
 * @author yunaz.ramadhan on 12/23/2021
 */
public class AddTaskActions extends UIInteractionSteps {
  @Step("User add a task {0}")
  public void singleTask(String task) {
    find(ApplicationHomePage.INPUT_NEW_TASK).typeAndEnter(task);
  }

  public void multipleTasks(String... tasks) {
    for (String task : tasks) {
      singleTask(task);
    }
  }
}
