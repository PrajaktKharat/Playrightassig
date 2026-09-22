package Day2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class Assignment5 {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/ControlsPractice.html");

            Locator dropdown = page.locator("#module");
            dropdown.selectOption(new SelectOption().setLabel("DAI"));

            page.waitForTimeout(2000);
            browser.close();
        }
    }
}
