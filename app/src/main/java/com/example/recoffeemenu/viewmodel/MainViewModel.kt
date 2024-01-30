package com.example.recoffeemenu.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recoffeemenu.base.BaseViewModel
import com.example.recoffeemenu.network.model.CoffeeCategoryListResult
import com.example.recoffeemenu.network.repository.CoffeeRepository
import com.example.recoffeemenu.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val coffeeRepository: CoffeeRepository
) : BaseViewModel() {


    private val _arrayCoffeeCategoryList = MutableLiveData<ArrayList<CoffeeCategoryListResult>>()
    val arrayCoffeeCategoryList: LiveData<ArrayList<CoffeeCategoryListResult>>
        get() = _arrayCoffeeCategoryList

    private val _coldBrewList = MutableLiveData<CoffeeCategoryListResult>()
    val coldBrewList: LiveData<CoffeeCategoryListResult>
        get() = _coldBrewList

    private val _broodList = MutableLiveData<CoffeeCategoryListResult>()
    val broodList: LiveData<CoffeeCategoryListResult>
        get() = _broodList

    private val _espressoList = MutableLiveData<CoffeeCategoryListResult>()
    val espressoList: LiveData<CoffeeCategoryListResult>
        get() = _espressoList

    private val _frappuccinoList = MutableLiveData<CoffeeCategoryListResult>()
    val frappuccinoList: LiveData<CoffeeCategoryListResult>
        get() = _frappuccinoList

    private val _blendedList = MutableLiveData<CoffeeCategoryListResult>()
    val blendedList: LiveData<CoffeeCategoryListResult>
        get() = _blendedList

    private val _fizzoList = MutableLiveData<CoffeeCategoryListResult>()
    val fizzoList: LiveData<CoffeeCategoryListResult>
        get() = _fizzoList

    private val _etcList = MutableLiveData<CoffeeCategoryListResult>()
    val etcList: LiveData<CoffeeCategoryListResult>
        get() = _etcList

    private val _juiceList = MutableLiveData<CoffeeCategoryListResult>()
    val juiceList: LiveData<CoffeeCategoryListResult>
        get() = _juiceList

//    fun requestAllCoffee() {
//        Single.just(coffeeRepository.requestAllCoffee())
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//                Log.e("cyc", "전체 커피 통신 성공")
//                _arrayCoffeeCategoryList.postValue(it)
//            }, {
//                Log.e("cyc", "전체 커피 통신 실패 : ${it}")
//            })
//            .addTo(disposable)
//    }

    fun requestAllCoffee() {
        Observable.fromIterable(coffeeRepository.requestAllCoffee())
            .subscribeOn(Schedulers.io())
            .concatMapSingle { setCoffeeCategoryListResult(it) }
            .toList()
            .observeOn(Schedulers.io())
            .subscribe({
                _arrayCoffeeCategoryList.postValue(it as ArrayList<CoffeeCategoryListResult>)
            }, {
                Log.e("cyc", "전체 커피 통신 실패 : ${it}")
            })
            .addTo(disposable)
    }

    private fun setCoffeeCategoryListResult(coffeeCategoryListResult: CoffeeCategoryListResult): Single<CoffeeCategoryListResult> {
        when (coffeeCategoryListResult.category) {
            Constants.COLD_BREW -> _coldBrewList.postValue(coffeeCategoryListResult)
            Constants.BROOD -> _broodList.postValue(coffeeCategoryListResult)
            Constants.ESPRESSO -> _espressoList.postValue(coffeeCategoryListResult)
            Constants.FRAPPUCCINO -> _frappuccinoList.postValue(coffeeCategoryListResult)
            Constants.BLENDED -> _blendedList.postValue(coffeeCategoryListResult)
            Constants.FIZZO -> _fizzoList.postValue(coffeeCategoryListResult)
            Constants.ETC -> _etcList.postValue(coffeeCategoryListResult)
            Constants.JUICE -> _juiceList.postValue(coffeeCategoryListResult)
        }
        return Single.just(coffeeCategoryListResult)
    }
//    fun requestCoffee(arrayCoffeeCategoryListResult: CoffeeCategoryListResult){
//        Observable.fromIterable()
//            .subscribeOn(Schedulers.io())
//            .concatMapSingle {
//                fifaManager.requestMatchInfo(it)
//            }
//            .toList()
//            .observeOn(Schedulers.io())
//            .subscribe({
//                _matchDTOList.postValue(it as ArrayList<MatchMetaDataResult>)
//            },{
//                Log.e("cyc", "각각의 커피 정보 실패 ${it}")
//            })
//            .addTo(disposable)
//    }


}

//class MainViewModel : ViewModel() {
//
//    private var maxProtein: Int = 0
//    private var maxFat: Int = 0
//    private var maxSugar: Int = 0
//    val filterData = FilterData()
//    val rangeFilterData = FilterData()
//    var searchFiltData = String()
//
//    // 사용자의 단백질 필터 값
//    fun updatedProtein(startProtein: Int, endProtein: Int) {
//        filterData.startProtein = startProtein
//        filterData.endProtein = endProtein
//    }
//
//    // 사용자의 지방 필터 값
//    fun updatedFat(startFat: Int, endFat: Int) {
//        filterData.startFat = startFat
//        filterData.endFat = endFat
//    }
//
//    // 사용자의 설탕 필터 값
//    fun updatedSugar(startSugar: Int, endSugar: Int) {
//        filterData.startSugar = startSugar
//        filterData.endSugar = endSugar
//    }
//
//    // 최대 단백질 값 찾기
//    fun updatedMaxPro(protein: Double) {
//        if (protein.toInt() >= maxProtein) {
//            maxProtein = protein.toInt()
//            filterData.endProtein = protein.toInt()
//            rangeFilterData.endProtein = protein.toInt()
//        }
//    }
//
//    // 최대 지방 값 찾기
//    fun updatedMaxFat(fat: Double) {
//        if (fat.toInt() >= maxFat) {
//            maxFat = fat.toInt()
//            filterData.endFat = fat.toInt()
//            rangeFilterData.endFat = fat.toInt()
//        }
//    }
//
//    //최대 설탕 값 찾기
//    fun updatedMaxSugar(sugar: Double) {
//        if (sugar.toInt() >= maxSugar) {
//            maxSugar = sugar.toInt()
//            filterData.endSugar = sugar.toInt()
//            rangeFilterData.endSugar = sugar.toInt()
//        }
//    }
//
//    //초기화
//    fun initFiltData() {
//        filterData.startProtein = 0
//        filterData.startFat = 0
//        filterData.startSugar = 0
//        filterData.endProtein = maxProtein
//        filterData.endFat = maxFat
//        filterData.endSugar = maxSugar
//        filterData.sort = 0
//        filterData.checkCafein = false
//    }
//
//    //저칼로리 정렬
//    fun lowSort(check: Boolean) {
//        if (check) {
//            filterData.sort = -1
//        }
//    }
//
//    //기본로리 정렬
//    fun baseSort(check: Boolean) {
//        if (check) {
//            filterData.sort = 0
//        }
//    }
//
//    //고칼로리 정렬
//    fun highSort(check: Boolean) {
//        if (check) {
//            filterData.sort = 1
//        }
//    }
//
//    fun cafeinCheck(check: Boolean) {
//        filterData.checkCafein = check
//    }
//
//    fun searchStr(str: String) {
//        searchFiltData = str
//    }
//}

