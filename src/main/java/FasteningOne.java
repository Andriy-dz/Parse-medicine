public class FasteningOne extends Main{
    private Analogs analogs = new Analogs();

    public Analogs getAnalogs() {
        return analogs;
    }

    public void setAnalogs(Analogs analogs) {
        this.analogs = analogs;
    }

    private AlsoBuy alsoBuy = new AlsoBuy();

    public AlsoBuy getAlsoBuy() {
        return alsoBuy;
    }

    public void setAlsoBuy(AlsoBuy alsoBuy) {
        this.alsoBuy = alsoBuy;
    }

    private String id;
    private String name;
    private String articul;
    private String urlPicture;
    private String urlPage;
    private String description;
    private String instruction;
    private String producer;
    private String way;
    private String[] ways;
    private String[] waysURL;
    private String price;
    private String oldPrice;

    public String getArticul() {return articul;}
    public void setArticul(String articul) {this.articul = articul;}

    public String getUrlPicture() {return urlPicture;}
    public void setUrlPicture(String urlPicture) {this.urlPicture = urlPicture;}

    public String getUrlPage() {return urlPage;}
    public void setUrlPage(String urlPage) {this.urlPage = urlPage;}

    public String getDescription() { return description;}
    public void setDescription(String description) {this.description = description;}

    public String getInstruction() {return instruction;}
    public void setInstruction(String instruction) {this.instruction = instruction;}

    public String getProducer() {return producer;}
    public void setProducer(String producer) {this.producer = producer;}

    public String getWay() { return way; }
    public void setWay(String way) {this.way = way; }

    public String[] getWays() { return ways; }
    public void setWays(String[] ways) {this.ways = ways;}

    public String[] getWaysURL() { return waysURL; }
    public void setWaysURL(String[] waysURL) {this.waysURL = waysURL; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getOldPrice() {return oldPrice; }
    public void setOldPrice(String oldPrice) { this.oldPrice = oldPrice; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
