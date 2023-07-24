package com.installfuturecase.InstallFutureBackendCase.DataAccess.TransactionCalculationRepository;
import com.installfuturecase.InstallFutureBackendCase.Entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

    @Query("SELECT SUM(t.transactionamount) FROM transactions t WHERE t.transactiondate BETWEEN :startDate AND :endDate")
    int sumTransactionAmountByTransactionDateBetween(LocalDate startDate, LocalDate endDate);
}
