package com.serenitydojo.todomvc.acceptancetests;

import com.serenitydojo.todomvc.actions.*;
import com.serenitydojo.todomvc.pageobjects.Pages;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yunaz.ramadhan on 12/23/2021
 */
@RunWith(SerenityParameterizedRunner.class)
@Concurrent
@UseTestDataFrom("data/tasks.csv")
public class DisplayTasksTest {
  private final String separator = "\\|";
  @Managed
  WebDriver driver;
  @Steps
  NavigateActions navigate;
  @Steps
  AddTaskActions adding;
  @Steps
  FilterTaskActions filter;
  @Steps
  CompletingTaskActions completing;
  PageLayoutActions pageLayout;
  private String tasks;
  private String filterType;
  private String completedTasks;
  private String visibleTasks;

  @Qualifier
  public String qualifier() {
    if (filterType.equalsIgnoreCase("all")) {
      return "Filtering " + filterType + " tasks, should display all tasks";
    } else {
      return "Filtering " + filterType + " tasks, should display " + normalizeParametersToString(
          splitTestDataToList(visibleTasks));
    }
  }

  @Test
  public void displayCorrectTasksList() throws Throwable {
    navigate.to(Pages.todomvc);
    adding.multipleTasks(splitTestDataToList(tasks));
    Serenity.reportThat("All tasks should be added",
        () -> assertThat(pageLayout.getTasks()).containsExactly(splitTestDataToList(tasks)));
    completing.multipleTask(splitTestDataToList(completedTasks));
    filter.show(filterType);
    Serenity.reportThat("Should display correct tasks list",
        () -> assertThat(pageLayout.getTasks()).containsExactlyInAnyOrder(splitTestDataToList(
            visibleTasks)));
  }

  private String[] splitTestDataToList(String input) {
    return input.split(separator);
  }

  private String normalizeParametersToString(String... inputs) {
    StringBuilder builder = new StringBuilder();
    String separator = "&";
    for (int i = 0; i < inputs.length; i++) {
      builder.append(inputs[i]);
      if (i < inputs.length - 1) {
        builder.append(separator);
      }
    }
    return builder.toString();
  }
}
