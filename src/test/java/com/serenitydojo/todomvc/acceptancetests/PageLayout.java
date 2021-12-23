package com.serenitydojo.todomvc.acceptancetests;

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

@RunWith(SerenityRunner.class)
public class PageLayout {

  @Managed
  WebDriver driver;

  @Steps
  NavigateActions navigate;

  PageLayoutActions pageLayout;

  @Test
  public void shouldShowTheTitleOnTheApplicationHomePage() {
    navigate.to(Pages.todomvc);
    Serenity.reportThat("User should see page display correct heading",
        () -> assertThat(pageLayout.getHeading()).isEqualTo("todos"));
  }
}
