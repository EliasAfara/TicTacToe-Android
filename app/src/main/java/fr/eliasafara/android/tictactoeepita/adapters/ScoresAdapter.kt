package fr.eliasafara.android.tictactoeepita.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.eliasafara.android.tictactoeepita.R
import fr.eliasafara.android.tictactoeepita.data.ScoresObject

class ScoresAdapter(val context: Context,
                    val data: List<ScoresObject>) :
    RecyclerView.Adapter<ScoresAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val winnerName : TextView = view.findViewById(R.id.recycler_view_winnerName)
        val gameDate : TextView = view.findViewById(R.id.recycler_view_gameDate)
        val winnerSign : ImageView = view.findViewById(R.id.recycler_view_winnerSign)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        Log.d("checkxx", "onCreateViewHolder")
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.recycler_view_score_item, parent, false
        )

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Log.d("checkxx", "onBindViewHolder " + position.toString())
        val game : ScoresObject = data[position]

//        Log.d("checkxx", games.toString())

        holder.winnerName.text = game.name
        holder.gameDate.text = game.date

        Glide.with(context)
            .load(if (game.cross){
                "https://www.clipartmax.com/png/middle/134-1340885_swarm-bee-x-delete-comments-tic-tac-toe-cross.png"
            }else{
                "https://www.clipartmax.com/png/middle/422-4221682_tic-tac-toe-circle.png"
            })
            .into(holder.winnerSign)


    }

    override fun getItemCount(): Int {
//        Log.d("checkxx", games.size.toString())
        return data.size
    }
}

