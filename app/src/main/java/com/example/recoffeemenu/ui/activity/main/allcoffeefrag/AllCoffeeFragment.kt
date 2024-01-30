package com.example.recoffeemenu.ui.activity.main.allcoffeefrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recoffeemenu.databinding.FragmentAllCoffeeBinding
import com.example.recoffeemenu.network.model.CoffeeResult
import com.example.recoffeemenu.ui.activity.main.CoffeeListFragment


class AllCoffeeFragment : CoffeeListFragment<FragmentAllCoffeeBinding>(FragmentAllCoffeeBinding::inflate) {


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