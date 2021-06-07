package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseSuccessPage extends BasePage {

    public PurchaseSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@data-testid = 'lblTitle']")
    private WebElement title;

    @FindBy(xpath = "//label[@data-testid = 'lblTitle']/following-sibling::label")
    private WebElement mainText;

    @FindBy(xpath = "//button[@data-testid = 'btnPrint']")
    private WebElement printBtn;

    @FindBy(xpath = "//button[@data-testid = 'btnGiveAnotherGoal']")
    private WebElement giveAnotherGoalCardBtn;

    public String getTitleText() {
        waitVisibility(title);
        return title.getText();
    }

    public String getMainTextText() {
        return mainText.getText();
    }

    public boolean isPrintBtnDisplayed() {
        return printBtn.isDisplayed();
    }

    public boolean isGiveAnotherGoalCardBtnDisplayed() {
        return giveAnotherGoalCardBtn.isDisplayed();
    }

}
