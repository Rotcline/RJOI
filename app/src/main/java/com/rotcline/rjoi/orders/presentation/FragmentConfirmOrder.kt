package com.rotcline.rjoi.orders.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rotcline.rjoi.R
import com.rotcline.rjoi.SharedPreferencesWrapper
import com.rotcline.rjoi.orders.data.InfernalBase
import kotlinx.android.synthetic.main.fragment_confirm.*
import kotlin.math.roundToInt

class FragmentConfirmOrder(val confirmList:ArrayList<String>, val total:Double) :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val fb= InfernalBase()

        val sharedPref= SharedPreferencesWrapper(requireContext())

        btn_decline.setOnClickListener{
            parentFragmentManager.popBackStackImmediate()
        }

        tv_total.setText("TOTAL $ ${total.roundToInt()}")

        btn_confirm.setOnClickListener{btn->

            btn.isEnabled=false
            btn_decline.isEnabled=false

            fb.sendOrder(confirmList,total.roundToInt().toString(),sharedPref.giveNote()) {

                btn.isEnabled=true
                if(it) {

                    Toast.makeText(requireContext(), "Order Taken", Toast.LENGTH_SHORT).show()
                    sharedPref.deleteNotes()
                    parentFragmentManager.commit {
                        replace(R.id.main_fragment_container,FragmentOrders())
                    }

                }
                else
                    Toast.makeText(requireContext(), "Couldn´t take the order", Toast.LENGTH_SHORT).show()

            }

        }

        rv_confirm.apply {

            layoutManager= LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL,
                false)

            adapter= ConfirmAdapter(confirmList)
            addItemDecoration(
                DividerItemDecoration(requireContext(),
                    DividerItemDecoration.VERTICAL)
            )

        }
    }
}