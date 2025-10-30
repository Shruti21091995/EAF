package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;


public class CheckOutPage {
    private WebDriver driver;

    // Elements for checkout steps
    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = "input.button-1.new-address-next-step-button")
    private WebElement continueBillingButton;

    @FindBy(css = "input.button-1.shipping-method-next-step-button")
    private WebElement continueShippingButton;

    @FindBy(css = "input.button-1.payment-method-next-step-button")
    private WebElement continuePaymentButton;

    @FindBy(css = "input.button-1.payment-info-next-step-button")
    private WebElement continuePaymentInfoButton;

    @FindBy(css = "input.button-1.confirm-order-next-step-button")
    private WebElement confirmOrderButton;

    @FindBy(css = "div.section.order-completed div.title strong")
    private WebElement orderConfirmationMessage;

    // Constructor
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void agreeToTerms() {
        WaitUtils.ElementToBeVisible(driver, termsOfServiceCheckbox);
        termsOfServiceCheckbox.click();
    }

    public void clickCheckout() {
        WaitUtils.ElementToBeVisible(driver, checkoutButton);
        checkoutButton.click();
    }

    public void completeCheckoutSteps() {
    	WaitUtils.ElementToBeVisible(driver, continueBillingButton);
        continueBillingButton.click();

        WaitUtils.ElementToBeVisible(driver, continueShippingButton);
        continueShippingButton.click();

        WaitUtils.ElementToBeVisible(driver, continuePaymentButton);
        continuePaymentButton.click();

        WaitUtils.ElementToBeVisible(driver, continuePaymentInfoButton);
        continuePaymentInfoButton.click();

        WaitUtils.ElementToBeVisible(driver, confirmOrderButton);
        confirmOrderButton.click();
    }

    public String getOrderConfirmationMessage() {
        WaitUtils.ElementToBeVisible(driver, orderConfirmationMessage);
        return orderConfirmationMessage.getText();
    }
}
