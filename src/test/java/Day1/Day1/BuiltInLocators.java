package Day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import static Day1.DrivingAssigplay.submitBtn;

public class BuiltInLocators {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()){

            Browser browser  = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();
            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/login.html");

            page.getByLabel("Username").fill("admin");
            page.getByLabel("Password").fill("admin");
            System.out.println("Pass ");



            page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Sign In")).click();


            String Textpara = page.getByText("Forgot your password?").textContent();
            System.out.println("pass "+ Textpara);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            browser.close();
        }
    }
}
