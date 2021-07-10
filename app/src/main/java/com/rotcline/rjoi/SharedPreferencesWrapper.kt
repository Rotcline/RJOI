package com.rotcline.rjoi

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesWrapper(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "OrderSpec", Context.MODE_PRIVATE)

    fun deleteNotes(){
        sharedPreferences.edit().clear().apply()
    }

    fun giveNote():String =
        sharedPreferences.getString("OrderDetails","")?: ""

    fun setNote(note:String){
        sharedPreferences.edit().putString("OrderDetails",note).apply()
    }

}