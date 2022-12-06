package com.example.term_project;

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
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                monday[Integer.parseInt(timeText.charAt(i)+"")-1] = "수업";
            }
        }
        if((temp = timeText.indexOf("화")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                tuesday[Integer.parseInt(timeText.charAt(i)+"")-1] = "수업";
            }
        }
        if((temp = timeText.indexOf("수")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                wednesday[Integer.parseInt(timeText.charAt(i)+"")-1] = "수업";
            }
        }
        if((temp = timeText.indexOf("목")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                thursday[Integer.parseInt(timeText.charAt(i)+"")-1] = "수업";
            }
        }
        if((temp = timeText.indexOf("금")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                friday[Integer.parseInt(timeText.charAt(i)+"")-1] = "수업";
            }
        }
        for(int i=0;i<12;i++){
            System.out.println(" 월"+i+" "+monday[i]+" 화"+i+" "+tuesday[i]+" 수"+i+" "+wednesday[i]+" 목"+i+" "+thursday[i]+" 금"+i+" "+friday[i]);
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
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                if (!monday[Integer.parseInt(timeText.charAt(i)+"")-1].equals("")){ // 해당 배열값이 빈값이 아니라면 > 중복인 것! > 넣지 말아야 함.
                    return false;
                }

            }
        }
        if((temp = timeText.indexOf("화")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                if (!tuesday[Integer.parseInt(timeText.charAt(i)+"")-1].equals("")){
                    return false;
                }

            }
        }
        if((temp = timeText.indexOf("수")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                if (!wednesday[Integer.parseInt(timeText.charAt(i)+"")-1].equals("")){
                    return false;
                }

            }
        }
        if((temp = timeText.indexOf("목")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                if (!thursday[Integer.parseInt(timeText.charAt(i)+"")-1].equals("")){
                    return false;
                }

            }
        }
        if((temp = timeText.indexOf("금")) > -1){ // temp 변수에 '월' 단어의 위치 인덱스 값을 저장
            temp+=1;
            for(int i=temp;i<timeText.length() && timeText.charAt(i) != ' ';i++){
                if(timeText.charAt(i) == ',') continue;
                if (!friday[Integer.parseInt(timeText.charAt(i)+"")-1].equals("")){
                    return false;
                }

            }
        }
        return true; // 위의 모든 조건 충족 시 true 반환 > 시간표 넣기 가능한 것.
    }
}
