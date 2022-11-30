package com.example.term_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.community_board.response.result.GetCommentsResult;

import java.util.ArrayList;

public class CommunityDetailCommentsAdapter extends RecyclerView.Adapter<CommunityDetailCommentsAdapter.ViewHolder> {
    private ArrayList<GetCommentsResult> result;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nickName,content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nickName = itemView.findViewById(R.id.comment_nickname_js);
            content = itemView.findViewById(R.id.comment_content_js);
        }
    }

    public CommunityDetailCommentsAdapter(ArrayList<GetCommentsResult> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public CommunityDetailCommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.community_comment_recyclerview_item, parent, false);
        CommunityDetailCommentsAdapter.ViewHolder vh = new CommunityDetailCommentsAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityDetailCommentsAdapter.ViewHolder holder, int position) {
        holder.nickName.setText(result.get(position).getTitle());
        holder.content.setText(result.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
}
