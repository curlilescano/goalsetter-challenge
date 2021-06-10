package stepDefinitions;


import config.Configuration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.PageObjectManager;
import managers.WebDriverManagers;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.*;
import status.UserInformation;

public class SendGoalCardStepDefinitions {

    public WebDriver driver;
    private UserInformation userInformation;
    PageObjectManager pageObjectManager;
    WebDriverManagers webDriverManagers;
    HomePage homePage;
    GoalCardSelectionPage goalCardSelectionPage;
    GoalCardCustomizePage goalCardCustomizePage;
    PurchasePage purchasePage;
    PurchaseSuccessPage purchaseSuccessPage;

    public SendGoalCardStepDefinitions(UserInformation userInformation) {
        this.userInformation = userInformation;
    }


    @Given("^I go to kyle3080 main page$")
    public void iGoToKyle3080MainPage() {
        webDriverManagers = new WebDriverManagers();
        driver = webDriverManagers.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        driver.get(Configuration.getURL());
    }

    @And("^I click on Give a GoalCard button$")
    public void iClickOnGiveGoalCard() {
        homePage = pageObjectManager.getHomePage();
        homePage.clickOnGiveAGoldCard();
    }

    @And("^I select Start small dream big card$")
    public void iSelectStartSmallCard() {
        goalCardSelectionPage = pageObjectManager.getGoalCardSelectionPage();
        goalCardSelectionPage.selectGoalCard();
    }

    @And("^I set (\\d+) dollars for Fun fund$")
    public void iSetXFunFund(int amount) {
        userInformation.setFunFundAmount(amount);
        goalCardCustomizePage = pageObjectManager.getGoalCardCustomizePage();
        goalCardCustomizePage.setXForFunFund(amount);
    }

    @And("^I set (\\d+) dollars for Savings$")
    public void iSetXSavings(int amount) {
        userInformation.setSavingsAmount(amount);
        goalCardCustomizePage.setXForSavings(amount);
    }

    @And("^I set (\\S+) as investor name$")
    public void iSetXSavings(String investor) {
        goalCardCustomizePage.setInvestorName(investor);
    }

    @And("^I set a random email$")
    public void iSetARandomEmail() {
        goalCardCustomizePage.setRandomEmail();
    }

    @And("^I click on continue button on Customize GoalCard page$")
    public void iClickOnContinueOnCustomize() {
        goalCardCustomizePage.clickContinue();
    }

    @And("^I set? (.*) as the Cardholder name$")
    public void iSetCardholderName(String holderName) {
        purchasePage = pageObjectManager.getPurchasePage();
        purchasePage.setCardHolderName(holderName);
    }

    @And("^I set? the credit card number$")
    public void iSetCreditCardNumber() {
        purchasePage.setCreditCardNumber();
    }

    @And("^I submit payment$")
    public void iSubmitPayment() {
        purchasePage.submitPayment();
    }

    @Then("^I validate the information displayed in success page$")
    public void iValidateSuccessPage() {
        purchaseSuccessPage = pageObjectManager.getPurchaseSuccessPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(purchaseSuccessPage.getTitleText(), "Hooray!");
        softAssert.assertEquals(purchaseSuccessPage.getMainTextText(), "You gave a $" + (userInformation.getFunFundAmount() + userInformation.getSavingsAmount()) + " GoalCard to support " + "Kyle" + "'s goals!");
        softAssert.assertTrue(purchaseSuccessPage.isPrintBtnDisplayed());
        softAssert.assertTrue(purchaseSuccessPage.isGiveAnotherGoalCardBtnDisplayed());
        softAssert.assertAll();
    }

}
