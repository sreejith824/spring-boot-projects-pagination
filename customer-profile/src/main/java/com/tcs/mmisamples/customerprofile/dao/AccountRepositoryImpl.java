package com.tcs.mmisamples.customerprofile.dao;

import com.tcs.mmisamples.customerprofile.domain.Account;
import com.tcs.mmisamples.customerprofile.domain.AccountDetails;
import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AccountDetails> findAccountDetailsDynamicSearch(
            @Param(value = "name") Optional<String> name,
            @Param(value = "accountStatus") Optional<String> accountStatus,
            @Param(value = "accountType") Optional<String> accountType
    ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(AccountDetails.class);
        Root<Account> accountRoot = criteriaQuery.from(Account.class);

        Join<Account, CustomerProfile> accountCustomerProfileJoin = accountRoot.join("customerProfile", JoinType.INNER);

        List<Predicate> conditions = new ArrayList<>();
        if (!name.equals(Optional.empty())) {

            conditions.add(criteriaBuilder.equal(accountCustomerProfileJoin.get("name"), name.get()));
        }

        if(!accountStatus.equals(Optional.empty())) {

            conditions.add(criteriaBuilder.equal(accountRoot.get("accountStatus"), accountStatus.get()));
        }

        if(!accountType.equals(Optional.empty())) {

            conditions.add(criteriaBuilder.equal(accountRoot.get("accountType"), accountType.get()));
        }
        criteriaQuery.where(conditions.stream().toArray(Predicate[]::new));


        criteriaQuery.multiselect(accountCustomerProfileJoin.get("name"),
                accountCustomerProfileJoin.get("age"),
                accountCustomerProfileJoin.get("customerId"),
                accountRoot.get("accountId"),
                accountRoot.get("accountType"),
                accountRoot.get("accountStatus")
                );

        TypedQuery<AccountDetails> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }


}
