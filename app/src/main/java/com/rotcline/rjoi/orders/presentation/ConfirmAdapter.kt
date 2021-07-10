package com.rotcline.rjoi.orders.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rotcline.rjoi.R
import kotlinx.android.synthetic.main.fragment_confirm.view.*
import kotlinx.android.synthetic.main.row_confirm.view.*

class ConfirmAdapter(private val list: List<String>)
    : RecyclerView.Adapter<ConfirmAdapter.ConfirmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfirmViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.row_confirm,parent,false)
        return ConfirmViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ConfirmViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return if(list.isNullOrEmpty()) 0 else list.size
    }
    inner class ConfirmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(text:String){
            itemView.tv_confirm_row.text = text

        }
    }
}
