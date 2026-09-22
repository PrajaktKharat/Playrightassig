package revision;

import com.microsoft.playwright.*;

public class Herokuautomation {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()){

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext contextBrow = browser.newContext();

            Page page = browser.newPage();


            page.navigate("https://the-internet.herokuapp.com/");


            Locator AddRemove = page.locator("//a[@href='/add_remove_elements/']");

            AddRemove.click();

            String url = page.url();
            System.out.println("Url is :"+ url);

            if (url.contains("add_remove_elements")){
                System.out.println("Pass for addremove click");
            }else {
                System.out.println("Fail for addremove click");
            }

            Locator clickAddele = page.locator("//button[@onclick='addElement()']");
            clickAddele.click();

            if (clickAddele.isVisible()){
                System.out.println("Pass for Add button");
            }else {
                System.out.println("Fail for Add button");
            }


            Locator clickDelet = page.locator("//button[@class='added-manually']");
            clickDelet.click();


            if (clickDelet.isVisible()){
                System.out.println("Fail For no deleted");
            }else {
                System.out.println("Pass element is deleted");
            }


            contextBrow.close();
        }


    }
}
