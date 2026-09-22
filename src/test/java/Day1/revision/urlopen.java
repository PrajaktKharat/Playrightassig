package revision;

import com.microsoft.playwright.*;

public class urlopen {

    public static void main(String[] args) {


        try(Playwright obj_playwright = Playwright.create()){

            Browser obj_browser = obj_playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext obj_context = obj_browser.newContext();

            Page obj_page = obj_context.newPage();

            obj_page.navigate("https://www.saucedemo.com/");

            System.out.println(obj_page.title());

            Locator obj_username = obj_page.locator("#user-name");
            obj_username.fill("standard_user");

            Thread.sleep(2000);


            Locator obj_password = obj_page.locator("#password");
            obj_password.fill("secret_sauce");

            Thread.sleep(2000);


            Locator obj_submitbutton = obj_page.locator("#login-button");
            obj_submitbutton.click();

           obj_page.waitForTimeout(2000);

           String newurl = obj_page.url();

            System.out.println("url is : " + obj_page.url());

            if (newurl.contains("inventory.html")){
                System.out.println("pass");
            }else{
                System.out.println("fail");
            }

//            if(obj_page.url().equals("https://www.saucedemo.com/inventory.html")){
//                System.out.println("Pass");
//            }else {
//                System.out.println("Fail");
//            }








        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
