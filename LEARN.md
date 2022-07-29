# Tic Tac Toe Game - Android Application

> Simple game application 📱 around the basic game of Tic Tac Toe. It allows to players to play the game on the same phone.


## Game functionality logic
 
```Kotlin

val currentPlayer : TextView = findViewById(R.id.main_activity_current_player)
        currentPlayer.text = "X"
        setCurrentPlayerSignColor(currentPlayer)

        val choice00 : TextView = findViewById(R.id.choice00)
        val choice01 : TextView = findViewById(R.id.choice01)
        val choice02 : TextView = findViewById(R.id.choice02)
        val choice10 : TextView = findViewById(R.id.choice10)
        val choice11 : TextView = findViewById(R.id.choice11)
        val choice12 : TextView = findViewById(R.id.choice12)
        val choice20 : TextView = findViewById(R.id.choice20)
        val choice21 : TextView = findViewById(R.id.choice21)
        val choice22 : TextView = findViewById(R.id.choice22)

        var winner: String

        fun checkWinner(){
            // Horizontal check
            if((choice00.text.isNotEmpty() && choice01.text.isNotEmpty() && choice02.text.isNotEmpty()) &&
                (choice00.text == choice01.text && choice01.text == choice02.text)){
                winner = choice00.text as String
                showCaseWinner(winner)
            }
            else if ((choice10.text.isNotEmpty() && choice11.text.isNotEmpty() && choice12.text.isNotEmpty()) &&
                (choice10.text == choice11.text && choice11.text == choice12.text)){
                winner = choice10.text as String
                showCaseWinner(winner)
            }
            else if ((choice20.text.isNotEmpty() && choice21.text.isNotEmpty() && choice22.text.isNotEmpty()) &&
                (choice20.text == choice21.text && choice21.text == choice22.text)){
                winner = choice20.text as String
                showCaseWinner(winner)
            }

            // Vertical check
            else if ((choice00.text.isNotEmpty() && choice10.text.isNotEmpty() && choice20.text.isNotEmpty()) &&
                (choice00.text == choice10.text && choice10.text == choice20.text)){
                winner = choice00.text as String
                showCaseWinner(winner)
            }
            else if ((choice01.text.isNotEmpty() && choice11.text.isNotEmpty() && choice21.text.isNotEmpty()) &&
                (choice01.text == choice11.text && choice11.text == choice21.text)){
                winner = choice01.text as String
                showCaseWinner(winner)
            }
            else if ((choice02.text.isNotEmpty() && choice12.text.isNotEmpty() && choice22.text.isNotEmpty()) &&
                (choice02.text == choice12.text && choice12.text == choice22.text)){
                winner = choice02.text as String
                showCaseWinner(winner)
            }

            // Diagonal Check
            else if ((choice00.text.isNotEmpty() && choice11.text.isNotEmpty() && choice22.text.isNotEmpty()) &&
                (choice00.text == choice11.text && choice11.text == choice22.text)){
                winner = choice00.text as String
                showCaseWinner(winner)
            }
            else if ((choice20.text.isNotEmpty() && choice11.text.isNotEmpty() && choice02.text.isNotEmpty()) &&
                (choice20.text == choice11.text && choice11.text == choice02.text)){
                winner = choice20.text as String
                showCaseWinner(winner)
            }
        }

        fun processGame(choice : TextView){
            switchCurrentPlayer(currentPlayer, choice)
            setCurrentPlayerSignColor(currentPlayer)
            choice.isClickable = false
            checkWinner()
        }

        choice00.setOnClickListener {
            processGame(choice00)
        }
        choice01.setOnClickListener {
            processGame(choice01)
        }
        choice02.setOnClickListener {
            processGame(choice02)
        }
        choice10.setOnClickListener {
            processGame(choice10)
        }
        choice11.setOnClickListener {
            processGame(choice11)
        }
        choice12.setOnClickListener {
            processGame(choice12)
        }
        choice20.setOnClickListener {
            processGame(choice20)
        }
        choice21.setOnClickListener {
            processGame(choice21)
        }
        choice22.setOnClickListener {
            processGame(choice22)
        }


        val epitaLogo : ImageView = findViewById(R.id.activity_main_epita_logo)
        epitaLogo.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_VIEW)
            implicitIntent.data = Uri.parse("https://www.epita.fr/")
            startActivity(implicitIntent)
        }

        val moreInfoWiki : ImageView = findViewById(R.id.activity_main_moreInfoWiki)

        moreInfoWiki.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_VIEW)
            implicitIntent.data = Uri.parse("https://en.wikipedia.org/wiki/Tic-tac-toe")
            startActivity(implicitIntent)
        }
    }

    private fun showCaseWinner(winner : String){
        val explicitIntent = Intent(this, PlayerActivity::class.java)

        explicitIntent.putExtra("GameWinner", winner)

        startActivity(explicitIntent)
    }

    private fun switchCurrentPlayer(currentPlayer : TextView, choice : TextView){
        choice.text = currentPlayer.text
        if(currentPlayer.text == "X"){
            choice.setTextColor(Color.parseColor("#009365"))
            currentPlayer.text = "O"
        }else if(currentPlayer.text == "O"){
            choice.setTextColor(Color.parseColor("#5220FD"))
            currentPlayer.text = "X"
        }
    }

    private fun setCurrentPlayerSignColor(currentPlayer : TextView){
        if(currentPlayer.text == "X"){
            currentPlayer.setTextColor(Color.parseColor("#009365"))
        }else if(currentPlayer.text == "O"){
            currentPlayer.setTextColor(Color.parseColor("#5220FD"))
        }
    }
```
