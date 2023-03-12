package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotmailPage {
    public HotmailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@type=\"email\"]")
    public WebElement mailEnterence;

    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement passwordEnterence;

    @FindBy(xpath = "//*[@id=\"ReadingPaneContainerId\"]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div/div[3]/div/div/div/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[2]/text()[2]")
    public WebElement tempPass;

    @FindBy(xpath = "//input[@id=\"idSIButton9\"]")
    public WebElement questionMail;

    @FindBy(id = "idSIButton9")
    public WebElement next1;



}
