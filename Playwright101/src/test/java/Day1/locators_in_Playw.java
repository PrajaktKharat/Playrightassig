package Day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class locators_in_Playw {
//id pass
    static String username = "standard_user";
    static String password = "secret_sauce";
//locator
    static String XpathLoginbutton = "//input[@id='login-button']";
    static String cssLoginButton = "#login-button";
    static String idUsername = "#user-name";
    static String name_user = "[name='user-name']";
    static String PlaceholderUsername = "[placeholder='Username']";
    static String id_password = "#password";

    public static void main(String[] args) {

        try (Playwright obj_playwright = Playwright.create()) {

            Browser obj_browser = obj_playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page obj_page = obj_browser.newPage();

            try {
                obj_page.navigate("https://www.saucedemo.com");

                obj_page.locator(idUsername).fill(username);
                Thread.sleep(2000);
                obj_page.locator(id_password).fill(password);
                Thread.sleep(2000);
                obj_page.locator(cssLoginButton).click();

                if (obj_page.url().contains("inventory.html")) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Failed Login");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                obj_browser.close();
            }
        }
    }
}