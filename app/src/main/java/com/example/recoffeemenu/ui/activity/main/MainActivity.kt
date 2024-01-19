package com.example.recoffeemenu.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.recoffeemenu.databinding.ActivityMainBinding
import com.example.recoffeemenu.network.model.CoffeeCategoryListResult
import com.example.recoffeemenu.network.model.CoffeeResult
import com.example.recoffeemenu.viewmodel.MainViewModel

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayCoffeeCategoryListResult: ArrayList<CoffeeCategoryListResult>
    private lateinit var coffeeCategoryListResult: ArrayList<CoffeeResult>

    private val adapter = PageAdapter(supportFragmentManager)
    private val viewModel: MainViewModel by viewModels()
    private var category: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
//        Solution().solution("hello", 3)
    }

    private fun init() {
        initData()
        initObserve()
        initListener()
    }

    private fun initData() {
        binding.vp.adapter = adapter
        binding.tlMenu.setupWithViewPager(binding.vp)
        viewModel.requestAllCoffee()
    }

    private fun initObserve() {
        viewModel.arrayCoffeeCategoryList.observe(this) {
//            arrayCoffeeCategoryListResult=it
            it.forEach { coffeeCategoryListResult ->
                val coffeeListFragment = CoffeeListFragment().apply {
                    this.fragCategory = coffeeCategoryListResult.category
                    coffeeCategoryListResult.coffeeList?.let {  arrayCoffeeResult->
                        this.dataList = arrayCoffeeResult
                    }
                }
                adapter.fragmentList.add(coffeeListFragment)
            }
        }
    }

    private fun initListener() {

    }
}


//@AndroidEntryPoint
//class MainActivity : AppCompatActivity(), FilterFragment.SendEventListener {
//    @Inject
//    lateinit var pref: Pref
//
//    private lateinit var binding: ActivityMainBinding
//    private val adapter = PageAdapter(supportFragmentManager)
//    private lateinit var mainViewMode: MainViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        mainViewMode = ViewModelProvider(this).get(MainViewModel::class.java)
//        initialize()
//
////        Solution().solution("hello", 3)
//    }
//
//    override fun onResume() {
//        super.onResume()
//        adapter.notifyDataSetChanged()
//    }
//
//    private fun initialize() {
//        initData()
//        initListener()
//        initUI()
//    }
//
//    private fun initData() {
//        val menuJson = assets.open("menu.json").reader().readText()
//        menuParsing(menuJson)
//    }
//
//    private fun menuParsing(menuJson: String) {
//        val menuJSONObject = JSONObject(menuJson)
//        val menuKeys = menuJSONObject.keys()
//        val allCoffeeList: ArrayList<Coffee> = arrayListOf()
//
//        for (key in menuKeys) {
//            val jsonArray = menuJSONObject.getJSONObject(key).getJSONArray("list")
//            val coffeeList: ArrayList<Coffee> = arrayListOf()
//            for (i in 0 until jsonArray.length()) {
//                val coffee: Coffee =
//                    Gson().fromJson(jsonArray.get(i).toString(), Coffee::class.java)
//                coffee.favorite = pref.getBoolean(coffee.product_CD)
//                mainViewMode.updatedMaxPro(coffee.protein.toDouble())
//                mainViewMode.updatedMaxFat(coffee.fat.toDouble())
//                mainViewMode.updatedMaxSugar(coffee.sugars.toDouble())
//                coffeeList.add(coffee)
//                allCoffeeList.add(coffee)
//            }
//            val coffeeListFragment = CoffeeListFragment().apply {
//                category = key
//                dataList.addAll(coffeeList)
//            }
//
//            adapter.fragmentList.add(coffeeListFragment)
//        }
//        val allCoffeeListFragment = CoffeeListFragment().apply {
//            category = "All"
//            dataList.addAll(allCoffeeList)
//        }
//        adapter.fragmentList.add(0, allCoffeeListFragment)
//    }
//
//    private fun initListener() {
//        binding.btnFilter.setOnClickListener {
//            val filterFragment = FilterFragment()
//            filterFragment.show(supportFragmentManager, filterFragment.tag)
//        }
//        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(str: String): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(str: String): Boolean {
//                mainViewMode.searchStr(str)
//                adapter.notifyDataSetChanged()
//                return false
//            }
//        })
//    }
//
//    private fun initUI() {
//        binding.vp.adapter = adapter
//        binding.tlMenu.setupWithViewPager(binding.vp)
//    }
//
//    override fun pagerNotify() {
//        adapter.notifyDataSetChanged()
//    }
//}

