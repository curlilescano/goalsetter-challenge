package pages;

import base.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoalCardCustomizePage extends BasePage {


    public GoalCardCustomizePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[div/label[text()='Fun Fund']]/div/input")
    private WebElement funFund;

    @FindBy(xpath = "//div[div/label[text()='Savings']]/div/input")
    private WebElement savings;

    @FindBy(name = "investorName")
    private WebElement investorName;

    @FindBy(name = "investorEmail")
    private WebElement investorEmail;

    @FindBy(xpath = "//button[@data-testid = 'btnContinue']")
    private WebElement continueBtn;

    public void setXForFunFund(int amount) {
        waitVisibility(funFund);
        funFund.sendKeys(Keys.BACK_SPACE);
        funFund.sendKeys(Keys.BACK_SPACE);
        funFund.sendKeys(Keys.BACK_SPACE);
        funFund.sendKeys(Keys.BACK_SPACE);
        funFund.sendKeys(String.valueOf(amount));
        funFund.sendKeys(Keys.DELETE);
    }

    public void setXForSavings(int amount) {
        savings.sendKeys(Keys.BACK_SPACE);
        savings.sendKeys(Keys.BACK_SPACE);
        savings.sendKeys(Keys.BACK_SPACE);
        savings.sendKeys(Keys.BACK_SPACE);
        savings.sendKeys(String.valueOf(amount));
        savings.sendKeys(Keys.DELETE);
    }

    public void setInvestorName(String investor) {
        investorName.sendKeys(investor);
    }

    public void setRandomEmail() {
        String randomString = RandomStringUtils.randomAlphanumeric(8);
        String email = "someEmail+" + randomString + "@gmail.com";
        investorEmail.sendKeys(email);
    }

    public void clickContinue() {
        continueBtn.click();
    }

}
