package com.sha.springbootmicroservice3gateway.request;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;


@Configuration
public class RetrofitConfiguration
{
    @Value("${retrofit.timeout}")
    private Long TIMEOUT_IN_SECS;

    @Bean
    public OkHttpClient keyClient()
    {
        return createDefaultClientBuilder()
                .addInterceptor(interceptor -> interceptor.proceed(interceptor.request().newBuilder()

                        .build()))
                .build();
    }

    @Bean
    public Retrofit.Builder keyBuilder(OkHttpClient keyClient, Gson gson)
    {
        return new Retrofit.Builder()
                .client(keyClient)
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    private OkHttpClient.Builder createDefaultClientBuilder()
    {
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS);
    }
    // product servisi için istek beani
    @Bean
    public IUserServiceRequest productServiceRequest(Retrofit.Builder keyBuilder,
                                                     @Value("${product.service.url}") String baseUrl)
    {
        return keyBuilder
                .baseUrl(baseUrl)
                .build()
                .create(IUserServiceRequest.class);
    }

    @Bean
    public IEventServiceRequest transactionServiceRequest(Retrofit.Builder keyBuilder,
                                                          @Value("${transaction.service.url}") String baseUrl)
    {
        return keyBuilder
                .baseUrl(baseUrl)
                .build()
                .create(IEventServiceRequest.class);
    }
}
