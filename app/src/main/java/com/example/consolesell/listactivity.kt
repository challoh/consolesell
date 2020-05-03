package com.example.consolesell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.content_main.*

class listactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listactivity)

        btnsend.setOnClickListener {

            var name:String=txtname.text.toString()
            var cost:String=txtcost.text.toString()
            var desc:String=txtdescription.text.toString()
        }
    }
}
