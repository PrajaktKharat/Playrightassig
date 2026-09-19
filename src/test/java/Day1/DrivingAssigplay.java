package Day1;

import com.microsoft.playwright.*;


public class DrivingAssigplay {

    // Locators
   static String fullNameInput = "#fullname";
    static String addressInput  = "#address";
    static String ageInput  = "#age";
   static String birthPlaceInput = "#placeofbirth";
    static String genderMaleRadio = "#Male";
    static String colorBlindNoCheck= "input[name='color_no']";
    static String languagesSelect = "#languages";
     static  String submitBtn = "button[type='submit']";

    public static void main(String[] args) {

        try (Playwright obj_playwright = Playwright.create()) {

            Browser obj_browser = obj_playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            BrowserContext obj_context = obj_browser.newContext();

            Page obj_page = obj_context.newPage();

            try {

                obj_page.navigate("file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/TestcasesClassAssignment-drivingLicenseUI.html");

                Thread.sleep(1000);
                obj_page.locator(fullNameInput).fill("Nakul");
                Thread.sleep(1000);
                obj_page.locator(addressInput).fill("Pune");
                Thread.sleep(1000);

                obj_page.locator(ageInput).fill("23");
                Thread.sleep(1000);

                obj_page.locator(birthPlaceInput).fill("Buldhana");
                Thread.sleep(1000);

                obj_page.locator(genderMaleRadio).check();
                Thread.sleep(1000);

                obj_page.locator(colorBlindNoCheck).check();
                Thread.sleep(1000);

                obj_page.locator(languagesSelect).selectOption("english");
                Thread.sleep(1000);

                Page newPage = obj_context.waitForPage(() -> {
                    obj_page.locator(submitBtn).click();
                });
                obj_page.waitForTimeout(1000);

                if(newPage.title().equals("Welcome")){
                    System.out.println("pass");
                }else {
                    System.out.println("Fail");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
           e.printStackTrace();
        }

    }
}