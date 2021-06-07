package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PurchasePage extends BasePage {

    public PurchasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-testid = 'inputCardHolderName']")
    private WebElement cardHolderName;

    @FindBy(xpath = "//input[contains(@class,'PrivateStripeElement')]")
    private WebElement creditCardNumber;

    @FindBy(xpath = "//iframe[contains(@name,'privateStripeFrame')]")
    private WebElement creditCardNumberIframe;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement submitPayment;


    public void setCardHolderName(String holderName) {
        cardHolderName.sendKeys(holderName);
    }

    public void setCreditCardNumber() {
        waitVisibility(creditCardNumberIframe);
        creditCardNumberIframe.click();
        waitSeconds(1);
        creditCardNumberIframe.sendKeys("");
        waitSeconds(2);
        creditCardNumberIframe.click();
        creditCardNumberIframe.sendKeys("4242424242424242042424250001");
    }

    public void submitPayment() {
        submitPayment.click();
    }

}
