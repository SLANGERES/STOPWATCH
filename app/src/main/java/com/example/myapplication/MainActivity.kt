package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer




class MainActivity : AppCompatActivity() {
    private lateinit var stopwatch: Chronometer
    private var running=false
    private var offset: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stopwatch = findViewById(R.id.CMmeter)

        val startButton =findViewById<Button>(R.id.Start)
        startButton.setOnClickListener{
            if(!running){
                setBaseTime()
                stopwatch.start()
                running=true
            }
        }
        val pauseButton=findViewById<Button>(R.id.button2)
        pauseButton.setOnClickListener {
            if(running){
                saveOffset()
                stopwatch.stop()
                running=false
            }
        }
        val stopButton=findViewById<Button>(R.id.button3)
        stopButton.setOnClickListener {
            offset=0
            setBaseTime()
        }


    }
    private fun setBaseTime(){
        stopwatch.base=SystemClock.elapsedRealtime() - offset
    }

    private fun saveOffset(){
        offset=SystemClock.elapsedRealtime()- stopwatch.base
    }

}