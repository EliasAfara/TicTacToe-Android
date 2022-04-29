package fr.eliasafara.android.tictactoeepita.activites

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import fr.eliasafara.android.tictactoeepita.R
import java.util.*

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val mainActivityIntent = intent

        val winnerSignTextView : TextView = findViewById(R.id.activity_player_current_player)

        // extract data from the intent
        val currentWinnerSign = mainActivityIntent.getStringExtra("GameWinner")
        winnerSignTextView.text = currentWinnerSign
        if(currentWinnerSign == "X"){
            winnerSignTextView.setTextColor(Color.parseColor("#009365"));
        }else if(currentWinnerSign == "O"){
            winnerSignTextView.setTextColor(Color.parseColor("#5220FD"));
        }

        val sumbitScoreButton : Button = findViewById(R.id.activity_player_button)

        val newScoreInputMultiLineText : EditText = findViewById(R.id.activity_player_scoreInput)



        sumbitScoreButton.setOnClickListener {
            val explicitIntent : Intent = Intent(this, ScoreActivity::class.java)

            val currentDateTime = Date();
            val newWinnerName : String = newScoreInputMultiLineText.text.toString()
            explicitIntent.putExtra("GameWinner", newWinnerName)
            explicitIntent.putExtra("GameWinnerSign", currentWinnerSign)
            explicitIntent.putExtra("GameDateTime", currentDateTime.toString())

            startActivity(explicitIntent)
        }


    }
}