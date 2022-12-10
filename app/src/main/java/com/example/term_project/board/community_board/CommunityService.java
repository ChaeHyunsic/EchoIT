package com.example.term_project.board.community_board;

import static com.example.term_project.network.NetworkModule.getRetrofit;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.term_project.board.community_board.request.PatchCommunityRequest;
import com.example.term_project.board.community_board.request.PostCommentRequest;
import com.example.term_project.board.community_board.request.PostCommunityRequest;
import com.example.term_project.board.community_board.response.DeleteCommunityResponse;
import com.example.term_project.board.community_board.response.GetCommentsResponse;
import com.example.term_project.board.community_board.response.GetCommunitesResponse;
import com.example.term_project.board.community_board.response.GetIsAuthResponse;
import com.example.term_project.board.community_board.response.GetTopCommunitiesResponse;
import com.example.term_project.board.community_board.response.PatchCommunityResponse;
import com.example.term_project.board.community_board.response.PostCommentResponse;
import com.example.term_project.board.community_board.response.PostCommunityResponse;
import com.example.term_project.view.DeleteCommunityView;
import com.example.term_project.view.GetCommentsView;
import com.example.term_project.view.GetCommunitesView;
import com.example.term_project.view.GetIsAuthView;
import com.example.term_project.view.GetTopCommunitiesView;
import com.example.term_project.view.PatchCommunityView;
import com.example.term_project.view.PostCommentView;
import com.example.term_project.view.PostCommunityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommunityService {
    private final CommunityRetrofitInterface communitiesService = getRetrofit().create(CommunityRetrofitInterface.class);
    private GetCommunitesView getCommunitesView;
    private GetIsAuthView getIsAuthView;
    private GetCommentsView getCommentsView;
    private PostCommunityView postCommunityView;
    private PatchCommunityView patchCommunityView;
    private DeleteCommunityView deleteCommunityView;
    private GetTopCommunitiesView getTopCommunitiesView;
    private PostCommentView postCommentView;

    public void setGetCommunitesView(GetCommunitesView getCommunitesView){
        this.getCommunitesView = getCommunitesView;
    }
    public void setGetIsAuthView(GetIsAuthView getIsAuthView){
        this.getIsAuthView = getIsAuthView;
    }
    public void setGetCommentsView(GetCommentsView getCommentsView){
        this.getCommentsView = getCommentsView;
    }
    public void setPostCommunityView(PostCommunityView postCommunityView){
        this.postCommunityView = postCommunityView;
    }
    public void setPatchCommunityView(PatchCommunityView patchCommunityView){
        this.patchCommunityView = patchCommunityView;
    }
    public void setDeleteCommunityView(DeleteCommunityView deleteCommunityView){
        this.deleteCommunityView = deleteCommunityView;
    }
    public void setGetTopCommunitiesView(GetTopCommunitiesView getTopCommunitiesView){
        this.getTopCommunitiesView = getTopCommunitiesView;
    }
    public void setPostCommentView(PostCommentView postCommentView){
        this.postCommentView = postCommentView;
    }

    // GET
    public void getCommunities(@Nullable Integer grade){
        communitiesService.getCommunities(grade).enqueue(new Callback<GetCommunitesResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetCommunitesResponse> call, Response<GetCommunitesResponse> response) {
                GetCommunitesResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    getCommunitesView.onGetCommunitesSuccess(resp.getCode(),resp.getResult());
                }else{
                    getCommunitesView.onGetCommunitesFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetCommunitesResponse> call, Throwable t) {}
        });
    }
    // GET
    public void getIsAuth(String jwt){
        communitiesService.getIsAuth(jwt).enqueue(new Callback<GetIsAuthResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetIsAuthResponse> call, Response<GetIsAuthResponse> response) {
                GetIsAuthResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    getIsAuthView.onGetIsAuthSuccess(resp.getCode(),resp.getResult());
                }else{
                    getIsAuthView.onGetIsAuthFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetIsAuthResponse> call, Throwable t) {}
        });
    }
    // GET
    public void getComments(int communityIdx){
        communitiesService.getComments(communityIdx).enqueue(new Callback<GetCommentsResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetCommentsResponse> call, Response<GetCommentsResponse> response) {
                GetCommentsResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    getCommentsView.onGetCommentsSuccess(resp.getCode(),resp.getResult());
                }else{
                    getCommentsView.onGetCommentsFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetCommentsResponse> call, Throwable t) {}
        });
    }
    // POST
    public void createCommunity(String jwt, PostCommunityRequest postCommunityRequest){
        communitiesService.createCommunity(jwt,postCommunityRequest).enqueue(new Callback<PostCommunityResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<PostCommunityResponse> call, Response<PostCommunityResponse> response) {
                PostCommunityResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    postCommunityView.onPostCommunitySuccess(resp.getCode(),resp.getResult());
                }else{
                    postCommunityView.onPostCommunityFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<PostCommunityResponse> call, Throwable t) {}
        });
    }
    // PATCH
    public void updateCommunity(String jwt, int communityIdx, PatchCommunityRequest patchCommunityRequest){
        communitiesService.updateCommunity(jwt,communityIdx,patchCommunityRequest).enqueue(new Callback<PatchCommunityResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<PatchCommunityResponse> call, Response<PatchCommunityResponse> response) {
                PatchCommunityResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    patchCommunityView.onPatchCommunitySuccess(resp.getCode(),resp.getResult());
                }else{
                    patchCommunityView.onPatchCommunityFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<PatchCommunityResponse> call, Throwable t) {}
        });
    }
    // PATCH
    public void deleteCommunity(String jwt,int communityIdx){
        communitiesService.deleteCommunity(jwt,communityIdx).enqueue(new Callback<DeleteCommunityResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<DeleteCommunityResponse> call, Response<DeleteCommunityResponse> response) {
                DeleteCommunityResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    deleteCommunityView.onDeleteCommunitySuccess(resp.getCode(),resp.getResult());
                }else{
                    deleteCommunityView.onDeleteCommunityFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<DeleteCommunityResponse> call, Throwable t) {}
        });
    }
    // GET
    public void getTopCommunities(){
        communitiesService.getTopCommunities().enqueue(new Callback<GetTopCommunitiesResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetTopCommunitiesResponse> call, Response<GetTopCommunitiesResponse> response) {
                GetTopCommunitiesResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    getTopCommunitiesView.onGetTopCommunitiesViewSuccess(resp.getCode(),resp.getResult());
                }else{
                    getTopCommunitiesView.onGetTopCommunitiesViewFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetTopCommunitiesResponse> call, Throwable t) {}
        });
    }
    // POST
    public void createComment(String jwt, PostCommentRequest postCommentRequest){
        communitiesService.createComment(jwt,postCommentRequest).enqueue(new Callback<PostCommentResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<PostCommentResponse> call, Response<PostCommentResponse> response) {
                PostCommentResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    postCommentView.onPostCommentSuccess(resp.getCode(),resp.getResult());
                }else{
                    postCommentView.onPostCommentFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<PostCommentResponse> call, Throwable t) {}
        });
    }
}
