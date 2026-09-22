package Day3;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class welcome {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/welcome.html");
            Locator button = page.locator("#enterNameBtn");
            button.click();

            Locator text = page.locator("#nameField");
            text.fill("hello");



            try {
                assertThat(text).isEnabled();
            }catch (Exception e){
                e.printStackTrace();
            }



            page.close();
        }
    }
}