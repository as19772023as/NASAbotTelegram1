package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Utils {
    // можно короче
//    private static CloseableHttpClient httpClient = HttpClientBuilder.create()
//            .setDefaultRequestConfig(RequestConfig.custom()
//                    .setConnectTimeout(5000)
//                    .setSocketTimeout(30000)
//                    .setRedirectsEnabled(false)
//                    .build())
//            .build();

    //Настраиваем наш HTTP клиент, который будет отправлять запросы
    private static CloseableHttpClient httpClient = HttpClients.createDefault();


    //Сущность, которая будет преобразовывать ответ в наш объект NASA
    private static ObjectMapper mapper = new ObjectMapper();

    public static String getUrl(String url) throws IOException {
        // посылЗапроса в Наса
        CloseableHttpResponse response = httpClient.execute(new HttpGet(url));

        // преобразОтвет в Джава-объект nasaObject
        NasaObject nasaObject = mapper.readValue(response.getEntity().getContent(), NasaObject.class);

        // возвращ строчку с адресом

        return nasaObject.getUrl();
    }

}