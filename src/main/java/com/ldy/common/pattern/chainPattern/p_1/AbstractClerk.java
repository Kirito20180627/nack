package com.ldy.common.pattern.chainPattern.p_1;

public abstract class AbstractClerk {

    private AbstractClerk superior;

    protected String type;

    public void setSuperior(AbstractClerk superior) {
        this.superior = superior;
    }

    public void approveRequest(Client client) {
        if (client.getRequestMoney() > getAllMoney()) {
            if (this.superior != null) {
                this.superior.approveRequest(client);
            } else {
                System.out.println("nobody can borrow money!");
            }
        } else {

            System.out.println(getType() + " agree with request, borrow " + client.getRequestMoney());
        }

    }

    public abstract int getAllMoney();
    public String getType() {
        return type;
    }


}
