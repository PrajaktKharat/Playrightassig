package Day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Assignment1 {

    // built in locators
    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()){

            Browser browser  = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();
            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/login.html");

            page.getByPlaceholder("Enter username").fill("admin");
            Thread.sleep(2000);
            page.getByTestId("password-input").fill("admin");
            Thread.sleep(2000);
            System.out.println("Pass ");
            page.getByText("Sign In").click();

            String Textpara = page.getByText("Forgot your password?").textContent();
            System.out.println("pass "+ Textpara);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            browser.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
