package revision;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Dragdropheru {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()){

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://the-internet.herokuapp.com/drag_and_drop");

            Locator colA = page.locator("#column-a");
            Locator colB = page.locator("#column-b");

            page.dragAndDrop("#column-a", "#column-b");

            System.out.println(colA.innerText());
            System.out.println(colA.textContent());
            if (colA.innerText().contains("B")){
                System.out.println("ietem is drage And drop");
            }else {
                System.out.println("Fail to drag and drop");
            }


            browser.close();
        }
    }
}