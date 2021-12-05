package IpmaApi.Client;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Districts {
    
    @SerializedName("globalIdLocal")
    @Expose
    private Integer globalIdLocal;
    @SerializedName("local")
    @Expose
    private String local;
    @SerializedName("idRegiao")
    @Expose
    private Integer idRegiao;
    @SerializedName("idConcelho")
    @Expose
    private Integer idConcelho;
    @SerializedName("idDistrito")
    @Expose
    private Integer idDistrito;
    @SerializedName("idAreaAviso")
    @Expose
    private String idAreaAviso;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    
    public Integer getGlobalIdLocal() {
        return globalIdLocal;
    }
    public void setGlobalIdLocal(Integer globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public Integer getIdRegiao() {
        return idRegiao;
    }
    public void setIdRegiao(Integer idRegiao) {
        this.idRegiao = idRegiao;
    }
    public Integer getIdConcelho() {
        return idConcelho;
    }
    public void setIdConcelho(Integer idConcelho) {
        this.idConcelho = idConcelho;
    }
    public Integer getIdDistrito() {
        return idDistrito;
    }
    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }
    public String getIdAreaAviso() {
        return idAreaAviso;
    }
    public void setIdAreaAviso(String idAreaAviso) {
        this.idAreaAviso = idAreaAviso;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    } 
}
