package com.rotcline.rjoi.orders.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rotcline.rjoi.R
import com.rotcline.rjoi.SharedPreferencesWrapper
import com.rotcline.rjoi.orders.data.Menu
import com.rotcline.rjoi.orders.domain.FoodMapper
import kotlinx.android.synthetic.main.fragment_new_order.*
import kotlinx.android.synthetic.main.main_fragment_container.*


class FragmentNewOrder :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val menu= Menu()
        val sharedPref= SharedPreferencesWrapper(requireContext())

        btn_checkout.setOnClickListener {

            val foodMapper= FoodMapper()
            val confirmOrder= foodMapper.toOrder(menu.itemsOnBasket)
            val totalOrder=foodMapper.total(menu.itemsOnBasket)

            if(confirmOrder.isEmpty())
                Toast.makeText(requireContext(), "Nothing in the order", Toast.LENGTH_SHORT).show()
            else
                parentFragmentManager.commit {
                    hide(this@FragmentNewOrder)
                    add(R.id.main_fragment_container,FragmentConfirmOrder(confirmOrder,totalOrder) )
                    addToBackStack("")
                }


        }

        btn_remove.setOnClickListener {
            sharedPref.deleteNotes()
            (rv_items.adapter as FoodAdapter).apply {

                menu.newList()
                setNewList(menu.itemsOnBasket)
                notifyDataSetChanged()

            }
            Unit

        }

        rv_items.apply {
            layoutManager= LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter= FoodAdapter(
                {},
                menu.itemsOnBasket
            )
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }

    }
    override fun onResume() {
        super.onResume()
        val icon = requireActivity().findViewById<ImageButton>(R.id.btn_bar)
        icon.setOnClickListener {
            Toast.makeText(requireContext(), "Menu", Toast.LENGTH_SHORT).show()
        }
    }
}