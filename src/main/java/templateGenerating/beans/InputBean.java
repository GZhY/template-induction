package templateGenerating.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class InputBean {
    private String mainContent;
    private String publishTime;
    private String user;
    private String reservedField1;
    private String reservedField2;
    private String reservedField8;
    private String reservedField10;

    public String getMainContent() {
        return mainContent;
    }

    @JsonProperty("MainContent")
    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public String getPublishTime() {
        return publishTime;
    }

    @JsonProperty("PublishTime")
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getUser() {
        return user;
    }

    @JsonProperty("User")
    public void setUser(String user) {
        this.user = user;
    }

    public String getReservedField1() {
        return reservedField1;
    }

    @JsonProperty("ReservedField1")
    public void setReservedField1(String reservedField1) {
        this.reservedField1 = reservedField1;
    }

    public String getReservedField2() {
        return reservedField2;
    }

    @JsonProperty("ReservedField2")
    public void setReservedField2(String reservedField2) {
        this.reservedField2 = reservedField2;
    }

    public String getReservedField8() {
        return reservedField8;
    }

    @JsonProperty("ReservedField8")
    public void setReservedField8(String reservedField8) {
        this.reservedField8 = reservedField8;
    }

    public String getReservedField10() {
        return reservedField10;
    }

    @JsonProperty("ReservedField10")
    public void setReservedField10(String reservedField10) {
        this.reservedField10 = reservedField10;
    }
}
