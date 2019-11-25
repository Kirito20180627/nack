package com.ldy.common.pattern.chainPattern.p_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Configuration
public class InitBorrowChain {

    @Autowired
    private List<AbstractClerk> clerks;

    @PostConstruct
    private void initChain() {
//         Collections.sort(clerks, AnnotationAwareOrderComparator.INSTANCE);
        clerks.sort(AnnotationAwareOrderComparator.INSTANCE);
        clerks.forEach(clerk->{
            System.out.println(clerk.type);
        });
        System.out.println(clerks.toString());
        int size = clerks.size();
        for (int i = 0 ; i < size ; i++) {
            if (i +1 == size) {
                clerks.get(i).setSuperior(null);
            } else {
                clerks.get(i).setSuperior(clerks.get(i+1));
            }
        }
    }

    public void dealBorrowRequest(BorrowRequest requestMoney) {
        initChain();
        clerks.get(0).approveRequest(requestMoney);
    }

}
