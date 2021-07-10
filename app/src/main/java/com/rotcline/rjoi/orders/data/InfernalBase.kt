package com.rotcline.rjoi.orders.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class InfernalBase {

    fun sendOrder(list:List<String>, total: String, notes: String, sendOrderCallback:(Boolean)->Unit,){

        val foodMap = mutableMapOf<String,String>()
        list.forEach {
            foodMap.put(it,it)
        }

        foodMap.put("note", notes)
        foodMap.put("total", total)

        val firebaseDb = FirebaseFirestore.getInstance()

        firebaseDb.collection("Orders").add(foodMap)
            .addOnSuccessListener{

                Log.i("Testing", "Success")
                sendOrderCallback(true)

            }.addOnFailureListener {

                Log.i("Testing", "Error ${it.message}")
                sendOrderCallback(false)

            }
    }
}