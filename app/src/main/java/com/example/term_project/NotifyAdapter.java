package com.example.term_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.exam_board.response.result.GetRemainTimeResult;
import com.example.term_project.view.GetRemainTimesView;

import java.util.ArrayList;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.ViewHolder> implements GetRemainTimesView {
    private ArrayList<GetRemainTimeResult> result;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, content, endAt;
        ViewHolder(View itemView) {
            super(itemView) ;
            // 뷰 객체에 대한 참조.
            title = itemView.findViewById(R.id.exam_sub_title_tv_js);
            content = itemView.findViewById(R.id.exam_sub_content_tv_js);
            endAt = itemView.findViewById(R.id.exam_sub_endAt_tv_js);
        }
    }

    public NotifyAdapter(ArrayList<GetRemainTimeResult> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public NotifyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.notify_item_recyclerview_item, parent, false);
        NotifyAdapter.ViewHolder vh = new NotifyAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(result.get(position).getTitle());
        holder.content.setText(result.get(position).getContent());
        holder.endAt.setText(result.get(position).getEndAt());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    @Override
    public void onGetRemainTimesSuccess(int code, ArrayList<GetRemainTimeResult> result) {

    }

    @Override
    public void onGetRemainTimesFailure(int code, String message) {

    }
}
