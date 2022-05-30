package app.ifnyas.lunarorigins.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.ifnyas.lunarorigins.R
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initFun()
    }

    private fun initFun() {
        initView()
    }

    private fun initView() {
        val btnBack: MaterialButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener { onBackPressed() }
    }
}