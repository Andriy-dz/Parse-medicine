import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class Product extends Main{
    private static Document GetPage(String url) throws IOException {
        Document a;
        while(true) {
            a = Jsoup.parse(new URL(url), 1000000);
            if (a!=null){return a;}
        }
    }
    public static void product(String url) throws IOException {
        int lenghtArrayWay;
        int indexArrayWay;
        int lenghtArrayAnalog;
        int indexArrayAnalog;
        int lenghtArrayAloBaing;
        int indexArrayAlsoBaing ;
        ObjectMapper objectMapper = new ObjectMapper();
        Analogs analogs = new Analogs();
        AlsoBuy alsoBuy = new AlsoBuy();
        AllOfData allOfData = new AllOfData();
        FasteningOne fasteningOne = new FasteningOne();
        Document page = GetPage(url);

        fasteningOne.setUrlPage(url);

        Element forID = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=bx_item_detail bx_blue]");

        fasteningOne.setId(forID.attr("id"));                                                                                              // get id

        Element forName = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=bx_item_detail bx_blue]").selectFirst("span[itemprop=name]");

        fasteningOne.setName(forName.text());                                                                                                        //get Name product

        Elements elementsDT = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=bx_item_detail bx_blue]").selectFirst("div[itemprop=brand]").select("dt");
        Elements elementsDD = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=bx_item_detail bx_blue]").selectFirst("div[itemprop=brand]").select("dd");
        i = 1;
        for(Element element :elementsDT){
            if(element.text().equals("Артикул")){
                int j = 1;
                for(Element el:elementsDD){

                    if (j == i){

                        fasteningOne.setArticul(el.text());                                                                                           //get Articule of product

                    }
                    j++;
                }
            }
            if(element.text().equals("Производитель")){
                int j = 1;
               for(Element el:elementsDD){
                   if (j == i){

                        fasteningOne.setProducer(el.text());                                                                                      // get producer

                   }
                   j++;
               }
            }
            i++;
        }

        Element URLPictire = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=bx_item_detail bx_blue]").selectFirst("img[itemprop=image]");

        fasteningOne.setUrlPicture("https://online-apteka.com.ua/" + URLPictire.attr("src"));                                              //get url of picture


        Element forDescription = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=tab_containers]");

        fasteningOne.setDescription(forDescription.text());                                                                                       // get Description

        Element forInctruction = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=tab_containers]").selectFirst("div[class=tab_3_conts]").selectFirst("p[class=MsoNormal]");
        if(forInctruction==null) {
            forInctruction = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=tab_containers]").selectFirst("div[class=tab_3_conts]").selectFirst("span");

            fasteningOne.setInstruction(forInctruction.text());                                                                                      //get Instruction
        }else{fasteningOne.setInstruction(forInctruction.text());}

        Elements ways = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=bx-breadcrumb]").select("div[class=bx-breadcrumb-item]");
        String w = "";
        lenghtArrayWay = 0;

        // determining the number of elements for an arrays Name and URL

        for(Element way:ways){
            lenghtArrayWay++;
        }
        String[] name = new String[lenghtArrayWay];
        String[] URL = new String[lenghtArrayWay];
        indexArrayWay = 0;
        URL[0] = indexArrayWay + " елемент = https://online-apteka.com.ua/";
        for(Element way:ways){
            w = w + way.text() ;

            fasteningOne.setWay(w);                                                                                                      // get Way

            name[indexArrayWay] ="/" + way.text();
            if (indexArrayWay!=0){
                URL[indexArrayWay] =indexArrayWay + " елемент = https://online-apteka.com.ua/" + w;

            }
            fasteningOne.setWays(name);                                                                                                  // get array of Way
            fasteningOne.setWaysURL(URL);                                                                                                // get array of URL to way

            indexArrayWay++;
        }

        Element forOldPrice  = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=bx_item_detail bx_blue]").selectFirst("div[class=bx_rt]").selectFirst("div[class=item_old_price]");

        if(forOldPrice != null){
            fasteningOne.setOldPrice(forOldPrice.text());                                                                                //get old price
        }

        forOldPrice = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[class=col-md-9 col-sm-8]").selectFirst("div[class=bx_item_detail bx_blue]").selectFirst("div[class=bx_rt]").selectFirst("meta[itemprop=price]");

        fasteningOne.setPrice(forOldPrice.attr("content"));                                                                   //get Price

        Elements elementsAnalogs = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").select("li[class=right-list]");
        lenghtArrayAnalog = 0;

        // calculate the number of analogues

        if(elementsAnalogs!=null){
            for(Element element:elementsAnalogs){
                lenghtArrayAnalog++;
            }
        }
        indexArrayAnalog = 0;

        // I throw all the agalons in the array "analogig[]"

        if(elementsAnalogs!=null){
            Map analogig[] = new Map[lenghtArrayAnalog];
            for(Element element:elementsAnalogs){
                Analog analog = new Analog();
                Element forURLProductAnalog = element.selectFirst("a[class=slider_catalog_item_images]");
                if(forURLProductAnalog!=null) {
                    analog.setUrlProduct("https://online-apteka.com.ua/" + forURLProductAnalog.attr("href"));                // get URL to product
                }

                Element forPictureAnalog = element.selectFirst("img[width=195]");
                if(forPictureAnalog!=null) {
                    analog.setUrlPicture("https://online-apteka.com.ua/" + forPictureAnalog.attr("src"));                    //get URL t picture
                }
                Element forNameAnalog = element.selectFirst("span[class=name_element]");
                if(forNameAnalog!=null) {
                    analog.setName(forNameAnalog.text());                                                                              //get name product
                }

                Element forPrice = element.selectFirst("span[class=element_price]");
                if(forPrice!=null) {
                    analog.setPrice(forPrice.text());                                                                                  // get price
                }
                analogig[indexArrayAnalog] = analog.setMap();                                                                          // all data set to array "analogig[]"
                indexArrayAnalog++;
            }
        analogs.setAnalog(analogig);                                                                                                   // all data from "analogig" transfer "analogs"
        }

        Element tableAlsoBaing = page.selectFirst("div[class=bx-wrapper]").selectFirst("div[class=container bx-content-seection]").selectFirst("div[style=display: block;]").selectFirst("div[class=wrap_slider]");
        if(tableAlsoBaing!=null) {
            Elements elementsAlsoBaing = tableAlsoBaing.select("a[target=blank]");

            // calculate the number of analogues

            lenghtArrayAloBaing = 0;
            if(elementsAlsoBaing!=null){
                for(Element element:elementsAlsoBaing){
                    lenghtArrayAloBaing++;
                }
            }
            indexArrayAlsoBaing = 0;


            // I throw all the analons in the array "alsoBaing[]"

            if(elementsAlsoBaing!=null){
                Map alsoBaing[] = new Map[lenghtArrayAloBaing];
                for(Element element:elementsAlsoBaing){
                    Analog alsobay = new Analog();
                    Element forURLProductAlsoBaing = element.selectFirst("a[class=slider_catalog_item_images]");
                    if(forURLProductAlsoBaing!=null) {
                        alsobay.setUrlProduct("https://online-apteka.com.ua/" + forURLProductAlsoBaing.attr("href"));     // get URL to product
                    }

                    Element forPictureAlsoBaing = element.selectFirst("img[width=195]");
                    if(forPictureAlsoBaing!=null) {
                        alsobay.setUrlPicture("https://online-apteka.com.ua/" + forPictureAlsoBaing.attr("src"));         //get URL t picture
                    }
                    Element forNameAlsoBaing = element.selectFirst("span[class=name_element]");
                    if(forNameAlsoBaing!=null) {
                        alsobay.setName(forNameAlsoBaing.text());                                                                    //get name product
                    }

                    Element forPriceAlsoBaing = element.selectFirst("span[class=element_price]");
                    if(forPriceAlsoBaing!=null) {
                        alsobay.setPrice(forPriceAlsoBaing.text());                                                                  // get price
                    }
                    alsoBaing[indexArrayAlsoBaing] = alsobay.setMap();                                                               // all data set to array "alsoBaing[]"
                    indexArrayAlsoBaing++;
                }
                alsoBuy.setAlsoBay(alsoBaing);
            }
        }

        fasteningOne.setAlsoBuy(alsoBuy);                                                                                           // all data from "fasteningOne" transfer "analogs"
        fasteningOne.setAnalogs(analogs);                                                                                           // all data from "fasteningOne" transfer "analogs"
        allOfData.setFasteningOne(fasteningOne);                                                                                    // all data from "allOfData" transfer "fasteningOne"
        String JSON = objectMapper.writeValueAsString(allOfData);                                                                   //parse to JSON
        System.out.println(JSON);
        aaa++;
    }
}
