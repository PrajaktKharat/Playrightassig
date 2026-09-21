package Day2;

import com.microsoft.playwright.*;
        import com.microsoft.playwright.options.*;
        import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.saucedemo.com/");
            page.locator("[data-test=\"username\"]").click();
            page.locator("[data-test=\"username\"]").fill("standerd_user");
            page.locator("[data-test=\"password\"]").click();
            page.locator("[data-test=\"password\"]").fill("secret_sause");
            page.locator("[data-test=\"login-button\"]").click();
            page.locator("[data-test=\"login-credentials\"]").click();
            page.locator("[data-test=\"username\"]").click();
            page.locator("[data-test=\"username\"]").press("ArrowLeft");
            page.locator("[data-test=\"username\"]").press("ArrowLeft");
            page.locator("[data-test=\"username\"]").press("ArrowLeft");
            page.locator("[data-test=\"username\"]").press("ArrowLeft");
            page.locator("[data-test=\"username\"]").press("ArrowLeft");
            page.locator("[data-test=\"username\"]").press("ArrowLeft");
            page.locator("[data-test=\"username\"]").press("ArrowLeft");
            page.locator("[data-test=\"username\"]").fill("standard_user");
            page.locator("[data-test=\"login-button\"]").click();
            page.locator("[data-test=\"password\"]").click();
            page.locator("[data-test=\"password\"]").fill("secret_sauce");
            page.locator("[data-test=\"password\"]").press("Enter");
            page.locator("[data-test=\"add-to-cart-sauce-labs-backpack\"]").click();
            page.locator("[data-test=\"add-to-cart-sauce-labs-bike-light\"]").click();
            page.locator("[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]").click();
            page.locator("[data-test=\"remove-sauce-labs-bike-light\"]").click();
            page.locator("[data-test=\"shopping-cart-link\"]").click();
            page.locator("[data-test=\"checkout\"]").click();
            page.locator("[data-test=\"firstName\"]").click();
            page.locator("[data-test=\"firstName\"]").fill("bnfjk");
            page.locator("[data-test=\"lastName\"]").click();
            page.locator("[data-test=\"lastName\"]").fill("jgj");
            page.locator("[data-test=\"postalCode\"]").click();
            page.locator("[data-test=\"postalCode\"]").fill("gjhg");
            page.locator("[data-test=\"continue\"]").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
            page.locator("[data-test=\"inventory-sidebar-link\"]").click();
            page.locator("[data-test=\"product-sort-container\"]").selectOption("lohi");
            page.locator("[data-test=\"shopping-cart-link\"]").click();
            page.locator("[data-test=\"checkout\"]").click();
            page.locator("[data-test=\"lastName\"]").click();
            page.locator("[data-test=\"lastName\"]").fill("fhgfjh");
            page.locator(".checkout_info").click();
            page.locator("[data-test=\"firstName\"]").fill("g");
            page.locator("[data-test=\"firstName\"]").click();
            page.locator("[data-test=\"firstName\"]").fill("ggfgf");
            page.locator("[data-test=\"postalCode\"]").click();
            page.locator("[data-test=\"postalCode\"]").fill("2323");
            page.locator("[data-test=\"continue\"]").click();
            page.locator("[data-test=\"finish\"]").click();
            page.locator("[data-test=\"back-to-products\"]").click();
        }
    }
}