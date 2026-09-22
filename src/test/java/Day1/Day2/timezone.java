package Day2;

import com.microsoft.playwright.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class timezone {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized"))
            );

            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setTimezoneId("Australia/Sydney").setViewportSize(null)
            );

            Page page = context.newPage();

            page.navigate("https://wikipedia.org");

            String browserTimezone = (String) page.evaluate("() => Intl.DateTimeFormat().resolvedOptions().timeZone");

            System.out.println("Browser Timezone " + browserTimezone);

//ithe verify kela
            System.out.println("Timezone: " + "Australia/Sydney".equals(browserTimezone));
        }
    }
}