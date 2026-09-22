package Day1;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.Map;

public class simulation2 {

    static final String LOGIN_URL = "file:///C:/Users/CCST/Desktop/Playwright101/playrightdrivehtml/login.html";

    public static void main(String[] args) {

        try (Playwright obj_playwright = Playwright.create()) {

            Browser obj_browser = obj_playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false));

            // FIX 1: Grant "geolocation" permissions in context options
            BrowserContext obj_iphone15ProMaxContext = obj_browser.newContext(
                    new Browser.NewContextOptions()
                            .setGeolocation(48.8566, 2.3522)

            );

            Page obj_page = obj_iphone15ProMaxContext.newPage();

            obj_page.navigate(LOGIN_URL);
            obj_page.locator("[data-testid='username-input']").fill("validUser");
            obj_page.locator("[data-testid='password-input']").fill("validPassword");

            Page obj_controlspage = obj_iphone15ProMaxContext.waitForPage(() -> {
                obj_page.locator("[data-testid='submit-btn']").click();
            });

            obj_controlspage.waitForLoadState();

            Map<String, Object> location = (Map<String, Object>) obj_controlspage.evaluate(
                    "() => new Promise((resolve, reject) => {"
                            + "   navigator.geolocation.getCurrentPosition("
                            + "       p => resolve({"
                            + "           lat: p.coords.latitude,"
                            + "           lon: p.coords.longitude"
                            + "       }),"
                            + "       e => reject(e.message)"
                            + "   );"
                            + "})"
            );

            System.out.println("Latitude: " + location.get("lat"));
            System.out.println("Longitude: " + location.get("lon"));

            String url = obj_controlspage.url();
            System.out.println("Navigated to: " + url);
            if (!url.contains("ControlsPractice.html")) {
                throw new AssertionError("Navigation failed. Expected ControlsPractice.html but got: " + url);
            }

            String title = obj_controlspage.title();
            System.out.println("Page Title: " + title);

            obj_iphone15ProMaxContext.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}