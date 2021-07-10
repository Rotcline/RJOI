package com.rotcline.rjoi.orders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.commit
import com.rotcline.rjoi.R
import com.rotcline.rjoi.SharedPreferencesWrapper
import com.rotcline.rjoi.orders.presentation.FragmentNewOrder
import com.rotcline.rjoi.orders.presentation.FragmentOrders
import kotlinx.android.synthetic.main.main_fragment_container.*
import kotlinx.android.synthetic.main.dialog_specific_orders.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref=SharedPreferencesWrapper(this)
        sharedPref.deleteNotes()

        setContentView(R.layout.main_fragment_container)
        supportFragmentManager.commit {
            add(R.id.main_fragment_container, FragmentOrders())
        }


/*
        btn_bar.setOnClickListener{

            val dialogView = layoutInflater.inflate(R.layout.dialog_specific_orders,null)

            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .create()

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogView.et_dialog.setText(sharedPref.giveNote())

            dialogView.btn_confirm_dialog.setOnClickListener {

                var orderDetails = dialogView.et_dialog.getText()

                if(orderDetails.isNotEmpty())
                    sharedPref.setNote(orderDetails.toString())

                dialog.cancel()

            }

            dialogView.btn_back_dialog.setOnClickListener {
                dialog.cancel()
            }
            dialog.show()

        }

 */
    }

    override fun onBackPressed() {
        super.onBackPressed()

        supportFragmentManager.fragments
    }
}