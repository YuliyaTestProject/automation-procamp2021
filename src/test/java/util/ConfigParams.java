package util;

public class ConfigParams {

    String browser;
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public ConfigParams(){

    }

    @Override
    public String toString() {
        return "ConfigParams{" +
                ", browser='" + browser + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
