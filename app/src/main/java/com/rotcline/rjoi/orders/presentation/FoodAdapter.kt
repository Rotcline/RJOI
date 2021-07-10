package com.rotcline.rjoi.orders.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rotcline.rjoi.R
import com.rotcline.rjoi.orders.data.Food
import kotlinx.android.synthetic.main.row_item.view.*
import kotlinx.android.synthetic.main.row_item.view.tv_item_row
import kotlinx.android.synthetic.main.row_item.view.tv_no_items

class FoodAdapter(private val btnAddClickListener: (String) -> Unit,
                  private var basketItems: List<Food>)

    :RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int): FoodViewHolder =
        FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false))


    override fun onBindViewHolder(holder: FoodViewHolder,position:Int) {

        holder.bind(basketItems[position].name, basketItems[position].quantity)

    }

    override fun getItemCount(): Int =
        if(basketItems.isNullOrEmpty()) 0 else basketItems.size



    inner class FoodViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        fun bind(text:String, number:Int){
            itemView.tv_item_row.text = text

            itemView.btn_add.setOnClickListener{

                basketItems[adapterPosition].quantity += 1
                setFoodQuantity(basketItems[adapterPosition].quantity)

            }

            itemView.btn_sub.setOnClickListener{

                if(basketItems[adapterPosition].quantity>0) {
                    basketItems[adapterPosition].quantity -= 1
                    setFoodQuantity(basketItems[adapterPosition].quantity)
                }

            }
            setFoodQuantity(number)
        }

        fun setFoodQuantity(number:Int){
            itemView.tv_no_items.text = number.toString()
        }

    }

    fun setNewList(newList: List<Food>) {

        basketItems = newList

    }

}