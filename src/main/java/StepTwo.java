import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


class MyThread extends Thread{
    public void setUrl(Element url) {
        this.url = url;
    }

    Element url;


    @Override
    public void run(){
        try {
            Product.product("https://online-apteka.com.ua/" + url.attr("href"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class StepTwo {
    private static Document GetPage(String url) throws IOException {
        Document a = Jsoup.parse(new URL(url), 1000000);
        return a;
    }
    public static void stepTwo(String url) throws IOException  {
        Document page = GetPage(url);

        Element goods = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=row]").selectFirst("div[class=col-xs-12]").selectFirst("div[class=bx_catalog_list_home col4 bx_blue]");
        if(goods == null){
            goods = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=row]").selectFirst("div[class=col-xs-12]").selectFirst("div[class=bx_catalog_list_home col3 bx_blue]");
        }
        if(goods != null){
            Elements good = goods.select("div[class=bx_catalog_item]");
            for(Element list:good){
                Element ur = list.selectFirst("a[class=bx_catalog_item_images]");
                MyThread myThread = new MyThread();
                myThread.setUrl(ur);
                myThread.start();
            }
        }
        Element pageOfSite = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=row]").selectFirst("div[class=col-xs-12]").selectFirst("div[class=bx-pagination]");
        if(pageOfSite != null){
            Element nextPage = pageOfSite.selectFirst("li[class=bx-pag-next]");
            Element e = nextPage.select("a[rel=nofollow]").first();
            if(e != null){
                StepTwo.stepTwo("https://online-apteka.com.ua/" + e.attr("href"));
            }
        }
    }
}
