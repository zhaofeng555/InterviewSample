package com.haojg.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;

public class BankTran {

    TransactionTemplate transactionTemplate;
    JdbcTemplate jdbcTemplate;

    public void pay(){


        // 设置事务的传播行为,默认是PROPAGATION_REQUIRED,也可使用默认值
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        // 设置事务的隔离级别,默认是ISOLATION_DEFAULT:使用的是底层数据库的默认的隔离级别,也可使用默认值
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        // 设置是否只读，默认是false,也可使用默认值
        transactionTemplate.setReadOnly(true);
        // 默认使用的是数据库底层的默认的事务的超时时间,也可使用默认值
        transactionTemplate.setTimeout(30000);

        List<Map<String, Object>> userList = transactionTemplate
                .execute(new TransactionCallback<List<Map<String, Object>>>() {
                    @Override
                    public List<Map<String, Object>> doInTransaction(TransactionStatus status) {
                        return jdbcTemplate.queryForList("select * from sym_t_user");
                    }

                });
        System.out.println(userList);

    }

}
