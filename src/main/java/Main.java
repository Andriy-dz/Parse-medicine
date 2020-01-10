import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;



public class Main {
    static int i = 0;
    static int aaa = 0;
    private static Document GetPage() throws IOException {
        String url = "https://online-apteka.com.ua/catalog/";
        Document a = Jsoup.parse(new URL(url), 1000000);
        return a;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Document page = GetPage();
        Elements catalogs = page.select("div[class=bx-wrapper]").select("div[class=container bx-content-seection]").select("li[itemtype=http://schema.org/ItemList]");
        for(Element el:catalogs){
            Element cata = el.select("a[class=bx_catalog_tile_title]").first();
            StepTwo.stepTwo("https://online-apteka.com.ua/" + cata.attr("href"));
        }
        System.out.println(aaa);
    }

}