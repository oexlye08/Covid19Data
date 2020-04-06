package id.my.okisulton.covid19data.ui.fragment.global.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Global {

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    public Global(Attributes attributes) {
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public class Attributes {

        @SerializedName("Country_Region")
        @Expose
        private String Country_Region;

        @SerializedName("Confirmed")
        @Expose
        private String Confirmed;

        @SerializedName("Deaths")
        @Expose
        private String Deaths;

        @SerializedName("Recovered")
        @Expose
        private String Recovered;

        public String getCountry_Region() {
            return Country_Region;
        }

        public void setCountry_Region(String country_Region) {
            Country_Region = country_Region;
        }

        public String getConfirmed() {
            return Confirmed;
        }

        public void setConfirmed(String confirmed) {
            Confirmed = confirmed;
        }

        public String getDeaths() {
            return Deaths;
        }

        public void setDeaths(String deaths) {
            Deaths = deaths;
        }

        public String getRecovered() {
            return Recovered;
        }

        public void setRecovered(String recovered) {
            Recovered = recovered;
        }
    }


}
