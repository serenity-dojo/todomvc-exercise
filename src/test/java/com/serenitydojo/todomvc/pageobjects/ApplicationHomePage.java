package com.serenitydojo.todomvc.pageobjects;

import org.openqa.selenium.By;

public class ApplicationHomePage {
  public static final By HEADING = By.cssSelector(".header h1");
  public static final By INPUT_NEW_TASK = By.cssSelector("input.new-todo");
  public static final By TASKS = By.cssSelector("ul.todo-list > li");
  public static final By BUTTON_COMPLETE_TASK = By.cssSelector("input.toggle");
  public static final By BUTTON_DELETE_TASK = By.cssSelector("button.destroy");
  public static final By FILTERS = By.cssSelector("ul.filters > li > a");
}
