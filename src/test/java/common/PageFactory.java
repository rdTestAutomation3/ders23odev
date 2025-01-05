package common;

import pages.ButtonPage;
import pages.WebTablePage;

public class PageFactory {

    public static ButtonPage buildButtonPage() {
        return new ButtonPage("/buttons");
    }

    public static WebTablePage buildWebTablePage() {
        return new WebTablePage("/webtables");
    }

}