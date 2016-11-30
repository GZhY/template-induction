package templateGenerating.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class InputBeans {
    private String url;
    private List<InputBean> inputBeans;

    public String getUrl() {
        return url;
    }
    @JsonProperty("Url")
    public void setUrl(String url) {
        this.url = url;
    }

    public List<InputBean> getInputBeans() {
        return inputBeans;
    }
    @JsonProperty("Documents")
    public void setInputBeans(List<InputBean> inputBeans) {
        this.inputBeans = inputBeans;
    }
}
