package xyz.metahash.apps.bscscan.tests

import org.hamcrest.MatcherAssert
import org.junit.Test
import xyz.metahash.apps.bscscan.BuildConfig.API_KEY
import xyz.metahash.apps.bscscan.getRetrofit
import xyz.metahash.apps.bscscan.sleep
import xyz.metahash.chains.bsc.bscscan.services.TransactionService

class TransactionServiceTest {
    private val service by lazy {
        getRetrofit().create(TransactionService::class.java)
    }
    @Test
    fun transactionServiceTest_getTransactionReceiptStatus() {
        val testObserver = service.getTransactionReceiptStatus(
            txHash = "0xe9975702518c79caf81d5da65dea689dcac701fcdd063f848d4f03c85392fd00"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                MatcherAssert.assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
}