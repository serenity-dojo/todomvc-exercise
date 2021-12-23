package com.serenitydojo.todomvc.acceptancetests;

import com.serenitydojo.todomvc.actions.AddTaskActions;
import com.serenitydojo.todomvc.actions.NavigateActions;
import com.serenitydojo.todomvc.actions.PageLayoutActions;
import com.serenitydojo.todomvc.pageobjects.Pages;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yunaz.ramadhan on 12/23/2021
 */
@RunWith(SerenityRunner.class)
public class WhenAddingTasks {
  @Managed
  WebDriver driver;

  @Steps
  NavigateActions navigate;

  @Steps
  AddTaskActions adding;

  PageLayoutActions pageLayout;

  @Test
  public void addingASingleTask() {
    String task = "Feed the cat";
    navigate.to(Pages.todomvc);
    adding.singleTask(task);
    Serenity.reportThat("New task should be added",
        () -> assertThat(pageLayout.getTasks()).contains(task));
  }

  @Test
  public void addingMultipleTasks() {
    String[] tasks = new String[] {"Feed the cat", "Walk the dog", "Wash the laundry"};
    navigate.to(Pages.todomvc);
    adding.multipleTasks(tasks);
    Serenity.reportThat("All tasks should be added",
        () -> assertThat(pageLayout.getTasks()).containsExactly(tasks));
  }
}
