package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "GIVE A GOALCARD")
    private WebElement giveAGoalCard;

    public void clickOnGiveAGoldCard() {
        waitVisibility(giveAGoalCard);
        giveAGoalCard.click();
    }

}
