package com.example.koindemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named

class MainActivity() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            modules(firstModule, scopeModule)
        }

        val button : Button = findViewById(R.id.button)
        val buttonSecondActivity : Button = findViewById(R.id.button_second_activity)

        button.setOnClickListener {

            val singletone : Any by inject(qualifier = named("singletone"))
            val factory : Any by inject(qualifier = named("factory"))

            Log.d(TAG, "singletone hash: ${singletone.hashCode()}")
            Log.d(TAG, "factory hash: ${factory.hashCode()}")

        }

        buttonSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    companion object {
        const val TAG = "myLogs"
    }
}