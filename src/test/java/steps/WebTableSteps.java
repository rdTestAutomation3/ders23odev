package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import common.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import tests.BaseTest;

public class WebTableSteps extends BaseTest {

    PageManager pageManager=new PageManager();

    @Given("The user navigateweb to the {string} page")
    public void theUserNavigatewebToTheHttpsDemoqaComWebtablesPage(String url) {
        Selenide.open(url);
    }

    @When("the user adds a new record with first name {string}, last name {string}, email {string}, age {string}, salary {string}, and department {string}")
    public void userAddNewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        pageManager.webTablePage.addButton().click();
        pageManager.webTablePage.firstNameInput().sendKeys(firstName);
        pageManager.webTablePage.lastNameInput().sendKeys(lastName);
        pageManager.webTablePage.userEmailInput().sendKeys(email);
        pageManager.webTablePage.ageInput().sendKeys(age);
        pageManager.webTablePage.salaryInput().sendKeys(salary);
        pageManager.webTablePage.departmentInput().sendKeys(department);
        pageManager.webTablePage.submitButton().click();

    }


    /*  @Then("the new record should appear in the table with name {string}")
    public void shouldAppearInTheTable(String name) {
        pageManager.webTablePage.waitForRecord(name);
        Assert.assertTrue(Selenide.$("div.rt-tbody").getText().contains(name), name + " should be visible in the table.");
    }
    */
   /* @Then("the new record should appear in the table with name {string}")
    public void shouldAppearInTheTable(String name) {
        pageManager.webTablePage.waitForRecord(name);  // Bu metodun doğru şekilde çalıştığından emin olun
        SelenideElement record = Selenide.$(By.xpath("//div[@class='rt-tbody']//div[contains(text(), '" + name + "')]"));
        Assert.assertTrue(record.exists(), name + " should be visible in the table.");
    }*/


    @When("the user edits the record with name {string} and updates the first name to {string}")
    public void editTheRecord(String oldName, String newFirstName) {
        // 1. Kaydı Bul ve Düzenleme Butonuna Tıkla
        // Kaydın bulunduğu satırı bulmak için dinamik XPath kullanabiliriz.
        SelenideElement editButton = Selenide.$(By.xpath("//div[@class='rt-tbody']//div[text()='" + oldName + "']//following-sibling::div//span[contains(@id,'edit-record')]"));

        // 2. Eğer buton tıklanabilir durumda değilse, bekleyin veya reklam vs. gibi engellemeleri kaldırın
        editButton.shouldBe(Condition.visible);  // Butonun görünür olmasını bekleyin
        editButton.click();  // Düzenleme butonuna tıklayın

        // 3. İlk adı güncelle
        pageManager.webTablePage.updateFirstName(newFirstName);  // `updateFirstName` metodunun güncellenmesi gerektiğini varsayalım.
        pageManager.webTablePage.submitButton().click();  // Kaydetme işlemi
    }

    @Then("the updated record with name {string} should be visible in the table")
    public void shouldBeVisibleInTheTable(String updatedName) {
        pageManager.webTablePage.waitForRecord(updatedName);
        Assert.assertTrue(Selenide.$("div.rt-tbody").getText().contains(updatedName), updatedName + " should be visible in the table.");
    }


}
