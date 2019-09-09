package com.ldy.common.pattern.templatePattern;

public interface CommonBizCallback<T> {
    /** 前置校验 */
    void beforeCheck();
    /*** 操作逻辑**/
    T doAction();
    /*** 后置操作*/
    void afterAction(T t);
    /**finally操作*/
    void finallyAction(T t);
}
