package com.example.recoffeemenu.ui.activity.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.recoffeemenu.databinding.FragmentCoffeeListBinding
import com.example.recoffeemenu.network.model.CoffeeResult
import dagger.hilt.android.AndroidEntryPoint



typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class CoffeeListFragment<VB: ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!
    var fragCategory: String = ""
    var dataList: ArrayList<CoffeeResult> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



//abstract class CoffeeListFragment<VB : ViewBinding> : Fragment() {
//
//    var binding: VB? = null
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = getViewBinding(view)
//        init()
//    }
//
//    abstract fun getViewBinding(view: View): VB
//
//    abstract fun init()
//
//}

//@AndroidEntryPoint
//abstract class CoffeeListFragment :Fragment(){
//
//    private lateinit var binding:FragmentCoffeeListBinding
//    var dataList: ArrayList<CoffeeResult> = arrayListOf()
//    var fragCategory: String = ""
//    override fun onCreateView(
//        inflater:LayoutInflater,container:ViewGroup?,
//        savedInstanceState:Bundle?
//    ):View{
//        binding = FragmentCoffeeListBinding.inflate(inflater,container,false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view:View,savedInstanceState:Bundle?){
//        super.onViewCreated(view,savedInstanceState)
//        init()
//    }
//    abstract fun init()
//
//
//}

////class CoffeeListFragment : Fragment() {
////
////    private lateinit var binding: FragmentCoffeeListBinding
////    private lateinit var startForResult: ActivityResultLauncher<Intent>
////    private lateinit var viewModel: MainViewModel
////    var category: String = ""
////    val dataList: ArrayList<CoffeeResult> = arrayListOf()
////    val adapter = CoffeeAdapter(dataList)
////
////    override fun onCreateView(
////        inflater: LayoutInflater, container: ViewGroup?,
////        savedInstanceState: Bundle?
////    ): View {
////        binding = FragmentCoffeeListBinding.inflate(inflater, container, false)
////        return binding.root
////    }
////
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
////        initialize()
////    }
////
////    private fun initialize() {
////        initData()
////        initListener()
////        initUi()
////
////        startForResult =
////            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
////                if (result.resultCode == RESULT_OK) {
////                    val newCoffee = result.data?.getSerializableExtra("coffee") as CoffeeResult
////                    val newPosition = result.data?.getIntExtra("position", 0) as Int
////                    adapter.changeItem(newPosition, newCoffee)
////                }
////            }
////    }
////
////    private fun initData() {
////        adapter.filterData = viewModel.filterData
////        adapter.filter.filter(viewModel.searchFiltData)
////    }
////
////    private fun initListener() {
////        adapter.setItemClickListener(object : CoffeeAdapter.OnItemClickListener {
////            override fun onClick(v: View, position: Int) {
////                val coffee = adapter.getCoffeeList(position)
////                val intent = Intent(requireActivity(), DetailActivity::class.java)
////                intent.putExtra("coffee", coffee)
////                intent.putExtra("position", position)
////                startForResult.launch(intent)
////            }
////        })
////    }
////
////    private fun initUi() {
////        val layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
////        binding.rv.adapter = adapter
////        binding.rv.layoutManager = layoutManager
////    }
////}
