package com.example.term_project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class NoticeNewsFragment extends Fragment {
    private TableLayout tableLayout;
    private TextView tv_title, tv_day, tv_load;
    ArrayList<ListData> arrayList = new ArrayList<ListData>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_news, container, false);
        tableLayout = view.findViewById(R.id.tl_ch);
        tv_title=view.findViewById(R.id.tv_title_ch);
        tv_day=view.findViewById(R.id.tv_day_ch);
        tv_load=view.findViewById(R.id.tv_load_ch);

        ProgressBar progressBar;

        regionData task = new regionData();
        task.execute();

        return view;
    }

    private class regionData extends AsyncTask<Void, Void, ArrayList<ListData>> {
        String base_url = "https://www.ulsan.ac.kr/kor/CMS/Board/Board.do";
        @Override
        protected ArrayList<ListData> doInBackground(Void... voids) {
            try {
                /* Jsoup을 이용해 데이터 가져오기 */
                for (int index=1;index<11;index++) {
                    String url = "https://www.ulsan.ac.kr/kor/CMS/Board/Board.do?robot=Y&mCode=MN104&page=" + String.valueOf(index);
                    Document document = Jsoup.connect(url).get();
                    Elements doc_title = document.getElementsByClass("subject");
                    Elements doc_day = document.getElementsByClass("date");

                    ArrayList<String> arrayList_title = new ArrayList<String>();
                    ArrayList<String> arrayList_content = new ArrayList<String>();
                    ArrayList<String> arrayList_day = new ArrayList<String>();

                    String tv_title;
                    String tv_content;
                    String tv_day;

                    for (Element element : doc_title) {
                        tv_title = element.text();
                        arrayList_title.add(tv_title);
                    }
                    for (Element element : doc_day) {
                        tv_day = element.text();
                        arrayList_day.add(tv_day);
                    }

                    for (int i=1;i<11;i++) {
                        String selector = "#board-list-wrap > ul > li:nth-child(" + String.valueOf(i) + ") > div.news-cont > a";
                        Elements doc_content = document.select(selector);
                        tv_content = doc_content.get(0).attr("href");
                        arrayList_content.add(tv_content);
                    }

                    for (int i = 0; i < arrayList_title.size(); i++) {
                        arrayList.add(new ListData(arrayList_title.get(i), arrayList_content.get(i), arrayList_day.get(i)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<ListData> arrayList) {
            super.onPostExecute(arrayList);
            tv_load.setVisibility(View.GONE);
            ArrayList<String> arrayList_title = new ArrayList<String>();
            ArrayList<String> arrayList_content = new ArrayList<String>();
            ArrayList<String> arrayList_day = new ArrayList<String>();

            for (ListData item : arrayList) {
                arrayList_title.add(item.tv_title);
                arrayList_content.add(base_url + item.tv_content);
                arrayList_day.add(item.tv_day);
            }


            for(int i=0;i<arrayList.size();i++) {


                TableRow tableRow = new TableRow(getActivity());     // tablerow 생성

                TextView tv1 = new TextView(getActivity());
                tv1.setText(arrayList_title.get(i));
                TextView tv2 = new TextView(getActivity());
                tv2.setText(arrayList_day.get(i));

                String onclick_url = arrayList_content.get(i);

                int d = 300;
                float scale = getResources().getDisplayMetrics().density;
                final int calWidth = (int)(d*scale);
                tv1.setMaxWidth(calWidth);

                tv1.setMaxLines(1);
                tv1.setEllipsize(TextUtils.TruncateAt.END);

                tv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Context context=view.getContext();
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(onclick_url));
                        context.startActivity(intent);
                    }
                });

                int d2 = 300;
                final int calWidth2 = (int)(d2*scale);
                tv2.setMaxWidth(calWidth2);
                tv2.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));

                tableRow.addView(tv1);		// tableRow에 view 추가
                tableRow.addView(tv2);		// tableRow에 view 추가
                tableLayout.addView(tableRow);		// tableLayout에 tableRow 추가
            }
            tv_title.setVisibility(View.VISIBLE);
            tv_day.setVisibility(View.VISIBLE);
        }
    }
    public class ListData {
        private String tv_title;
        private String tv_content;
        private String tv_day;

        public ListData(String tv_title, String tv_content, String tv_day) {
            this.tv_title = tv_title;
            this.tv_content = tv_content;
            this.tv_day = tv_day;
        }
    }
}
