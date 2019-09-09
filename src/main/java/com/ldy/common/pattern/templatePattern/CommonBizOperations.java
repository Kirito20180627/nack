package com.ldy.common.pattern.templatePattern;

public interface CommonBizOperations {
    <T> BaseBizResult execute(CommonBizCallback<T> callback);
}
