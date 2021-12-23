package com.serenitydojo.todomvc.acceptancetests;

import com.serenitydojo.todomvc.actions.*;
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
public class WhenCompletingATask {
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

  @Test
  public void activeTasksShouldNotShowCompletedTasks() throws Throwable {
    String completedTask = "Feed the cat";
    String[] tasks = new String[] {completedTask, "Walk the dog", "Wash the laundry"};
    navigate.to(Pages.todomvc);
    adding.multipleTasks(tasks);
    Serenity.reportThat("All tasks should be added",
        () -> assertThat(pageLayout.getTasks()).containsExactly(tasks));
    completing.singleTask(completedTask);
    filter.show("Active");
    Serenity.reportThat("Completed tasks should not be visible in active task",
        () -> assertThat(pageLayout.getTasks()).doesNotContain(completedTask));
  }

  @Test
  public void completedTasksShouldNotShowActiveTasks() throws Throwable {
    String activeTask = "Feed the cat";
    String[] tasks = new String[] {activeTask, "Walk the dog", "Wash the laundry"};
    navigate.to(Pages.todomvc);
    adding.multipleTasks(tasks);
    Serenity.reportThat("All tasks should be added",
        () -> assertThat(pageLayout.getTasks()).containsExactly(tasks));
    completing.singleTask(tasks[1]);
    completing.singleTask(tasks[2]);
    filter.show("Completed");
    Serenity.reportThat("Active tasks should not be visible in completed task",
        () -> assertThat(pageLayout.getTasks()).doesNotContain(activeTask));
  }
}
