package com.ldy.service;

import java.util.concurrent.Future;

public interface IAsyncTaskService {
    Future<String> dealHaveReturnTask();
}
