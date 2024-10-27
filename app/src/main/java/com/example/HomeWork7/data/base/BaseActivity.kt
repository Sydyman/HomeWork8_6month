package com.example.HomeWork7.data.base
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.example.HomeWork7.utils.Resource
import com.example.HomeWork7.utils.showToast

abstract class BaseActivity:AppCompatActivity() {
    fun <T> LiveData<Resource<T>>.stateHandler(
        success: (data: T) -> Unit,
        state: ((res: Resource<T>) -> Unit) ?= null,
    ){
        observe(this@BaseActivity){res->
            state?.invoke(res)
            when(res){
                is Resource.Error -> {
                    this@BaseActivity.showToast(res.message!!)
                    Log.e("ololo", "stateHandler: ${res.message}", )
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    if (res.data != null){
                        success(res.data)
                    }
                }
            }
        }
    }
}