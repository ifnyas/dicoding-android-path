package app.ifnyas.lunarorigins.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import app.ifnyas.lunarorigins.R
import app.ifnyas.lunarorigins.adapter.LunarListAdapter
import app.ifnyas.lunarorigins.data.LunarData
import app.ifnyas.lunarorigins.model.Lunar
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFun()
    }

    private fun initFun() {
        initRecycler()
        initProfile()
    }

    private fun initRecycler() {
        val viewRv: RecyclerView = findViewById(R.id.view_rv)
        val rvAdapter = LunarListAdapter(LunarData.listData).apply {
            setOnItemClickCallback(object : LunarListAdapter.OnItemClickCallback {
                override fun onItemClicked(item: Lunar) {
                    showLunarDetail(item)
                }
            })
        }
        viewRv.apply {
            adapter = rvAdapter
            setHasFixedSize(true)
        }
    }

    private fun showLunarDetail(lunar: Lunar) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("name", lunar.name)
            putExtra("desc", lunar.desc)
            putExtra("image", lunar.image)
            putExtra("source", lunar.source)
        }
        startActivity(intent)
    }

    private fun initProfile() {
        val btnProfile: MaterialButton = findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}