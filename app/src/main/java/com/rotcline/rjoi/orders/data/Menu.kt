package com.rotcline.rjoi.orders.data

class Menu {

    lateinit var list: List<Food>

    val itemsOnBasket= listOf<Food>(
        Food("Pizza de Peperoni"),
        Food("Pizza de Tocino"),
        Food("Pizza de Boneless"),
        Food("Pizza de Champiñones"),
        Food("Pizza de Picsa"),
        Food("Alitas"),
        Food("Boneless"),
        Food("Refresco"),
        Food("Cerveza")
    )

    fun newList(){

        itemsOnBasket.forEach {
            it.quantity = 0
        }

    }

}