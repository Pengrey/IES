package IpmaApi.Client;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Client
{
    public static String GetTemperature(String cityName){
        int ID = 0;
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.ipma.pt/open-data/").addConverterFactory(GsonConverterFactory.create()).build();

        IpmaService service = retrofit.create(IpmaService.class);

        Call<IpmaDistricts> alldistricts = service.getDistricts();
        // Try get districts
        try {
            Response<IpmaDistricts> api = alldistricts.execute();
            IpmaDistricts districts = api.body();

            if (districts != null) {
                List<Districts> districtsList = districts.getData();
                for (Districts d: districtsList) {
                    if (d.getLocal().equalsIgnoreCase(cityName)) {
                        ID = d.getGlobalIdLocal();
                        break;
                    }
                }
            } else {
                return "Disctrics API gives no response";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Check if the city name given has an ID
        if (ID == 0){
            return "City name doesnt exist"; 
        }

        Call<IpmaCityForecast> callSync = service.getForecastForACity(ID);
        // Try get weather
        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                return "Max temp for today:" + forecast.getData().listIterator().next().getTMax();
            } else {
                return "Weather API gives no response";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Failsafe
        return "Something went wrong";
    }
}
