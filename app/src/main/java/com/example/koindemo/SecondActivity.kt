package com.example.koindemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.android.scope.createScope
import org.koin.core.component.KoinScopeComponent
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class SecondActivity : AppCompatActivity(), KoinScopeComponent {

    override val scope : Scope by lazy { createScope(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button : Button = findViewById(R.id.second_button)

        button.setOnClickListener {

            val singletone : Any by inject(qualifier = named("singletone"))
            val factory : Any by inject(qualifier = named("factory"))

            val scopedObj : Any by inject(qualifier = named("scopedObj"))
            val scopedFactory : Any by inject(qualifier = named("scoped_factory"))

            Log.d(MainActivity.TAG, "singletone hash: ${singletone.hashCode()}")
            Log.d(MainActivity.TAG, "factory hash: ${factory.hashCode()}")
            Log.d(MainActivity.TAG, "scoped hash: ${scopedObj.hashCode()}")
            Log.d(MainActivity.TAG, "scoped_factory hash: ${scopedFactory.hashCode()}")
        }

    }

    companion object {
        const val TAG = "myLogs"
    }
}