package Day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static Day1.locators_in_Playw.idUsername;
import static Day1.locators_in_Playw.username;

public class openmultiplepagesinPly {

    public static void main(String[] args) {

        try (Playwright obj_playwright = Playwright.create()) {

            Browser obj_browser = obj_playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page obj_page1 = obj_browser.newPage();

            try {
                obj_page1.navigate("https://www.saucedemo.com");

                System.out.println("opened 1 tab " + obj_page1.title());
            } catch (Exception e) {
                e.printStackTrace();
            }

            Page obj_page2 = obj_browser.newPage();

            try {
                obj_page2.navigate("https://www.google.com");

                System.out.println("opened 2 tab " + obj_page2.title());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                obj_browser.close();
            }


        }
    }
}
