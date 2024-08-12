package com.example.hiltkullanimi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltkullanim.Internet
import com.example.hiltkullanim.Kargo
import com.example.hiltkullanim.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var kargo: Kargo
    @Inject
    lateinit var internet: Internet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kargo.gonder()
        internet.basvuruYap()
    }
}
