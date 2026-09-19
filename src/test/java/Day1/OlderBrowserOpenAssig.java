package Day1;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class OlderBrowserOpenAssig {

    public static void main(String[] args) {
        try (Playwright objPlayright  =  Playwright.create()){

            Browser objbrow = objPlayright.chromium().launch
                    (new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe")));

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
