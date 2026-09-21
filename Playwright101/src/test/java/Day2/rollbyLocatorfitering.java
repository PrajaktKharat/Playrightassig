package Day2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class rollbyLocatorfitering {


    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/LocatorFiltering.html");
            page.waitForTimeout(1000);

            Locator sourceContainer = page.locator("container").filter(new Locator.FilterOptions().setHas(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(" TO DO"))));

            Locator TargetContainer = page.locator("container").filter(new Locator.FilterOptions().setHas(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Done"))));






        }
    }
}
