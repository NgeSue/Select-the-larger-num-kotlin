package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRandomTextToBtn()
        btnLeft.setOnClickListener {
            checkAnswer(true)
            setRandomTextToBtn()
        }

        btnRight.setOnClickListener {
            checkAnswer(false)
            setRandomTextToBtn()
        }


    }


    private fun checkAnswer(isLeftBtnIsSelected: Boolean) {
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()

        val correctComparison = if (isLeftBtnIsSelected) leftNum > rightNum else rightNum > leftNum

        if (correctComparison) {
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        } else {
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }


    private fun setRandomTextToBtn() {
        val r = java.util.Random()
        val ln = r.nextInt(10)
        var rn = ln
        while (rn == ln) {
            rn = r.nextInt(10)
        }
        btnLeft.text = ln.toString()
        btnRight.text = rn.toString()
    }

}