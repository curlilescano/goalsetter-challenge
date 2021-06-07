package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoalCardSelectionPage extends BasePage {

    public GoalCardSelectionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "img[src='https://s3.amazonaws.com/goalcardimages/new2.png']")
    private WebElement startSmallDreamBig;

    public void selectGoalCard() {
        waitVisibility(startSmallDreamBig);
        startSmallDreamBig.click();
    }

}
