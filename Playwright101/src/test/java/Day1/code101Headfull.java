package Day1;

import com.microsoft.playwright.*;

public class code101Headfull {
//headful
    public static void main(String[] args) {
        try (Playwright objPlayright  =  Playwright.create()){

            Browser objbrow = objPlayright.chromium().launch
                    (new BrowserType.LaunchOptions().setHeadless(false));

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
