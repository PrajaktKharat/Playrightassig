package Day1;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class code101 {

    public static void main(String[] args) {
//head less
        try (Playwright objPlayright  =  Playwright.create()){

            Browser objbrow = objPlayright.chromium().launch();

            BrowserContext objcontext = objbrow.newContext();

            Page objpage = objcontext.newPage();

            objpage.navigate("https://example.com");

            System.out.println("Browser Version : " + objbrow.version());

            System.out.println("page title " + objpage.title());

            System.out.println("Works Correctly");

            objpage.waitForTimeout(2000);

            objpage.close();
        }catch (Exception e){
            System.out.println("faild");
            e.printStackTrace();
        }


    }
}
