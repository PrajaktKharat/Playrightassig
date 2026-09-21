package Day2;

import com.microsoft.playwright.*;

public class Assignment3 {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/LocatorFiltering.html");


            Locator itemToDrag = page.locator("#item1");
            Locator targetContainer = page.locator("#targetContainer");
            itemToDrag.dragTo(targetContainer);

            Locator itemToDrag2 = page.locator("#item2");
            Locator targetContainer2 = page.locator("#targetContainer");
            itemToDrag2.dragTo(targetContainer2);

            Locator itemToDrag3 = page.locator("#item3");
            Locator targetContainer3 = page.locator("#targetContainer");
            itemToDrag3.dragTo(targetContainer3);

            page.waitForTimeout(3000);


            Locator msg = page.locator("#result");
            if(msg.equals("Write Selenium Tests moved to Done")){
                System.out.println("pass");
            }else {
                System.out.println("Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}