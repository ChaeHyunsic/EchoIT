package com.example.term_project.board.community_board;

import static com.example.term_project.network.NetworkModule.getRetrofit;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.term_project.board.community_board.response.GetCommentsResponse;
import com.example.term_project.board.community_board.response.GetCommunitesResponse;
import com.example.term_project.board.community_board.response.GetIsAuthResponse;
import com.example.term_project.view.GetCommentsView;
import com.example.term_project.view.GetCommunitesView;
import com.example.term_project.view.GetIsAuthView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommunityService {
    private final CommunityRetrofitInterface communitiesService = getRetrofit().create(CommunityRetrofitInterface.class);
    private GetCommunitesView getCommunitesView;
    private GetIsAuthView getIsAuthView;
    private GetCommentsView getCommentsView;

    public void setGetCommunitesView(GetCommunitesView getCommunitesView){
        this.getCommunitesView = getCommunitesView;
    }
    public void setGetIsAuthView(GetIsAuthView getIsAuthView){
        this.getIsAuthView = getIsAuthView;
    }
    public void setGetCommentsView(GetCommentsView getCommentsView){
        this.getCommentsView = getCommentsView;
    }
    // GET
    public void getCommunities(@Nullable Integer grade){
        Log.d("COMMUNITY-INPUT", grade+"");
        communitiesService.getCommunities(grade).enqueue(new Callback<GetCommunitesResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetCommunitesResponse> call, Response<GetCommunitesResponse> response) {
                GetCommunitesResponse resp = response.body();
                Log.d("COMMUNITY-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    getCommunitesView.onGetCommunitesSuccess(resp.getCode(),resp.getResult());
                }else{
                    getCommunitesView.onGetCommunitesFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetCommunitesResponse> call, Throwable t) {
                Log.d("COMMUNITY/FAIL", t.getMessage());
            }
        });
        Log.d("COMMUNITY","HELLO");
    }
    // GET
    public void getIsAuth(String jwt){
        Log.d("IsAuth-INPUT", jwt+"");
        communitiesService.getIsAuth(jwt).enqueue(new Callback<GetIsAuthResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetIsAuthResponse> call, Response<GetIsAuthResponse> response) {
                GetIsAuthResponse resp = response.body();
                Log.d("IsAuth-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    getIsAuthView.onGetIsAuthSuccess(resp.getCode(),resp.getResult());
                }else{
                    getIsAuthView.onGetIsAuthFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetIsAuthResponse> call, Throwable t) {
                Log.d("IsAuth/FAIL", t.getMessage());
            }
        });
        Log.d("IsAuth","HELLO");
    }
    // GET
    public void getComments(int communityIdx){
        Log.d("COMMENTS-INPUT", communityIdx+"");
        communitiesService.getComments(communityIdx).enqueue(new Callback<GetCommentsResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetCommentsResponse> call, Response<GetCommentsResponse> response) {
                GetCommentsResponse resp = response.body();
                Log.d("COMMENTS-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    getCommentsView.onGetCommentsSuccess(resp.getCode(),resp.getResult());
                }else{
                    getCommentsView.onGetCommentsFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetCommentsResponse> call, Throwable t) {
                Log.d("COMMENTS/FAIL", t.getMessage());
            }
        });
        Log.d("COMMENTS","HELLO");
    }
}
