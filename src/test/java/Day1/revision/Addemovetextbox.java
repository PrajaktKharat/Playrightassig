package revision;

import com.microsoft.playwright.*;

public class Addemovetextbox {

    public static void main(String[] args) {
        try (Playwright playwright  = Playwright.create()){


            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("https://the-internet.herokuapp.com/");
            page.waitForTimeout(2000);
            Locator locator = page.getByText("Dynamic Controls");
            locator.click();
            page.waitForTimeout(2000);
            Locator removcheck = page.getByText("Remove");
            removcheck.click();
            page.waitForTimeout(2000);
            Locator enabletext  =  page.getByText("Enable");
            enabletext.click();


        }
    }
}