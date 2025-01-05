package steps;
import com.codeborne.selenide.Selenide;
import common.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.BaseTest;
import static org.testng.Assert.assertTrue;

public class ButtonSteps extends BaseTest {

    PageManager pageManager=new PageManager();

    @Given("the user navigates to the {string} page")
    public void navigatesToThePage(String url) {
        Selenide.open(url);
    }

    @When("the user clicks the buttons option and click me button")
    public void clickMeButtonAndCheckMessage() {
        pageManager.buttonPage.clickButtonAndCheckMessage();
    }

    @Then("the success message should be displayed")
    public void MessageDisplayed() {
        assertTrue(pageManager.buttonPage.isMessageDisplayed(), "Message did not appear correctly!");
    }
}


