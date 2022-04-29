package fr.eliasafara.android.tictactoeepita.activites

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import fr.eliasafara.android.tictactoeepita.R
import fr.eliasafara.android.tictactoeepita.TicTacToeInterface
import fr.eliasafara.android.tictactoeepita.adapters.ScoresAdapter
import fr.eliasafara.android.tictactoeepita.data.ScoresObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val playerActivityIntent = intent
        val latestGameWinner = playerActivityIntent.getStringExtra("GameWinner")
        val latestGameWinnerSign = playerActivityIntent.getStringExtra("GameWinnerSign")
        val latestGameDateTime = playerActivityIntent.getStringExtra("GameDateTime")
        var cross : Boolean = false
        if(latestGameWinnerSign == "X"){
            cross = true
        }else if(latestGameWinnerSign == "O"){
            cross = false
        }

        var scoresData : ArrayList<ScoresObject> = arrayListOf(
            ScoresObject(latestGameWinner!!, latestGameDateTime!!, cross)
        )


        val recyclerViewScoreActivity : RecyclerView = findViewById(R.id.activity_score_recyclerView)

        recyclerViewScoreActivity.layoutManager = LinearLayoutManager(this)

        val retrofitClient = Retrofit.Builder()
            .baseUrl("https://www.surleweb.xyz/api/game/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        val service : TicTacToeInterface = retrofitClient.create(TicTacToeInterface::class.java)

        val callback : Callback<List<ScoresObject>> = object : Callback<List<ScoresObject>> {

            override fun onResponse(
                call: Call<List<ScoresObject>>,
                response: Response<List<ScoresObject>>
            ) {
                if (response.isSuccessful) {
//                    Log.d("checkxx", response.body().toString())
                    response.body()?.let { data ->
//                        Log.d("checkxx", data.toString())

                        scoresData += data as ArrayList<ScoresObject>

                        recyclerViewScoreActivity.adapter = ScoresAdapter(this@ScoreActivity, scoresData)
                    }
                } else {
                    Log.d("checkxx", "failed response")
                }
            }

            override fun onFailure(call: Call<List<ScoresObject>>, t: Throwable) {
                t.localizedMessage?.let { Log.d("checkxx", it) }
            }

        }

        // Pass Callback object to webservice function in service object to actually call the WebService
        // use the service to enqueue the callback
        service.getAllScores().enqueue(callback)

        recyclerViewScoreActivity.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


    }
}