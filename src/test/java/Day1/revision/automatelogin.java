package revision;

import com.microsoft.playwright.*;

public class automatelogin {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()){

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();

            Page page = browserContext.newPage();


            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/login.html");

            Locator Username = page.locator("#username");
            Username.fill("Nakul");

            Locator Password = page.locator("#password");
            Password.fill("45666");


            Locator Submit = page.getByText("Sign In");
            Page newpage = browserContext.waitForPage(()->{
                Submit.click();
            });

            System.out.println(newpage.title());
          if (newpage.title().equals("Student Performance Report")){
              System.out.println("Pass");
          }else {
              System.out.println("fail");
          }


        }
    }
}
