package com.example.term_project;

import android.content.Context;
import android.widget.TextView;

public class TimeTable {
    private String monday[] = new String[12];
    private String tuesday[] = new String[12];
    private String wednesday[] = new String[12];
    private String thursday[] = new String[12];
    private String friday[] = new String[12];
    public TimeTable(){
        for(int i=0;i<12;i++){
            monday[i]="";
            tuesday[i]="";
            wednesday[i]="";
            thursday[i]="";
            friday[i]="";
        }
    }

    public void addTimeTable(String timeText){
        int temp;
        // 요일 정보 위치 파악
        if((temp = timeText.indexOf("월")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    monday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1] = "수업";
                }
            }
        }
        if((temp = timeText.indexOf("화")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    tuesday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1] = "수업";
                }
            }
        }
        if((temp = timeText.indexOf("수")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    wednesday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1] = "수업";
                }
            }
        }
        if((temp = timeText.indexOf("목")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']') {
                    endPoint = i;
                    thursday[Integer.parseInt(timeText.substring(startPoint + 1, endPoint)) - 1] = "수업";
                }
            }
        }
        if((temp = timeText.indexOf("금")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    friday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1] = "수업";
                }
            }
        }
    }

    // 시간표 중복 피하기
    public boolean validate(String timeText){
        // 빈값이면 당연히 ok
        if(timeText.equals("")){
            return true;
        }
        int temp;
        if((temp = timeText.indexOf("월")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    if(!monday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1].equals("")){
                        return false;
                    }
                }
            }
        }
        if((temp = timeText.indexOf("화")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    if(!tuesday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1].equals("")){
                        return false;
                    }
                }
            }
        }
        if((temp = timeText.indexOf("수")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    if(!wednesday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1].equals("")){
                        return false;
                    }
                }
            }
        }
        if((temp = timeText.indexOf("목")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    if(!thursday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1].equals("")){
                        return false;
                    }
                }
            }
        }
        if((temp = timeText.indexOf("금")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    if(!friday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1].equals("")){
                        return false;
                    }
                }
            }
        }
        return true; // 위의 모든 조건 충족 시 true 반환 > 시간표 넣기 가능한 것.
    }

    public void addTimeTable(String timeText,String courseTitle, String courseRoom){
        int temp;
        // 요일 정보 위치 파악
        if((temp = timeText.indexOf("월")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    monday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1] = courseTitle+"\n"+courseRoom;
                }
            }
        }
        if((temp = timeText.indexOf("화")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    tuesday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1] = courseTitle+"\n"+courseRoom;
                }
            }
        }
        if((temp = timeText.indexOf("수")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    wednesday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1] = courseTitle+"\n"+courseRoom;
                }
            }
        }
        if((temp = timeText.indexOf("목")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']') {
                    endPoint = i;
                    thursday[Integer.parseInt(timeText.substring(startPoint + 1, endPoint)) - 1] = courseTitle+"\n"+courseRoom;
                }
            }
        }
        if((temp = timeText.indexOf("금")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ':';i++){
                if(timeText.charAt(i)=='['){
                    startPoint=i;
                }
                if(timeText.charAt(i)==']'){
                    endPoint=i;
                    friday[Integer.parseInt(timeText.substring(startPoint+1,endPoint))-1] = courseTitle+"\n"+courseRoom;
                }
            }
        }
    }

    public void settingTimeTable(TextView[] monday, TextView[] tuesday, TextView[] wednesday, TextView[] thursday, TextView[] friday, Context context){
        for(int i=0;i<12;i++){
            if (!this.monday[i].equals("")){
                monday[i].setText(this.monday[i]);
            }
        }
        for(int i=0;i<12;i++){
            if (!this.tuesday[i].equals("")){
                tuesday[i].setText(this.tuesday[i]);
            }
        }
        for(int i=0;i<12;i++){
            if (!this.wednesday[i].equals("")){
                wednesday[i].setText(this.wednesday[i]);
            }
        }
        for(int i=0;i<12;i++){
            if (!this.thursday[i].equals("")){
                thursday[i].setText(this.thursday[i]);
            }
        }
        for(int i=0;i<12;i++){
            if (!this.friday[i].equals("")){
                friday[i].setText(this.friday[i]);
            }
        }
    }
}
