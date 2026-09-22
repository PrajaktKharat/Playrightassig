package revision;

import com.microsoft.playwright.*;

public class DropDown {
    public static void main(String[] args) {

   try(Playwright playwright = Playwright.create()){

       Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

       BrowserContext contextBrow = browser.newContext();

       Page page = browser.newPage();

page.waitForTimeout(2000);
       page.navigate("https://the-internet.herokuapp.com/");
       Locator dropdown = page.getByText("Dropdown");

       dropdown.click();

       page.waitForTimeout(2000);
       Locator dropdownSelect = page.locator("#dropdown");
       dropdownSelect.selectOption("1");


       if(dropdownSelect.inputValue().equals("1")){
           System.out.println("Pass");
       }else {
           System.out.println("fail");
       }
       page.waitForTimeout(2000);



   }


    }
}
