package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Books_Page;
import com.cybertek.library.pages.Dashboard_Page;
import com.cybertek.library.pages.Login_Page;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddBooks_StepDefinitions {
    Dashboard_Page dashboard_page = new Dashboard_Page();
    Books_Page books_page = new Books_Page();

    @Given("The librarian is on login page")
    public void the_librarian_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("The librarian logs in  {string} and {string} sees {string}")
    public void the_librarian_logs_in_and_sees(String username, String password, String title) throws InterruptedException {

        Login_Page login_page = new Login_Page();
        BrowserUtils.waitForVisibility(login_page.emailInput, 5);
        login_page.emailInput.sendKeys(username);
        login_page.passwordInput.sendKeys(password);
        login_page.signInButton.click();

        BrowserUtils.waitForVisibility(dashboard_page.dashTitle, 5);

        Assert.assertEquals(dashboard_page.dashTitleText(),title);


    }

    @Then("Librarian clicks books button and sees {string}")
    public void librarian_clicks_books_button_and_sees(String title) {
        dashboard_page.booksButton.click();
        Assert.assertEquals(books_page.title.getText(),title);
    }

    @Then("Librarian clicks at Add Book button and fills in the fields")
    public void librarian_clicks_at_add_book_button_and_fills_in_the_fields() {


    }

    @Then("Librarian clicks at save changes button")
    public void librarian_clicks_at_save_changes_button() {

    }
}
