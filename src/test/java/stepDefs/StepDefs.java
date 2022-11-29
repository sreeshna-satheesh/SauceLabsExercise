package stepDefs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Login;

public class StepDefs extends BaseTest {

	public void setUp() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./testData/Config.properties");
		prop.load(fis);
	}

	@Given("I launch SauceDemo website {string}")
	public void i_login_to_sauce_demo_website(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		lp = new Login(driver);
		driver.get(url);

	}

	@Given("verify the title as Swag Labs")
	public void verify_the_title_as_swag_labs() {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Swag Labs"));
		System.out.println("Title is  " + driver.getTitle());
	}

	@Given("verify the login button is capitalized")
	public void verify_the_login_button_is_capitalized() {
		Boolean verifyValue = lp.lb_verify();
		Assert.assertEquals(verifyValue, true);
		System.out.println("Login Button Capitalized " + verifyValue);

	}

	@Given("login with {string} and {string}")
	public void login_with_and(String username, String password) {
		lp.enterUsername(username);
		lp.enterpassword(password);
		System.out.println("Logined to Swag Labs");
		lp.clickLoginButton();
	}

	@When("logined, validate the default filter is A-Z")
	public void logined_validate_the_default_filter_is_a_z() {
		String defaultFilterText = lp.verifyDefaultFilter();
		System.out.println(defaultFilterText);
		Assert.assertTrue(defaultFilterText.contains("A TO Z"));
		System.out.println("Filter dropdown is verified");
	}

	@When("verify the first product added")
	public void verify_the_first_product_added() {
		lp.selectFirstProduct();
		System.out.println("First product is Added");
	}

	@When("verify the cart badge has {int} product")
	public void verify_the_cart_badge_has_product(Integer int1) {
		int1 = lp.verifyShoppingCart();
		Assert.assertEquals(1, int1);
		System.out.println("Shopping Cart Verified with " + int1 + "product");
	}

	@When("verify the last product added")
	public void verify_the_last_product_added() {
		lp.selectLastProduct();
		System.out.println("Last product is Added");
	}

	@When("verify the cart badge value is increased")
	public void verify_the_cart_badge_value_is_increased() {
		int int2 = lp.verifyShoppingCart();
		Assert.assertEquals(2, int2);
		System.out.println("Shopping Cart Verified with " + int2 + "products");
	}

	@When("remove the first product and validate the cart")
	public void remove_the_first_product() {
		lp.removeFirstProduct();
		int int3 = lp.verifyShoppingCart();
		Assert.assertEquals(1, int3);
		System.out.println("Shopping Cart Verified with " + int3 + "product");
	}

	@Then("click on the cart")
	public void click_on_the_cart() {
		lp.clickShoppingCart();
	}

	@Then("verify the added product is available")
	public void verify_the_added_product_is_available() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(lp.verifyShoppingCartProducts().contains("T-Shirt (Red)"));
		System.out.println("The product is available in the cart ");
	}

	@Then("click on the Continue Shopping")
	public void click_on_the_continue_shopping() {
		lp.continueShopping();
	}

	@Then("change the price filter from low to high")
	public void change_the_price_filter_from_low_to_high() {
		lp.sortPrices();
	}

	@Then("verify the price sorted properly")
	public void verify_the_price_sorted_properly() {
		lp.verifySort();
	}

}
