package com.example.term_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.exam_board.ExamSubjectService;
import com.example.term_project.board.exam_board.response.result.GetExamSubjectsResult;
import com.example.term_project.view.DeleteExamSubjectView;

import java.sql.Date;
import java.util.ArrayList;

public class ExamSubjectAdapter extends RecyclerView.Adapter<ExamSubjectAdapter.ViewHolder> implements DeleteExamSubjectView {
    private ArrayList<GetExamSubjectsResult> result;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        ViewHolder(View itemView) {
            super(itemView) ;
            // 뷰 객체에 대한 참조.
            constraintLayout = itemView.findViewById(R.id.exam_subject_item_cl_js);
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
        int touchIndex = holder.getAdapterPosition();
        holder.textView.setText(text);
        holder.textView2.setText(text2);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context,holder.imageView);
                popupMenu.inflate(R.menu.exam_sub_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NotifyDataSetChanged")
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
                                Log.d("DEL-GETID ?", ""+result.get(touchIndex).getId());
                                deleteData(result.get(touchIndex).getId());
                                result.remove(touchIndex);
                                notifyDataSetChanged();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ExamSubjectViewActivity.class);
                intent.putExtra("titleView",result.get(touchIndex).getTitle());
                intent.putExtra("contentView",result.get(touchIndex).getContent());
                intent.putExtra("endAtView",result.get(touchIndex).getEndAt().toString());
                context.startActivity(intent);
            }
        });
    }
    private String getJwt(){
        SharedPreferences spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    private void deleteData(int listIdx){
        ExamSubjectService examSubjectService = new ExamSubjectService();
        examSubjectService.setDeleteExamSubjectView(this);

        examSubjectService.deleteExamSubject(getJwt(),listIdx);
    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onDeleteExamSubjectSuccess(int listIdx) {
        notifyDataSetChanged();
    }

    @Override
    public void onDeleteExamSubjectFailure(int code, String message) {

    }
    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return result.size();
    }
}
