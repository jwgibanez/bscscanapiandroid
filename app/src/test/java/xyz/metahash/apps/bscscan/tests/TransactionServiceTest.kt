package xyz.metahash.apps.bscscan.tests

import org.hamcrest.MatcherAssert
import org.junit.Test
import xyz.metahash.apps.bscscan.BuildConfig.API_KEY
import xyz.metahash.apps.bscscan.sleep
import xyz.metahash.chains.bsc.bscscan.di.BscScanApiImpl

class TransactionServiceTest: BscScanApiImpl() {
    @Test
    fun transactionServiceTest_getTransactionReceiptStatus() {
        val testObserver = transactionService.getTransactionReceiptStatus(
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