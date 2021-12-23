package com.serenitydojo.todomvc.acceptancetests;

import com.serenitydojo.todomvc.actions.AddTaskActions;
import com.serenitydojo.todomvc.actions.DeleteTaskActions;
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
public class WhenDeletingATask {
  @Managed
  WebDriver driver;

  @Steps
  NavigateActions navigate;

  @Steps
  AddTaskActions adding;

  @Steps
  DeleteTaskActions delete;

  PageLayoutActions pageLayout;

  @Test
  public void deletedItemsShouldDissapearFromTheList() throws Throwable {
    String deletedTask = "Feed the cat";
    String[] tasks = new String[] {deletedTask, "Walk the dog", "Wash the laundry"};
    navigate.to(Pages.todomvc);
    adding.multipleTasks(tasks);
    Serenity.reportThat("All tasks should be added",
        () -> assertThat(pageLayout.getTasks()).containsExactly(tasks));
    delete.singleTask(deletedTask);
    Serenity.reportThat("Deleted tasks should dissapear from the list",
        () -> assertThat(pageLayout.getTasks()).doesNotContain(deletedTask));
  }
}
