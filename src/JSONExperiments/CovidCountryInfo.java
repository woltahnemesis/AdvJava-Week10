package JSONExperiments;

import com.google.gson.annotations.SerializedName;

public class CovidCountryInfo {
    @SerializedName("TotalConfirmed")
    private String totalConfirmed;

    @SerializedName("Country")
    private String country;

    public CovidCountryInfo(String totalConfirmed, String country) {
        this.totalConfirmed = totalConfirmed;
        this.country = country;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
