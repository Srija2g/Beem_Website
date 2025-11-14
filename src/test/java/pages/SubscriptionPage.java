package pages;

import org.openqa.selenium.By;

public class SubscriptionPage {

    By subscribeBtn = By.xpath("//span[text()= 'Sign Up or Log In']");
    By phoneFieldHelloPage = By.xpath("//input[@id = 'phone']");
    By sendVerificationCode = By.xpath("//span[text() = 'Send verification code']");

}
