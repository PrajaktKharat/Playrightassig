package Day2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Autowait {

    public static void main(String[] args) {
        try (Playwright playwright=Playwright.create()){

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            Locator massage = page.locator("#message");

            long start = System.currentTimeMillis();

            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/welcome.html");

            massage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

            String lable = massage.innerText();

            long els = System.currentTimeMillis()-start;


            System.out.println("TEXT "+lable);
            System.out.println("wait "+els+"ms");



        }
    }
}
