package pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login {

	WebDriver driver;
	List<WebElement> wb;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login-button")
	WebElement loginButton;

	@FindBy(id = "user-name")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(xpath = "//span[@class='active_option']")
	WebElement defaultFilter;

	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement shoppingCart;

	@FindBy(id = "remove-sauce-labs-backpack")
	WebElement sauceLabsBackpack;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement shoppingCartIcon;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement item;

	@FindBy(name = "continue-shopping")
	WebElement continueShopping;

	@FindBy(className = "product_sort_container")
	WebElement priceFilter;

	public Boolean lb_verify() {

		String value = loginButton.getAttribute("value");
		String capitalVerify = loginButton.getCssValue("text-transform");
		return (value.equalsIgnoreCase("Login") && capitalVerify.equalsIgnoreCase("uppercase"));

	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterpassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String verifyDefaultFilter() {
		return defaultFilter.getText();
	}

	public void selectFirstProduct() {
		wb = driver.findElements(By.className("inventory_item_name"));
		for (int i = 0; i < wb.size(); i++) {
			if (i == 0) {
				WebElement c = wb.get(i);
				c.click();
				addToCart.click();

			}
		}

	}

	public int verifyShoppingCart() {
		String value = shoppingCart.getText();
		int productCount = Integer.parseInt(value);
		return productCount;
	}

	public void selectLastProduct() {
		driver.navigate().back();
		wb = driver.findElements(By.className("inventory_item_name"));
		for (int i = 0; i < wb.size(); i++) {
			if (i == wb.size() - 1) {
				WebElement c = wb.get(i);
				c.click();
				addToCart.click();

			}
		}

	}

	public void removeFirstProduct() {
		driver.navigate().back();
		sauceLabsBackpack.click();
	}

	public void clickShoppingCart() {
		shoppingCartIcon.click();
	}

	public String verifyShoppingCartProducts() {
		return item.getText();
	}

	public void continueShopping() {
		continueShopping.click();
	}

	public void sortPrices() {
		Select sel = new Select(priceFilter);
		sel.selectByVisibleText("Price (low to high)");
	}

	public void verifySort() {
		String pricesList = null;
		String priceCurrency = null;
		List<Double> values = new ArrayList<Double>();
		List<WebElement> elements = driver.findElements(By.className("inventory_item_price"));
		for (WebElement element : elements) {
			priceCurrency = element.getText();
			pricesList = priceCurrency.replaceAll("[^0-9.]", "");
			Double pL = Double.parseDouble(pricesList);
			System.out.println(pL);
			values.add(pL);
			
			}
			System.out.println(values);
		

	}
}
