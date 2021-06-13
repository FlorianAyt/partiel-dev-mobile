package edu.glsia.jeupartiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.glsia.jeupartiel.adapter.ScoreAdapter;
import edu.glsia.jeupartiel.model.Score;
import edu.glsia.jeupartiel.repository.ScoreRepository;

public class ScoreActivity extends AppCompatActivity {

    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        dbHelper = new DbHelper(this);
        ScoreRepository scoreRepository = new ScoreRepository();

        ListView listView = findViewById(R.id.score_list);
        List<Score> scores = new ArrayList<>();

        scores.addAll(scoreRepository.findAll(dbHelper.getDatabase()));
        ScoreAdapter scoreAdapter = new ScoreAdapter(scores,this);
        listView.setAdapter(scoreAdapter);
        scoreAdapter.notifyDataSetChanged();
    }
}