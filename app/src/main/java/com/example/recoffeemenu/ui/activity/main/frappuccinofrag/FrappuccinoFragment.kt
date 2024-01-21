package com.example.recoffeemenu.ui.activity.main.frappuccinofrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recoffeemenu.R
import com.example.recoffeemenu.databinding.FragmentEspressoBinding
import com.example.recoffeemenu.databinding.FragmentFrappuccinoBinding
import com.example.recoffeemenu.network.model.CoffeeResult


class FrappuccinoFragment : Fragment() {
    private lateinit var binding: FragmentFrappuccinoBinding
    var dataList: ArrayList<CoffeeResult> = arrayListOf()
    var fragCategory: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFrappuccinoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initData()
        initObserve()
        initListener()

    }

    private fun initData() {
    }

    private fun initObserve() {

    }

    private fun initListener() {

    }
}