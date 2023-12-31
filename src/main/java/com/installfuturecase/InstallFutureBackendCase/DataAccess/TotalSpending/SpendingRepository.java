package com.installfuturecase.InstallFutureBackendCase.DataAccess.TotalSpending;
import com.installfuturecase.InstallFutureBackendCase.Entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingRepository extends JpaRepository<Transactions, Long> {

    @Query("SELECT SUM(t.transactionamount) FROM transactions t WHERE t.username = ?1")
    int getTotalSpendingByUsername(String username);
}
