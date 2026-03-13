package com.example.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class MainFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_transactions_history).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_balance).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_send_money).setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_transactions_history -> navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
            R.id.btn_balance -> navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
            R.id.btn_send_money -> navController.navigate(R.id.action_mainFragment_to_chooseReceiptFragment)
        }

    }

}