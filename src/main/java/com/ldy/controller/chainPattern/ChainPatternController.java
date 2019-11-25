package com.ldy.controller.chainPattern;


import com.ldy.common.pattern.chainPattern.p_2.BorrowRequest;
import com.ldy.common.pattern.chainPattern.p_2.InitBorrowChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chain")
public class ChainPatternController {

    @Autowired
    private InitBorrowChain initBorrowChain;

    @GetMapping("/{money}")
    public String borrowMoney(@PathVariable("money") int money) {
        BorrowRequest borrowRequest = new BorrowRequest(money);
        initBorrowChain.dealBorrowRequest(borrowRequest);
        return "Success";
    }
}
