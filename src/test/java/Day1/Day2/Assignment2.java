package Day2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;


public class Assignment2 {
        //id by dropdown element
        public static void main(String[] args) {

            try(Playwright playwright = Playwright.create()){

                Browser browser  = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                );

                Page page = browser.newPage();
                page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/ControlsPractice.html");


                Locator Modulee = page.locator("#module");
                Modulee.selectOption("CCST");
                Thread.sleep(1000);


                Modulee.selectOption(new SelectOption().setLabel("DAI"));


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
