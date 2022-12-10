package com.example.term_project.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {
    // 클라이언트가 연결할 서버의 주소
    private final static String BASE_URL = "http://www.seop.site";

    /** Retrofit 이란?
     * 서버와 클라이언트 간 http 통신을 위한 라이브러리이다.
     * 더 쉽게 말하자면 안드로이드에서 http 통신을 할 수 있도록 도와주는 놈이다.
     */
    /** Gson 이란?
     * Gson은 자바 객체와 JSON 간의 직렬화 및 역직렬화를 위한 오픈소스 자바 라이브러리이다.
     */
    public static Retrofit getRetrofit(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
