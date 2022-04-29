package fr.eliasafara.android.tictactoeepita

import fr.eliasafara.android.tictactoeepita.data.ScoresObject
import retrofit2.Call
import retrofit2.http.GET

interface TicTacToeInterface {
    @GET("ttt_scores")
    fun getAllScores() : Call<List<ScoresObject>>

}