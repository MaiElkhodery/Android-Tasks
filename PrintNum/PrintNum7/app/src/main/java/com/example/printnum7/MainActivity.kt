package com.example.printnum7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultButton.setOnClickListener{
            val start7 = startEditText7.text.toString().toInt()
            val end7 = endEditText7.text.toString().toInt()
            var count7=0
            for (num in start7..end7){
                if(num%7 == 0){
                    count7++
                }
            }
            resultTextView7.text="Output: $count7"
            Log.d("result1",resultTextView7.text.toString())
            val start3 = startEditText3.text.toString().toInt()
            val end3 = endEditText3.text.toString().toInt()
            var count3=""
            for (num in start3..end3){
                if(num%3 == 0 && num%5 == 0){
                    break
                }
                if(num%3 != 0){
                    count3+= "$num "
                }
            }
            resultTextView3.text="Output: $count3"
            Log.d("result2",resultTextView3.text.toString())
        }
    }
}
