package com.serenitydojo.todomvc.acceptancetests;

import com.serenitydojo.todomvc.actions.Navigate;
import com.serenitydojo.todomvc.actions.PageLayoutActions;
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
    Navigate navigate;

    PageLayoutActions pageLayout;

    @Test
    public void shouldShowTheTitleOnTheApplicationHomePage() {
        navigate.toTheTodoMVCnHomePage();
        assertThat(pageLayout.getHeading()).isEqualTo("todos");
    }
}
