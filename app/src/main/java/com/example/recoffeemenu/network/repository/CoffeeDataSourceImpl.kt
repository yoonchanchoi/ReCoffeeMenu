package com.example.recoffeemenu.network.repository

import io.reactivex.Single
import javax.inject.Inject

//class CoffeeDataSourceImpl @Inject constructor(
//    @NetworkProviderModule.FifaRetrofit private val service: FIFAService
//) : CoffeeDataSource {
//
//    override fun requestUserInfo(nickname: String): Single<UserInfoResult> =
//        service.requestUserInfo(nickname)
//
//    override fun requestOfficialMatchId(accessId: String): Single<ArrayList<String>> =
//        service.requestOfficialMatchId(accessId, matchType = 50, offset = 0, limit = 20)
//
//    override fun requestMatchInfo(matchId: String): Single<MatchMetaDataResult> =
//        service.requestMatchInfo(matchId)
//
//    override fun requestMaxDivision(accessId: String) : Single<ArrayList<MaxDivisionResult>> =
//        service.requestMaxDivision(accessId)
//}