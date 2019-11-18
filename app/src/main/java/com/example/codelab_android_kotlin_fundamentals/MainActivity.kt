package com.example.codelab_android_kotlin_fundamentals

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var diceSrc: ImageView
    lateinit var diceTwo: ImageView
    lateinit var textNumber: TextView
    lateinit var textNumberTwo: TextView

    override fun onClick(v: View?) {
        var value: Int? = null
        var value2: Int? = null
        when(v!!.id){
            R.id.button1 -> {
                value = Random.nextInt(1,7)
                value2 = Random.nextInt(1,7)
                textNumber.text = value.toString()
                textNumberTwo.text = value2.toString()

            }
            R.id.count_up -> {
                if(!textNumber.text.isDigitsOnly() && !textNumberTwo.text.isDigitsOnly()){
                    textNumber.text = "1"
                    textNumberTwo.text = "1"
                    value2 = 1
                    value = 1
                }
                else{
                    value = textNumber.text.toString().toInt() + 1
                    if(value <= 6)
                        textNumber.text = (value).toString()
                    value2 = textNumberTwo.text.toString().toInt() + 1
                    if(value2 <= 6)
                        textNumberTwo.text = (value2).toString()
                }
            }
        }
        setImageSrc(value!!, diceSrc)
        setImageSrc(value2!!, diceTwo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textNumber = findViewById(R.id.number)
        textNumberTwo = findViewById(R.id.number2)
        diceSrc = findViewById(R.id.dice)
        diceTwo = findViewById(R.id.dice2)
        val rollButton: Button   = findViewById(R.id.button1)
        val countUpButton: Button = findViewById(R.id.count_up)
        rollButton.setOnClickListener(this)
        countUpButton.setOnClickListener(this)
    }

    fun setImageSrc(value:Int, dice:ImageView){
        when(value){
            1 -> dice.setImageResource(R.drawable.dice_1)
            2 -> dice.setImageResource(R.drawable.dice_2)
            3 -> dice.setImageResource(R.drawable.dice_3)
            4 -> dice.setImageResource(R.drawable.dice_4)
            5 -> dice.setImageResource(R.drawable.dice_5)
            else -> dice.setImageResource(R.drawable.dice_6)
        }
    }
}
