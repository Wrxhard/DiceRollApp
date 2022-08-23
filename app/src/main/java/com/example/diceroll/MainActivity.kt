package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Dice(val num: Int)
{
    fun roll(): Int
    {
       return (1..num).random()
    }
}

class MainActivity : AppCompatActivity() {
    //roll the dice update the screen
    private fun rollDice() : Int {
        //create 6 faced dice and roll it
        val dice=Dice(6)
        val numdice=dice.roll()
        //update the screen with the dice roll
        val resimageview: ImageView=findViewById(R.id.imageView)
        when(numdice){
            1 -> resimageview.setImageResource(R.drawable.dice_1)
            2 -> resimageview.setImageResource(R.drawable.dice_2)
            3 -> resimageview.setImageResource(R.drawable.dice_3)
            4 -> resimageview.setImageResource(R.drawable.dice_4)
            5 -> resimageview.setImageResource(R.drawable.dice_5)
            6 -> resimageview.setImageResource(R.drawable.dice_6)
        }
        resimageview.contentDescription=numdice.toString()
        return numdice
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button=findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled On ${rollDice()}", Toast.LENGTH_SHORT).show()
        }
    }
}