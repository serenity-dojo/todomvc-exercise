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
public class DeleteTaskActions extends UIInteractionSteps {
  @Step("User delete a task with name {0}")
  public void singleTask(String taskName) throws Throwable {
    List<WebElementFacade> tasks = findAll(ApplicationHomePage.TASKS);
    Optional<WebElementFacade> selected =
        tasks.stream().filter(task -> task.getText().equals(taskName)).findAny();
    if (selected.isPresent()) {
      WebElementFacade task = selected.get();
      withAction().moveToElement(task)
          .click(task.find(ApplicationHomePage.BUTTON_DELETE_TASK))
          .perform();
    } else {
      throw new Exception("Cannot find task with name " + taskName);
    }
  }

  public void multipleTask(String... tasks) throws Throwable {
    for (String task : tasks) {
      singleTask(task);
    }
  }

  @Step("User delete all tasks")
  public void allTasks() {
    List<WebElementFacade> tasks = findAll(ApplicationHomePage.TASKS);
    for (WebElementFacade task : tasks) {
      withAction().moveToElement(task)
          .click(task.find(ApplicationHomePage.BUTTON_DELETE_TASK))
          .perform();
    }
  }
}
