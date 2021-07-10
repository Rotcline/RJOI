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
import com.rotcline.rjoi.orders.data.Account
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_new_order.*
import kotlinx.android.synthetic.main.fragment_orders.*
import kotlinx.android.synthetic.main.main_fragment_container.*
import kotlinx.android.synthetic.main.row_orders.*

class FragmentOrders:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        btn_cut.setOnClickListener {

        }

        val adapter = GroupAdapter<GroupieViewHolder>()
        val list = listOf<Account>(
            Account("Juan",1,1.0),
            Account("Juan",2,2.0),
            Account("Juan",3,2.0),
            Account("Juan",4,2.0),
            Account("Juan",5,2.0),
            Account("Juan",6,2.0)
        )

        list.forEach {
            adapter.add(CountItem(it){
                parentFragmentManager.commit {
                    hide(this@FragmentOrders)
                    add(R.id.main_fragment_container,FragmentNewOrder())
                    addToBackStack("")
                }
            })
        }

        rv_orders.apply {
            layoutManager= LinearLayoutManager(requireContext())
            setAdapter(adapter)

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
            Toast.makeText(requireContext(), "Orders", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
    }
}