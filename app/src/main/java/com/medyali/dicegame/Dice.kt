package com.medyali.dicegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Dice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        val rollButton = findViewById<Button>(R.id.btnroll)
        //set a clicklistener on the button to roll when the user taps it

        rollButton.setOnClickListener { rollDice() } //Do a diceRoll when the app starts
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Find the imageview in the layout
        val diceimage = findViewById<ImageView>(R.id.dice)
        //Determine which drawable resource  id to use based on the dice roll use

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Update the imageView with the correct drawable resource ID
        diceimage.setImageResource(drawableResource)
        //Update the content description
        diceimage.contentDescription = diceRoll.toString();

    }
    class Dice(private  val numSides: Int) {//Do a random dice roll and return the result
    fun roll():Int{

        return (1..numSides).random()
    }

    }
}