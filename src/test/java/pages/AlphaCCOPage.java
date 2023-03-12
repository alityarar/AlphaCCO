package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AlphaCCOPage {
    public AlphaCCOPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name=\"ctl00$MainContent$txtEmail\"]")
    public WebElement userEnterence;

    @FindBy(xpath = "//input[@name=\"ctl00$MainContent$txtPassword\"]")
    public WebElement passwordEnterence;

    @FindBy(xpath = "//input[@name=\"ctl00$MainContent$btnLogin\"]")
    public WebElement logIn;

    @FindBy(xpath = "//input[@name=\"ctl00$MainContent$btnForgotPassword\"]")
    public WebElement forgotPasswordMain;

    @FindBy(xpath = "//input[@name=\"ctl00$MainContent$txtModalForgotPasswordUserName\"]")
    public WebElement passResetMail;

    @FindBy(xpath = "//input[@name=\"ctl00$MainContent$btnModalForgotPasswordSendRequest\"]")
    public WebElement requestReset;

    @FindBy(xpath = "//a[@href=\"/Logout.aspx\"]")
    public WebElement logOut;



    @FindBy(xpath = "//*[@id=\"UserLogin\"]")
    public WebElement meBar;

    @FindBy(xpath = "//a[@class=\"dropdown-item\"][5]")
    public WebElement meLogout;

    @FindBy(xpath = "//a[@id=\"lnkChgPassword\"]")
    public WebElement meChangePass;

    @FindBy(xpath = "//input[@id=\"input-7\"]")
    public WebElement mePreviousPass;

    @FindBy(xpath = "//input[@id=\"input-11\"]")
    public WebElement meNewPass;

    @FindBy(xpath = "//input[@id=\"input-19\"]")
    public WebElement meNewPassConfirm;

    @FindBy(xpath = "(//button[@type=\"button\"])[5]")
    public WebElement meUpdatePassButton;


}
