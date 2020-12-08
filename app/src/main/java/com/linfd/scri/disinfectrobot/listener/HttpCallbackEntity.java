package com.linfd.scri.disinfectrobot.listener;

import okhttp3.Response;

public interface HttpCallbackEntity <T>{
      void onSuccess( T t);
      void onFailure(String errmsg);
}
