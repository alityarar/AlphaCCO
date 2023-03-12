package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AlphaCCOPage;
import pages.HotmailPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class AlphaCCOStepDefinitions {
    AlphaCCOPage alphaPage=new AlphaCCOPage();
    HotmailPage hotmailPage=new HotmailPage();
    String mailedPass="";

    @Given("User goes {string}")
    public void user_goes(String string) throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("alphaWebSite"));
        Thread.sleep(2000);

    }
    @Then("Verify that the Login page is accessible and loads correctly")
    public void verify_that_the_login_page_is_accessible_and_loads_correctly() {
        Assert.assertTrue(alphaPage.userEnterence.isDisplayed());
        Assert.assertTrue(alphaPage.passwordEnterence.isDisplayed());
        Assert.assertTrue(alphaPage.logIn.isDisplayed());

    }
    @Then("Verify that a user can log in successfully with {string} and {string}")
    public void verify_that_a_user_can_log_in_successfully_with_and(String userName, String password) throws InterruptedException {
        alphaPage.userEnterence.sendKeys(ConfigReader.getProperty("userName"));
        Thread.sleep(2000);
        alphaPage.passwordEnterence.sendKeys(ConfigReader.getProperty("password1"));
        Thread.sleep(2000);
        alphaPage.logIn.click();
        Thread.sleep(2000);

    }
    @Then("Verify that the user is redirected to their profile page after logging in successfully")
    public void verify_that_the_user_is_redirected_to_their_profile_page_after_logging_in_successfully() throws InterruptedException {
        Assert.assertTrue(alphaPage.meBar.isDisplayed());
        Thread.sleep(1500);

    }
    @Then("Verify that the user can log out successfully")
    public void verify_that_the_user_can_log_out_successfully() throws InterruptedException {
        alphaPage.meBar.click();
        Thread.sleep(2000);
        alphaPage.meLogout.click();
        Thread.sleep(2000);
        Assert.assertTrue(alphaPage.userEnterence.isDisplayed());

    }
    @Then("Close All")
    public void close_all() throws InterruptedException {
        Thread.sleep(1000);
        Driver.closeDriver();

    }

    @Then("Enter {string} and {string}")
    public void enter_and(String fakeUser, String fakePassword) throws InterruptedException {
       alphaPage.userEnterence.sendKeys(ConfigReader.getProperty("fakeUser"));
        Thread.sleep(2000);
       alphaPage.passwordEnterence.sendKeys(ConfigReader.getProperty("password2"));
        Thread.sleep(2000);
       alphaPage.logIn.click();
       Thread.sleep(1500);
    }
    @Then("Verify that the user cannot log in with invalid credentials")
    public void verify_that_the_user_cannot_log_in_with_invalid_credentials() throws InterruptedException {
       Assert.assertTrue(alphaPage.logIn.isDisplayed());
        Thread.sleep(2000);
    }

    @Then("User uses Forgot Password button")
    public void user_uses_forgot_password_button() throws InterruptedException {
       alphaPage.forgotPasswordMain.click();
       Thread.sleep(3000);


    }
    @Then("The user sends a password reset request by entering their {string} as e-mail address.")
    public void the_user_sends_a_password_reset_request_by_entering_their_as_e_mail_address(String userName) throws InterruptedException {
       alphaPage.passResetMail.click();
        Thread.sleep(2000);
       alphaPage.passResetMail.sendKeys(ConfigReader.getProperty("userName"));
        Thread.sleep(2000);
       alphaPage.requestReset.click();
        Thread.sleep(2000);
    }
    @Then("Verifies that there is a renewed password in the last message by entering the mail account.")
    public void verifies_that_there_is_a_renewed_password_in_the_last_message_by_entering_the_mail_account() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("hotmailWebSite"));
        Thread.sleep(1500);
        Driver.getDriver().switchTo().activeElement().sendKeys(ConfigReader.getProperty("userName"));
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(ConfigReader.getProperty("hotmailPassword"));
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("idSIButton9")).click();

        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);



        Thread.sleep(15000);


        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);




        Thread.sleep(3000);


        String inputText=Driver.getDriver().switchTo().activeElement().findElement(By.xpath("(//table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/div/div)[2]")).getText();


        String passwordPrefix = "Password: ";
        List<String> passwords = new ArrayList<>();

        int passwordIndex = inputText.indexOf(passwordPrefix);
        while (passwordIndex != -1) {
            String password = inputText.substring(passwordIndex + passwordPrefix.length(),
                    passwordIndex + passwordPrefix.length() + 8);
            passwords.add(password);
            passwordIndex = inputText.indexOf(passwordPrefix, passwordIndex + 1);
        }
        StringBuilder passwordString = new StringBuilder();
        for (int i = 0; i < passwords.size(); i++) {
            passwordString.append(passwords.get(i));
            if (i != passwords.size() - 1) {
                passwordString.append(", ");
            }
        }

         mailedPass=passwordString.toString();




    }
    @Then("Login with username and new password")
    public void login_with_username_and_new_password() throws InterruptedException {
        Thread.sleep(3000);
        Driver.getDriver().switchTo().activeElement().sendKeys(ConfigReader.getProperty("userName"));
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(mailedPass);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(1000);


    }
    @Then("Makes a password update by entering old and new passwords")
    public void makes_a_password_update_by_entering_old_and_new_passwords() throws InterruptedException {
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(mailedPass);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(ConfigReader.getProperty("password2"));
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(ConfigReader.getProperty("password2"));
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    @Then("Verifies that can login with {string} and new password")
    public void verifies_that_can_login_with_and_new_password(String userName) throws InterruptedException {
        Thread.sleep(2000);
        Driver.getDriver().get(ConfigReader.getProperty("alphaWebSite"));
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(ConfigReader.getProperty("password2"));
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(9000);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"UserLogin\"]")).isDisplayed());
        Thread.sleep(1000);
    }

    @Given("Entering with the most up -to -date password and user name")
    public void entering_with_the_most_up_to_date_password_and_user_name() throws InterruptedException {

        alphaPage.userEnterence.sendKeys(ConfigReader.getProperty("userName"));
        Thread.sleep(1000);
        alphaPage.passwordEnterence.sendKeys(ConfigReader.getProperty("password2"));
        Thread.sleep(1000);
        alphaPage.logIn.click();

    }
    @Then("Clicks to the change password button")
    public void clicks_to_the_change_password_button() throws InterruptedException {
        Thread.sleep(4000);
        WebElement dropdown=(Driver.getDriver().findElement(By.xpath("//*[@id=\"UserLogin\"]")));
        Thread.sleep(2000);
        dropdown.click();
        Thread.sleep(2000);
        alphaPage.meChangePass.click();
        Thread.sleep(1000);
    }
    @When("Renews the password by entering the latest password and the new password to be made.")
    public void renews_the_password_by_entering_the_latest_password_and_the_new_password_to_be_made() throws InterruptedException {

        Thread.sleep(2000);
        alphaPage.mePreviousPass.sendKeys(ConfigReader.getProperty("password2"));
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(2000);
        alphaPage.meNewPass.sendKeys(ConfigReader.getProperty("password3"));
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);Driver.getDriver().switchTo().activeElement().sendKeys(ConfigReader.getProperty("password3"));
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        alphaPage.meNewPassConfirm.sendKeys(ConfigReader.getProperty("password3"));
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    @Then("Verify that can be logged in with updated password")
    public void verify_that_can_be_logged_in_with_updated_password() throws InterruptedException {

        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(ConfigReader.getProperty("password3"));
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(9000);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@id=\"UserLogin\"]")).isDisplayed());
    }








}
