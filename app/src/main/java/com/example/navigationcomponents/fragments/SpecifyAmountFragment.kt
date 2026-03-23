package com.example.navigationcomponents.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationcomponents.R
import com.example.navigationcomponents.model.Money
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController
    private lateinit var editTextAmount: EditText
    private var recipient: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient", "None") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_confirm_amount).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_cancel_amount).setOnClickListener(this)
        val message = "Sending money to $recipient"
        view.findViewById<TextView>(R.id.textView).text = message
        editTextAmount = view.findViewById(R.id.edit_specify_amount)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_confirm_amount -> {
                if(!TextUtils.isEmpty(editTextAmount.text.toString())) {
                    val amount = Money(BigDecimal(editTextAmount.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    navController.navigate(
                        R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle
                    )
                }
            }
            R.id.btn_cancel_amount -> navController.popBackStack()
        }
    }
}