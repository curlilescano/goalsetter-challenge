package managers;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private GoalCardSelectionPage goalCardSelectionPage;
    private GoalCardCustomizePage goalCardCustomizePage;
    private PurchasePage purchasePage;
    private PurchaseSuccessPage purchaseSuccessPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public GoalCardSelectionPage getGoalCardSelectionPage() {
        return (goalCardSelectionPage == null) ? goalCardSelectionPage = new GoalCardSelectionPage(driver) : goalCardSelectionPage;
    }

    public GoalCardCustomizePage getGoalCardCustomizePage() {
        return (goalCardCustomizePage == null) ? goalCardCustomizePage = new GoalCardCustomizePage(driver) : goalCardCustomizePage;
    }

    public PurchasePage getPurchasePage() {
        return (purchasePage == null) ? purchasePage = new PurchasePage(driver) : purchasePage;
    }

    public PurchaseSuccessPage getPurchaseSuccessPage() {
        return (purchaseSuccessPage == null) ? purchaseSuccessPage = new PurchaseSuccessPage(driver) : purchaseSuccessPage;
    }

}
