package com.example.term_project.board.community_board;

import androidx.annotation.Nullable;

import com.example.term_project.board.community_board.request.PatchCommunityRequest;
import com.example.term_project.board.community_board.request.PostCommunityRequest;
import com.example.term_project.board.community_board.response.DeleteCommunityResponse;
import com.example.term_project.board.community_board.response.GetCommentsResponse;
import com.example.term_project.board.community_board.response.GetIsAuthResponse;
import com.example.term_project.board.community_board.response.GetCommunitesResponse;
import com.example.term_project.board.community_board.response.PatchCommunityResponse;
import com.example.term_project.board.community_board.response.PostCommunityResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CommunityRetrofitInterface {
    @GET("/app/boards/communities") // 학년별커뮤니티 게시글 조회
    Call<GetCommunitesResponse> getCommunities(@Query("grade") @Nullable Integer grade);
    @POST("/app/boards/communities") // 학년별커뮤니티 게시글 작성
    Call<PostCommunityResponse> createCommunity(@Header("X-ACCESS-TOKEN") String jwt,
                                                  @Body PostCommunityRequest postCommunityRequest);
    @PATCH("/app/boards/communities/{communityIdx}")
    Call<PatchCommunityResponse> updateCommunity(@Header("X-ACCESS-TOKEN") String jwt,
                                                 @Path("communityIdx") int communityIdx,
                                                 @Body PatchCommunityRequest patchCommunityRequest);
    @PATCH("/app/boards/communities/del/{communityIdx}")
    Call<DeleteCommunityResponse> deleteCommunity(@Header("X-ACCESS-TOKEN") String jwt,
                                                  @Path("communityIdx") int communityIdx);
    @GET("/app/boards/communities/auth")
    Call<GetIsAuthResponse> getIsAuth(@Header("X-ACCESS-TOKEN") String jwt);
    @GET("/app/boards/communities/comments/{communityIdx}")
    Call<GetCommentsResponse> getComments(@Path("communityIdx") int communityIdx);
}
