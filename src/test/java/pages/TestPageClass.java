package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.TestBaseClass;



public class TestPageClass extends TestBaseClass {

    private AndroidDriver driver;

    public TestPageClass(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
    public AndroidElement skipButton;
    @AndroidFindBy(xpath =  "//android.webkit.WebView[contains(text(),'Samsung UN65RU7100FXZA Flat 65-Inch 4K UHD 7')")
    public AndroidElement getItemText;
    @AndroidFindBy(xpath =  "//android.webkit.WebView[contains(text(),'ADD TO LIST')")
    public AndroidElement addToCart;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    public AndroidElement searchBox;

    @AndroidFindBy(id = " com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout")
    public AndroidElement clickTextReq;

//    @AndroidFindBy(id = "")
//    public AndroidElement popover;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(text(),'Create account. New to Amazon?')]")
    public AndroidElement createAccountButton;

    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(skipButton));
        skipButton.click();
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
    }

    public void enterSearchItem() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("65 inch tv"+Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(getItemText));
        getItemText.click();
    }

    public void clickSaveButton()  {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
    }

    public void searchForTv() {
        clickSearch();
        enterSearchItem();
        clickSaveButton();
    }

    public void assertCreateAccount() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));
        Assert.assertTrue(createAccountButton.isDisplayed());
    }
}


