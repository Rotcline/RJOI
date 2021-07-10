package com.rotcline.rjoi.orders.domain

import com.rotcline.rjoi.orders.data.Food

class FoodMapper {

    fun toOrder(foodList:List<Food>):ArrayList<String>{

        val confirmArray = arrayListOf<String>()
        for(food in foodList) {
            if(food.quantity>0){
                confirmArray.add("${food.name} x${food.quantity}")
            }
        }
        return confirmArray

    }

    fun total(foodList: List<Food>):Double{

        var total = 0.0
        for(food in foodList) {
            if(food.quantity>0){
                total+=food.quantity*food.cost
            }
        }
        return total

    }

}