package xyz.metahash.apps.bscscan.tests

import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import xyz.metahash.apps.bscscan.BuildConfig.API_KEY
import xyz.metahash.apps.bscscan.getRetrofit
import xyz.metahash.apps.bscscan.sleep
import xyz.metahash.chains.bsc.bscscan.services.AccountService

class AccountServiceTest {
    private val service by lazy {
        getRetrofit().create(AccountService::class.java)
    }
    @Test
    fun accountServiceTest_getAddressBalance() {
        val testObserver = service.getBalance(
            address = "0x0000000000000000000000000000000000001004"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getAddressBalanceMulti() {
        val address = arrayOf(
            "0x0000000000000000000000000000000000001004"
            , "0x0000000000000000000000000000000000001000"
            , "0xbb4cdb9cbd36b01bd1cbaebf2de08d9173bc095c"
        )
        val testObserver = service.getBalanceMulti(
            address = address
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Response size: ${it.result.size}", it.result.size == address.size)
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getTransactions() {
        val testObserver = service.getTransactionsByAddress(
            address = "0x0000000000000000000000000000000000001004"
            , startBlock = "4100"
            , endBlock = "4104"
            , apiKey = API_KEY
        ).test()

        testObserver.awaitTerminalEvent()

        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })

        sleep()
    }
    @Test
    fun accountServiceTest_getInternalTransactions() {
        val testObserver = service.getInternalTransactionsByAddress(
            address = "0x0000000000000000000000000000000000001004"
            , startBlock = "0"
            , endBlock = "270257"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getInternalTransactionsByHash() {
        val testObserver = service.getInternalTransactionsByHash(
            txHash = "0x4d74a6fc84d57f18b8e1dfa07ee517c4feb296d16a8353ee41adc03669982028"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getInternalTransactionsByBlockRange() {
        val testObserver = service.getInternalTransactionsByBlockRange(
            startBlock = "0"
            , endBlock = "270257"
            , page = "1"
            , offset = "10"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getBep20TokenTransferEventsByAddress() {
        val testObserver = service.getBep20TokenTransferEventsByAddress(
            address = "0x7bb89460599dbf32ee3aa50798bbceae2a5f7f6a"
            , startBlock = "0"
            , endBlock = "2500000"
            , page = "1"
            , offset = "10"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getBep20TokenTransferEventsByContractAddress() {
        val testObserver = service.getBep20TokenTransferEventsByContractAddress(
            contractAddress = "0xc9849e6fdb743d08faee3e34dd2d1bc69ea11a51"
            , page = "1"
            , offset = "10"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getBep20TokenTransferEvents() {
        val testObserver = service.getBep20TokenTransferEvents(
            address = "0x7bb89460599dbf32ee3aa50798bbceae2a5f7f6a"
            , contractAddress = "0xc9849e6fdb743d08faee3e34dd2d1bc69ea11a51"
            , page = "1"
            , offset = "10"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getErc721TokenTransferEventsByAddress() {
        val testObserver = service.getErc721TokenTransferEventsByAddress(
            address = "0xcd4ee0a77e09afa8d5a6518f7cf8539bef684e6c"
            , startBlock = "0"
            , endBlock = "999999999"
            , page = "1"
            , offset = "10"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getErc721TokenTransferEventsByContractAddress() {
        val testObserver = service.getErc721TokenTransferEventsByContractAddress(
            contractAddress = "0x5e74094cd416f55179dbd0e45b1a8ed030e396a1"
            , page = "1"
            , offset = "100"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getErc721TokenTransferEvents() {
        val testObserver = service.getErc721TokenTransferEvents(
            address = "0xcd4ee0a77e09afa8d5a6518f7cf8539bef684e6c"
            , contractAddress = "0x5e74094cd416f55179dbd0e45b1a8ed030e396a1"
            , page = "1"
            , offset = "100"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun accountServiceTest_getBlocksValidatedByAddress() {
        val testObserver = service.getBlocksValidatedByAddress(
            address = "0x78f3adfc719c99674c072166708589033e2d9afe"
            , page = "1"
            , offset = "100"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
}
