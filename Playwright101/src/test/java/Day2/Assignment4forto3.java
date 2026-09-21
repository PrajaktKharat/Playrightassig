package Day2;

import com.microsoft.playwright.*;

import java.util.List;

public class Assignment4forto3 {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/LocatorFiltering.html");
            page.waitForTimeout(1000);
            Locator targetContainer = page.locator("#targetContainer");

//            for (int item = 1; item <= 3; item++) {
//                Locator itemToDrag = page.locator("#item" + item);
//                itemToDrag.dragTo(targetContainer);
//            }
//            page.waitForTimeout(3000);

            // by us.first(),useall

page.waitForTimeout(2000);
            Locator targetcontainer = page.locator("#targetContainer");
            Locator items = page.locator("#sourceContainer .draggable-item");


            while (items.count() > 0) {
                items.first().dragTo(targetcontainer);
            }

            Locator msg = page.locator("#result");


            System.out.println(msg.textContent());
            if((msg.textContent().equals("Write Selenium Tests moved to Done"))){
                System.out.println("pass");
            }
            else{
                System.out.println("Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

