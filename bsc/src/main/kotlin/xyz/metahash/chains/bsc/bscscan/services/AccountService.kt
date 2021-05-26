package xyz.metahash.chains.bsc.bscscan.services

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.metahash.chains.bsc.bscscan.constants.*
import xyz.metahash.chains.bsc.bscscan.models.Account
import xyz.metahash.chains.bsc.bscscan.models.Block
import xyz.metahash.chains.bsc.bscscan.models.Response
import xyz.metahash.chains.bsc.bscscan.models.Transaction

interface AccountService {
    @GET("api")
    fun getBalance(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.BALANCE,
        @Query("address") address: String,
        @Query("tag") tag: String = Tag.LATEST,
        @Query("apikey") apiKey: String
    ) : Observable<Response<String>>
    @GET("api")
    fun getBalanceMulti(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.BALANCEMULTI,
        @Query("address") address: Array<String>,
        @Query("tag") tag: String = Tag.LATEST,
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Account>>>
    @GET("api")
    fun getTransactionsByAddress(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TXLIST,
        @Query("address") address: String,
        @Query("startblock") startBlock: String?,
        @Query("endblock") endBlock: String?,
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getInternalTransactionsByAddress(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TXLISTINTERNAL,
        @Query("txhash") txHash: String = "",
        @Query("address") address: String = "",
        @Query("startblock") startBlock: String = "",
        @Query("endblock") endBlock: String = "",
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getInternalTransactionsByHash(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TXLISTINTERNAL,
        @Query("txhash") txHash: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getInternalTransactionsByBlockRange(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TXLISTINTERNAL,
        @Query("startblock") startBlock: String = "",
        @Query("endblock") endBlock: String = "",
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getBep20TokenTransferEventsByAddress(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TOKENTX,
        @Query("address") address: String,
        @Query("startblock") startBlock: String = "",
        @Query("endblock") endBlock: String = "",
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getBep20TokenTransferEventsByContractAddress(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TOKENTX,
        @Query("contractaddress") contractAddress: String,
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getBep20TokenTransferEvents(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TOKENTX,
        @Query("address") address: String,
        @Query("contractaddress") contractAddress: String,
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getErc721TokenTransferEventsByAddress(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TOKENNFTTX,
        @Query("address") address: String,
        @Query("startblock") startBlock: String = "",
        @Query("endblock") endBlock: String = "",
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getErc721TokenTransferEventsByContractAddress(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TOKENNFTTX,
        @Query("contractaddress") contractAddress: String,
        @Query("startblock") startBlock: String = "",
        @Query("endblock") endBlock: String = "",
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getErc721TokenTransferEvents(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.TOKENNFTTX,
        @Query("address") address: String,
        @Query("contractaddress") contractAddress: String,
        @Query("sort") sort: String = Sort.ASC,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Transaction>>>
    @GET("api")
    fun getBlocksValidatedByAddress(
        @Query("module") module: String = Module.ACCOUNT,
        @Query("action") action: String = AccountAction.GETMINEDBLOCKS,
        @Query("address") address: String,
        @Query("blocktype") sort: String = BlockType.BLOCKS,
        @Query("page") page: String = "",
        @Query("offset") offset: String = "",
        @Query("apikey") apiKey: String
    ) : Observable<Response<List<Block>>>
}