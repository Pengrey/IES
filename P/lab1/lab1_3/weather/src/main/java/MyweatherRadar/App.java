package MyweatherRadar;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import MyweatherRadar.IpmaCityForecast;
import MyweatherRadar.IpmaService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
    private static final int CITY_ID_AVEIRO = 1010500;
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void  main(String[] args ) {

        // Check number of arguments
        if(args.length != 1){
            System.out.println("Please add only one argument (City code)");
            //logger.error("")
            // Terminate JVM
            System.exit(0);
        }

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(Integer.parseInt(args[0]));

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info( "max temp for today: " + forecast.getData().
                        listIterator().next().getTMax());
            } else {
                logger.info( "No results!");
            }
            
            // Terminate JVM
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
