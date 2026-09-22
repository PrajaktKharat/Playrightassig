package Day2;

import com.microsoft.playwright.*;

public class localeassignment {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setLocale("de-DE"));

            Page page = context.newPage();

            page.navigate("https://wikipedia.org");
            page.waitForTimeout(2000);

            System.out.println("Page title; " + page.title());

            Locator langlable = page.locator("#jsLangLabel");
            String langvalue = langlable.textContent();
            System.out.println("Pass");



            browser.close();
        }


    }
}
