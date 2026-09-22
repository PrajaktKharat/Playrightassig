package revision;

import com.microsoft.playwright.*;

public class LoginPage {

    public static void main(String[] args) {

        try(Playwright obj_playwright = Playwright.create()){

            Browser obj_browser = obj_playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext obj_context = obj_browser.newContext();

            Page obj_page = obj_context.newPage();

            obj_page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/login.html");

            Locator obj_UserNam = obj_page.locator("#username");
            obj_UserNam.fill("Prajakt");

            Locator obj_Password = obj_page.locator("#password");
            obj_Password.fill("9823678977");

            Locator obj_Submit = obj_page.locator("//button[@data-testid='submit-btn']");
            obj_Submit.click();

            obj_page.waitForTimeout(2000);

            obj_browser.close();



        }

    }
}
