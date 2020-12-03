package JSONExperiments;

import com.google.gson.annotations.SerializedName;

public class CovidHighLevel {
    @SerializedName("Message")
    private String message;

    @SerializedName("Date")
    private String date;

    @SerializedName("Countries")
    private CovidCountryInfo[] countries;

    public CovidHighLevel(String message, String date, CovidCountryInfo[] countries) {
        this.message = message;
        this.date = date;
        this.countries = countries;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
