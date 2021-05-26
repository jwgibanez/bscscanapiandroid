package xyz.metahash.chains.bsc.bscscan.services

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.metahash.chains.bsc.bscscan.constants.Module
import xyz.metahash.chains.bsc.bscscan.constants.StatsAction
import xyz.metahash.chains.bsc.bscscan.constants.Tag
import xyz.metahash.chains.bsc.bscscan.models.Response

interface TokenService {
    @GET("api")
    fun getBep20TotalSupply(
        @Query("module") module: String = Module.STATS,
        @Query("action") action: String = StatsAction.TOKENSUPPLY,
        @Query("contractaddress") contractAddress: String,
        @Query("apikey") apiKey: String
    ) : Observable<Response<String>>
    @GET("api")
    fun getBep20CirculatingSupply(
        @Query("module") module: String = Module.STATS,
        @Query("action") action: String = StatsAction.TOKENCSUPPLY,
        @Query("contractaddress") contractAddress: String,
        @Query("apikey") apiKey: String
    ) : Observable<Response<String>>
    @GET("api")
    fun getBep20Balance(
        @Query("module") module: String = Module.STATS,
        @Query("action") action: String = StatsAction.TOKENCSUPPLY,
        @Query("contractaddress") contractAddress: String,
        @Query("address") address: String,
        @Query("tag") tag: String = Tag.LATEST,
        @Query("apikey") apiKey: String
    ) : Observable<Response<String>>
}