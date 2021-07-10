package com.rotcline.rjoi.orders.presentation

import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.rotcline.rjoi.R
import com.rotcline.rjoi.orders.data.Account
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.dialog_new_check.view.*
import kotlinx.android.synthetic.main.dialog_specific_orders.view.*
import kotlinx.android.synthetic.main.row_orders.view.*

class CountItem(private val account: Account,
                private val fragmentReplace:()->Unit):Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.apply {

            itemView.tv_order.text = "Account ${account.accountNumber}"
            itemView.setOnClickListener {

                val dialogView = LayoutInflater.from(viewHolder.itemView.context).inflate(R.layout.dialog_new_check,null)

                val dialog = AlertDialog.Builder(viewHolder.itemView.context)
                    .setView(dialogView)
                    .create()

                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                dialogView.btn_new_order.setOnClickListener {
                    fragmentReplace()
                    dialog.cancel()
                }

                dialogView.btn_checkout.setOnClickListener {
                    //eliminar elemento
                }
                dialog.show()

            }
        }
    }

    override fun getLayout(): Int {
        return R.layout.row_orders
    }
}