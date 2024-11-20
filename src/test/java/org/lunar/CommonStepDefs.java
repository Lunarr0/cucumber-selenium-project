package org.lunar;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonStepDefs extends AbstractStepDefs {

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @Given("the {string} field is filled with {string}")
    public void theFieldIsFilledWithText(String field, String text) {
        homePage.fillOutField(field, text);
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String button) {
        homePage.clickButton(button);
    }

    @AfterAll
    public static void cleanUp() {
        homePage.closePage();
    }

    @Then("the {string} message is shown")
    public void theErrorMessageMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getErrorMessage());
    }
}
