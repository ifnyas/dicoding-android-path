package app.ifnyas.lunarorigins.activity

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import app.ifnyas.lunarorigins.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initFun()
    }

    private fun initFun() {
        initView()
    }

    private fun initView() {
        val tvName: MaterialTextView = findViewById(R.id.tv_detail_name)
        val tvDesc: MaterialTextView = findViewById(R.id.tv_detail_desc)
        val ivDetail: AppCompatImageView = findViewById(R.id.iv_detail)
        val btnSource: MaterialButton = findViewById(R.id.btn_detail_source)
        val btnBack: MaterialButton = findViewById(R.id.btn_back)

        val tvNameData = intent.extras?.getString("name")
        val tvDescData = intent.extras?.getString("desc")
        val ivDetailData = intent.extras?.getInt("image")
        val btnSourceData = intent.extras?.getString("source")

        tvName.text = tvNameData
        tvDesc.text = tvDescData
        ivDetail.setImageResource(ivDetailData ?: R.drawable.logo)
        btnSource.setOnClickListener { showWeb(btnSourceData) }
        btnBack.setOnClickListener { onBackPressed() }
    }

    private fun showWeb(url: String?) {
        startActivity(
            Intent(ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
        )
    }
}