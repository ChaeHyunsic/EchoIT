package com.example.term_project;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.course.response.result.GetCourseListResult;
import com.example.term_project.board.evaluate_board.response.result.GetSubjectReviewsResult;

import java.util.ArrayList;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder>{
    private int oldPosition = -1;
    private int selectedPosition = -1;
    private ArrayList<GetCourseListResult> result;
    private Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout constraintLayout, touchLayout;
        TextView subjectName, professor, time, grade, separation, credit;
        RatingBar scoreAverage;
        AppCompatButton plusCourse, subReview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.course_item_cl_js);
            touchLayout = itemView.findViewById(R.id.course_plus_cl_js);
            subjectName = itemView.findViewById(R.id.course_subject_name_js);
            professor = itemView.findViewById(R.id.course_professor_tv_js);
            time = itemView.findViewById(R.id.course_time_tv_js);
            grade = itemView.findViewById(R.id.course_grade_number_tv_js);
            separation = itemView.findViewById(R.id.course_separation_tv_js);
            credit = itemView.findViewById(R.id.course_credit_tv_js);
            scoreAverage = itemView.findViewById(R.id.course_score_average_rb_js);
            plusCourse = itemView.findViewById(R.id.course_plus_time_table_btn_js);
            subReview = itemView.findViewById(R.id.course_sub_review_btn_js);
        }
    }

    public CourseListAdapter(ArrayList<GetCourseListResult> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.course_list_recyclerview_item, parent, false);
        CourseListAdapter.ViewHolder vh = new CourseListAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListAdapter.ViewHolder holder, int position) {
        int touchIndex = holder.getAdapterPosition();
        holder.subjectName.setText(result.get(position).getSubjectName());
        holder.professor.setText(result.get(position).getProfessor());
        holder.time.setText(result.get(position).getTime());
        holder.grade.setText(String.valueOf(result.get(position).getCourseGrade()));
        holder.separation.setText(result.get(position).getSeparation());
        holder.credit.setText(String.valueOf(result.get(position).getCredit()));
        holder.scoreAverage.setRating(result.get(position).getScoreAverage());

        if (selectedPosition == position){
            holder.constraintLayout.setBackgroundColor(Color.parseColor("#F08080"));
            holder.touchLayout.setVisibility(View.VISIBLE);
        }else{
            holder.constraintLayout.setBackgroundColor(Color.WHITE);
            holder.touchLayout.setVisibility(View.INVISIBLE);
        }

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldPosition = selectedPosition;
                selectedPosition = touchIndex;

                notifyItemChanged(oldPosition);
                notifyItemChanged(selectedPosition);
            }

        });

    }

    @Override
    public int getItemCount() {
        return result.size();
    }
}
