package com.example.recoffeemenu.ui.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.recoffeemenu.databinding.ActivityDetailBinding
import com.example.recoffeemenu.network.model.CoffeeResult
import com.example.recoffeemenu.util.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun init() {
        initData()
        initObserve()
        initListener()
    }

    private fun initData() {
    }

    private fun initObserve(){

    }

    private fun initListener() {

    }
}



//@AndroidEntryPoint
//class DetailActivity : AppCompatActivity() {
//    @Inject
//    lateinit var pref: Pref
//
//    private lateinit var binding: ActivityDetailBinding
//    private lateinit var coffee: Coffee
//    private var position: Int = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityDetailBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        initialize()
//    }
//
//    private fun initialize() {
//        initData()
//        initListener()
//        initUI()
//    }
//
//    private fun initData() {
//        coffee = intent.getSerializableExtra("coffee") as Coffee
//        position = intent.getIntExtra("position", 0)
//    }
//
//    private fun initListener() {
//        binding.cbHart.setOnCheckedChangeListener { buttonView, isChecked ->
//            coffee.favorite = isChecked
//            pref.putData(coffee.product_CD, coffee.favorite)
//        }
//        binding.btnBackArrow.setOnClickListener {
//            intent.putExtra("coffee", coffee)
//            intent.putExtra("position", position)
//            setResult(RESULT_OK, intent)
//            finish()
//        }
//    }
//
//    private fun initUI() {
//        binding.tvName.text = coffee.product_NM
//        binding.tvKcal.text = coffee.kcal + "kcal"
//        binding.tvContent.text = coffee.content
//        binding.cbHart.isChecked = coffee.favorite
//        Glide.with(this)
//            .load(coffee.file_PATH)
//            .centerCrop()
//            .into(binding.ivCofImg)
//    }
//
//    override fun onBackPressed() {
//        intent.putExtra("coffee", coffee)
//        intent.putExtra("position", position)
//        setResult(RESULT_OK, intent)
//        super.onBackPressed()
//    }
//}