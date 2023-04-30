package ru.kpfu.itis.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeService {
    private static final String APP_ID = "b4a87e7f376b4f5ea7633a46b84d5e8d";
    private static final String BASE_URL = "https://api.spoonacular.com/";

    private static OkHttpClient okHttpClient = getOkHttpClient();
    private static RecipeApiService retrofitInstance = createRetrofitInstance();

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
