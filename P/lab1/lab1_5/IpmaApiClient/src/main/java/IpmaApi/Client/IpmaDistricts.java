package IpmaApi.Client;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IpmaDistricts {
    
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("data")
    @Expose
    private List<Districts> data = null;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Districts> getData() {
        return data;
    }

    public void setData(List<Districts> data) {
        this.data = data;
    }
}
