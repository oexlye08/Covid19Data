package id.my.okisulton.covid19data.ui.fragment.indonesia.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Provinsi {
    @SerializedName("attributes")
    @Expose
    private Atribute atribute;

    public Provinsi(Atribute atribute) {
        this.atribute = atribute;
    }

    public Atribute getAtribute() {
        return atribute;
    }

    public void setAtribute(Atribute atribute) {
        this.atribute = atribute;
    }


    /** InnerClass*/
    public class Atribute {
        @SerializedName("Provinsi")
        @Expose
        private String Provinsi;

        @SerializedName("Kasus_Posi")
        @Expose
        private String Kasus_Posi;

        @SerializedName("Kasus_Semb")
        @Expose
        private String Kasus_Semb;

        @SerializedName("Kasus_Meni")
        @Expose
        private String Kasus_Meni;

        public String getProvinsi() {
            return Provinsi;
        }

        public void setProvinsi(String provinsi) {
            Provinsi = provinsi;
        }

        public String getKasus_Posi() {
            return Kasus_Posi;
        }

        public void setKasus_Posi(String kasus_Posi) {
            Kasus_Posi = kasus_Posi;
        }

        public String getKasus_Semb() {
            return Kasus_Semb;
        }

        public void setKasus_Semb(String kasus_Semb) {
            Kasus_Semb = kasus_Semb;
        }

        public String getKasus_Meni() {
            return Kasus_Meni;
        }

        public void setKasus_Meni(String kasus_Meni) {
            Kasus_Meni = kasus_Meni;
        }
    }
}
