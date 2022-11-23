package com.example.term_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.exam_board.response.result.GetExamSubjectsResult;

import java.util.ArrayList;

public class ExamSubjectAdapter extends RecyclerView.Adapter<ExamSubjectAdapter.ViewHolder> {
    private ArrayList<GetExamSubjectsResult> result;
    private Context context;
    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ViewHolder(View itemView) {
            super(itemView) ;
            // 뷰 객체에 대한 참조.
            checkBox = itemView.findViewById(R.id.subject_cb_js);
            textView = itemView.findViewById(R.id.subject_tv_js);
            textView2 = itemView.findViewById(R.id.endAt_tv_js);
            imageView = itemView.findViewById(R.id.context_menu_iv_js);
        }
    }
    // 생성자에서 데이터 리스트 객체를 전달받음.
    ExamSubjectAdapter(ArrayList<GetExamSubjectsResult> result, Context context) {
        this.result = result;
        this.context=context;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public ExamSubjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.exam_subject_recyclerview_item, parent, false);
        ExamSubjectAdapter.ViewHolder vh = new ExamSubjectAdapter.ViewHolder(view) ;

        return vh ;
    }
    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull ExamSubjectAdapter.ViewHolder holder, int position) {
        String text = result.get(position).getTitle();
        String text2 = result.get(position).getEndAt().toString();
        holder.textView.setText(text);
        holder.textView2.setText(text2);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int touchIndex = holder.getAdapterPosition();
                PopupMenu popupMenu = new PopupMenu(context,holder.imageView);
                popupMenu.inflate(R.menu.exam_sub_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.edit:
                                Intent intent = new Intent(context,ExamSubjectEditActivity.class);
                                intent.putExtra("listIdx",result.get(touchIndex).getId());
                                intent.putExtra("title",result.get(touchIndex).getTitle());
                                intent.putExtra("content",result.get(touchIndex).getContent());
                                intent.putExtra("endAt",result.get(touchIndex).getEndAt().toString());
                                context.startActivity(intent);
                                return true;
                            case R.id.delete:
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }
    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return result.size();
    }
}
