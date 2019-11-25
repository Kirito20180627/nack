package com.ldy.common.pattern.chainPattern.p_2;

public abstract class AbstractClerk {

    private AbstractClerk superior;

    protected String type;


    public void setSuperior(AbstractClerk superior) {
        this.superior = superior;
    }

    public void approveRequest(BorrowRequest borrowRequest) {
        if (borrowRequest.getRequestMoney() > getAllMoney()) {
            if (this.superior != null) {
                this.superior.approveRequest(borrowRequest);
            } else {
                System.out.println("nobody can borrow " + borrowRequest.getRequestMoney()+ " money");
            }
        } else {
            System.out.println(getType() + " agree with request, borrow " + borrowRequest.getRequestMoney());
        }

    }

    public abstract int getAllMoney();
    public String getType() {
        return type;
    }
}
