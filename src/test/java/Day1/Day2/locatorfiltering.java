
package Day2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class locatorfiltering {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/ControlsPractice.html");

            page.locator("#module").selectOption(new SelectOption().setValue("DAI"));

            Locator rows = page.locator("table tbody tr")
                    .filter(new Locator.FilterOptions().setHas(page.locator("input[type='number']")));

            int rowcount = rows.count();
            System.out.println("raw count" + rowcount);

            for (int i = 0; i < rowcount; i++) {
                Locator rowq = rows.nth(i);

                Locator markinput = rowq.locator("input[type='number']");
                markinput.fill(String.valueOf(90+i));

                page.waitForTimeout(2000);
            }

            page.locator("#saveButton").click();

            page.waitForTimeout(3000);

            browser.close();
        }
    }
}