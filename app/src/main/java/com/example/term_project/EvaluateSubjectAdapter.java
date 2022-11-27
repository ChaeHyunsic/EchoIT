package com.example.term_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;

import java.util.ArrayList;

public class EvaluateSubjectAdapter extends RecyclerView.Adapter<EvaluateSubjectAdapter.ViewHolder> {
    private ArrayList<GetEvaluateSubjectResult> result;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView grade,subject,professor;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            grade = itemView.findViewById(R.id.evaluate_grade_number_tv_js);
            subject = itemView.findViewById(R.id.evaluate_subject_name);
            professor = itemView.findViewById(R.id.evaluate_professor_name);
            button = itemView.findViewById(R.id.search_specific_btn);
        }
    }

    public EvaluateSubjectAdapter(ArrayList<GetEvaluateSubjectResult> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public EvaluateSubjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.evaluate_subject_recyclerview_item, parent, false);
        EvaluateSubjectAdapter.ViewHolder vh = new EvaluateSubjectAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull EvaluateSubjectAdapter.ViewHolder holder, int position) {
        String gradeText = String.valueOf(result.get(position).getGrade());
        String subjectText = result.get(position).getSubjectName();
        String professorText = result.get(position).getProfessor();
        int touchIndex = holder.getAdapterPosition();
        holder.grade.setText(gradeText);
        holder.subject.setText(subjectText);
        holder.professor.setText(professorText);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SubjectInfoActivity.class);
                intent.putExtra("subjectIdx",result.get(touchIndex).getId());
                intent.putExtra("subjectName",result.get(touchIndex).getSubjectName());
                intent.putExtra("professor",result.get(touchIndex).getProfessor());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
}
