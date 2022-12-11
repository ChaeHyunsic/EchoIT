package com.example.term_project;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.course.CourseService;
import com.example.term_project.board.course.response.result.DeleteCourseResult;
import com.example.term_project.board.course.response.result.GetTimeTableListResult;
import com.example.term_project.board.exam_board.ExamSubjectService;
import com.example.term_project.view.DeleteCourseView;

import java.util.ArrayList;

public class MyCourseListAdapter extends RecyclerView.Adapter<MyCourseListAdapter.ViewHolder> implements DeleteCourseView {
    private ArrayList<GetTimeTableListResult> result;
    private Context context;



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView subjectName, professor, time, grade, separation, credit;
        ImageView delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.course_subject_name_js);
            professor = itemView.findViewById(R.id.course_professor_tv_js);
            time = itemView.findViewById(R.id.course_time_tv_js);
            grade = itemView.findViewById(R.id.course_grade_number_tv_js);
            separation = itemView.findViewById(R.id.course_separation_tv_js);
            credit = itemView.findViewById(R.id.course_credit_tv_js);
            delete = itemView.findViewById(R.id.my_course_delete_iv_js);
        }
    }

    public MyCourseListAdapter(ArrayList<GetTimeTableListResult> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public MyCourseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.my_course_list_recyclerview_item, parent, false);
        MyCourseListAdapter.ViewHolder vh = new MyCourseListAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCourseListAdapter.ViewHolder holder, int position) {
        int touchIndex = holder.getAdapterPosition();
        holder.subjectName.setText(result.get(position).getSubjectName());
        holder.professor.setText(result.get(position).getProfessor());
        holder.time.setText(result.get(position).getTime());
        holder.grade.setText(String.valueOf(result.get(position).getCourseGrade()));
        holder.separation.setText(result.get(position).getSeparation());
        holder.credit.setText(String.valueOf(result.get(position).getCredit()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData(result.get(touchIndex).getTimetableIdx()); // 내 강의삭제 api 호출
                result.remove(touchIndex); // 리스트에서 삭제
                notifyItemRemoved(touchIndex);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    private String getJwt(){
        SharedPreferences spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    // 내 강의 삭제 api
    private void deleteData(int timetableIdx){
        CourseService courseService = new CourseService();
        courseService.setDeleteCourseView(this);

        courseService.deleteCourse(getJwt(),timetableIdx);
    }
    @Override
    public void onDeleteCommunitySuccess(int code, DeleteCourseResult result) {

    }

    @Override
    public void onDeleteCommunityFailure(int code, String message) {

    }
}
