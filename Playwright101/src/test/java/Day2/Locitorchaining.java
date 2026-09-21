package Day2;

import com.microsoft.playwright.*;

import java.util.List;

public class Locitorchaining {
    public static void main(String[] args) {

        try(Playwright playwright =  Playwright.create()){
            Browser obj_browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext context = obj_browser.newContext();

            Page Controlpage = context.newPage();

            Controlpage.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/ControlsPractice.html");

            Locator dropdwon = Controlpage.locator("#module");

            List<String> textOption = dropdwon.locator("option").allInnerTexts();

            System.out.println("Itam found " + textOption);

            dropdwon.selectOption("CCST");

            Locator row = Controlpage.locator("Table").locator("tbody").locator("tr");

            Locator rows = Controlpage.locator("table tbody tr");

            int rowcount = row.count();
            System.out.println("Row count" + rowcount);

            Thread.sleep(2000);

            for(int i = 0; i < rowcount; i++){
                Locator rowq = rows.nth(i);

                Locator markinput = rowq.locator("input[type='number']");

                markinput.fill("9" + i);

                Locator savebut = Controlpage.locator("#saveButton");

                System.out.println("Button Enable " + savebut.isEnabled());

                savebut.click();

                Controlpage.waitForTimeout(2000);
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
