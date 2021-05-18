package com.ticketservice.core.api;

import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class ApiServiceGenerator {

    private static final String BASE_URL = System.getenv("PARTNER_API_URL");

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S createService (Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
