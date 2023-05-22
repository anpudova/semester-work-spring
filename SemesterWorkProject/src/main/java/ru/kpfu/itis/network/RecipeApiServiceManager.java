package ru.kpfu.itis.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeApiServiceManager {
    private static final String APP_ID = "d3b19e09c8fa414db052bd9b050a7976";
    private static final String BASE_URL = "https://api.spoonacular.com/";

    private static final OkHttpClient okHttpClient = getOkHttpClient();
    private static final RecipeApiService retrofitInstance = createRetrofitInstance();

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    okhttp3.HttpUrl modifiedUrl = chain.request().url().newBuilder()
                            .addQueryParameter("apiKey", APP_ID)
                            .build();

                    okhttp3.Request request = chain.request().newBuilder().url(modifiedUrl).build();
                    return chain.proceed(request);
                });
        return client.build();
    }

    private static RecipeApiService createRetrofitInstance() {
        Retrofit retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitBuilder.create(RecipeApiService.class);
    }

    public static RecipeApiService getInstance() {
        return retrofitInstance;
    }
}
