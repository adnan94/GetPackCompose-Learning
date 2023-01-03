package com.example.jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.fragment_activity)

        val fragment = if(intent.getStringExtra("type").equals("compose")){
            ComposableFragment()
        }else{
            ComposeFragmentWithXml()
        }

        supportFragmentManager.beginTransaction().add(R.id.main_container,fragment).commit()



    }
}