package xyz.metahash.chains.bsc.bscscan.services

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.metahash.chains.bsc.bscscan.constants.Module
import xyz.metahash.chains.bsc.bscscan.constants.TransactionAction
import xyz.metahash.chains.bsc.bscscan.models.Response
import xyz.metahash.chains.bsc.bscscan.models.Status

interface TransactionService {
    @GET("api")
    fun getTransactionReceiptStatus(
        @Query("module") module: String = Module.TRANSACTION,
        @Query("action") action: String = TransactionAction.GETTXRECEIPTSTATUS,
        @Query("txhash") txHash: String,
        @Query("apikey") apiKey: String
    ) : Observable<Response<Status>>
}