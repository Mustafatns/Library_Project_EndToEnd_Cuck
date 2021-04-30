package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Books_Page;
import com.cybertek.library.pages.Dashboard_Page;
import com.cybertek.library.pages.Login_Page;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.ExcelSetUp;
import io.cucumber.java.en.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;

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
    public void librarian_clicks_at_add_book_button_and_fills_in_the_fields() throws IOException {

//            String excelPath = "src/test/resources/TestData/TestApache.xlsx";
//            FileInputStream fileInputStream = new FileInputStream(excelPath);
//            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//            XSSFSheet excelSheet = workbook.getSheet("NewBooks");

            XSSFSheet excelSheet = ExcelSetUp.readSetUp("src/test/resources/TestData/TestApache.xlsx","NewBooks");

            for (int rowNum = 1; rowNum <= excelSheet.getLastRowNum(); rowNum++) {
                books_page.addBookButton.click();
                BrowserUtils.waitForVisibility(books_page.addBookTitle, 5);

                XSSFRow currentRow = excelSheet.getRow(rowNum);

                BrowserUtils.wait(1);
                String bookName = currentRow.getCell(0).getStringCellValue();
                books_page.bookNameBox.sendKeys(bookName);

                BrowserUtils.wait(1);
                String isbn = currentRow.getCell(1).getStringCellValue();
                books_page.isbnBox.sendKeys(isbn);

                BrowserUtils.wait(1);
                Double year = currentRow.getCell(2).getNumericCellValue();
                int intYear = year.intValue();
                books_page.yearBox.sendKeys(String.valueOf(intYear));

                BrowserUtils.wait(1);
                String author = currentRow.getCell(3).getStringCellValue();
                books_page.authorBox.sendKeys(author);

                BrowserUtils.wait(1);
                String bookCategory = currentRow.getCell(4).getStringCellValue();
                Select bookGroups = new Select(books_page.bookGroupDropdown);
                bookGroups.selectByVisibleText(bookCategory);

                BrowserUtils.wait(1);
                String description = currentRow.getCell(5).getStringCellValue();
                books_page.descriptionBox.sendKeys(description);

                books_page.saveButton.click();
            }
            ExcelSetUp.fileInputStream.close();
            ExcelSetUp.workbook.close();

    }

}
