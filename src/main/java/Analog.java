import java.util.HashMap;
import java.util.Map;

public class Analog extends Main{
    private Map<Object, Object> map = new HashMap<>();

    public Map setMap() {
        map.put("name", this.name);
        map.put("UrlProduct", this.UrlProduct);
        map.put("UrlPicture", this.UrlPicture);
        map.put("price", this.price);
        return map;
    }

    private String name;
    private String UrlProduct;
    private String UrlPicture;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlProduct() {
        return UrlProduct;
    }

    public void setUrlProduct(String urlProduct) {
        UrlProduct = urlProduct;
    }

    public String getUrlPicture() {
        return UrlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        UrlPicture = urlPicture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
