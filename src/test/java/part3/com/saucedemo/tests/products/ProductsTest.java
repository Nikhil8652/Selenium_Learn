package part3.com.saucedemo.tests.products;

import com.soucedemo.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.saucedemo.base.BaseTest;

public class ProductsTest extends BaseTest {
    @Test
    public void testProductsHeaderIsDisplayed() {
        ProductPage productsPage = loginPage.loginIntoApplication("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isProductHeaderDisplayed(), "\n Products headers in not displayed \n");
    }
}
