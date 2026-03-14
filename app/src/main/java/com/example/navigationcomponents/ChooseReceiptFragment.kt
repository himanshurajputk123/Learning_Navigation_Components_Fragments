package com.example.navigationcomponents

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class ChooseReceiptFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController
    private lateinit var editTextRecipient: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_receipt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        view.findViewById<Button>(R.id.btn_next_recipient).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_cancel_recipient).setOnClickListener(this)
        editTextRecipient = view.findViewById(R.id.edit_recipient_name)
    }

    override fun onClick(view: View?) {
        when(view?.id){

            R.id.btn_next_recipient -> {
                if(!TextUtils.isEmpty(editTextRecipient.text.toString())){
                    val bundle = Bundle()
                    bundle.putString("recipient", editTextRecipient.text.toString())
                    navController
                        .navigate(R.id.action_chooseReceiptFragment_to_specifyAmountFragment,
                        bundle)
                }
            }
            R.id.btn_cancel_recipient -> navController.popBackStack()
        }
    }
}