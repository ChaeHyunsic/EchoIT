package com.example.term_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // 기존의 fragment를 저장
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        // mapView에 대한 기본 설정
        MapView mapView = (MapView) rootView.findViewById(R.id.map_mapView_sm);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();     // mapView 시작
        mapView.getMapAsync(this);      // mapView 콜백 설정

        return rootView;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        // 울산대 좌표
        LatLng latLng = new LatLng(35.5438, 129.2563);

        // 지도 초기 화면 설정
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));        // 지도의 좌표를 지정된 위치로 이동 , 지도의 확대 비율 설정


        // 순차적으로 마커를 추가
        for (int i=0; i<15; i++){
            MarkerOptions markerOptions = setMarkerOptions(i);
            Marker marker = googleMap.addMarker(markerOptions);     // 지정된 마커 옵션으로 마커 추가
        }
    }

    // 마커 옵션 설정
    public MarkerOptions setMarkerOptions(int index){
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(getLatLng(index));       // 마커의 위치 설정
        markerOptions.title(getTitle(index));           // 마커 타이틀 설정
        markerOptions.snippet(getSnippet(index));       // 마커 상세 설명 설정

        return markerOptions;
    }

    // 건물의 좌표 저장
    public LatLng getLatLng(int index){
        Double[] lat = {35.5448, 35.5451, 35.5442, 35.5443, 35.5431, 35.5447, 35.5436, 35.5426, 35.5421, 35.545, 35.5442, 35.5448, 35.5454, 35.5427, 35.5465};
        Double[] lng = {129.2557, 129.255, 129.2546, 129.2558, 129.2567, 129.257, 129.2556, 129.2575, 129.2576, 129.2539, 129.254, 129.2586, 129.2528, 129.2554, 129.2554};
        return new LatLng(lat[index], lng[index]);
    }

    // 건물의 이름 저장
    public String getTitle(int index){
        String[] buildName = {"화학공학관", "기계항공관", "산학협력리더스쿨", "전기/컴퓨터공학관", "자연과학관", "대학회관/해송홀", "문수관", "인문관", "사회과학관", "재료/산업공학관", "기초과학실험동", "학생회관", "산학협동관", "생활과학관", "국제관"};
        return buildName[index];
    }

    // 건물의 번호 저장
    public String getSnippet(int index){
        String[] buildNumber = {"1호관", "2호관", "5호관", "7호관", "8호관", "9호관", "10호관", "14호관", "15호관", "18호관", "19호관", "22호관", "35호관", "37호관", "43호관"};
        return buildNumber[index];
    }
}