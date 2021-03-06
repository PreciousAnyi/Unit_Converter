package com.project.unitconverter.fragments

import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.project.unitconverter.R
import soup.neumorphism.NeumorphButton
import soup.neumorphism.NeumorphCardView


class UnitConverterFragment : Fragment(), OnClickListener {
    private  var keyValues = SparseArray<String>()
    lateinit var meterEditText : EditText
    lateinit var footTextView : TextView
    var code = StringBuilder()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //linking fragments to the views

        val button1 : NeumorphButton = view.findViewById(R.id.button1)
        val button2 : NeumorphButton = view.findViewById(R.id.button2)
        val button3 : NeumorphButton = view.findViewById(R.id.button3)
        val button4 : NeumorphButton = view.findViewById(R.id.button4)
        val button5 : NeumorphButton = view.findViewById(R.id.button5)
        val button6 : NeumorphButton = view.findViewById(R.id.button6)
        val button7 : NeumorphButton = view.findViewById(R.id.button7)
        val button8 : NeumorphButton = view.findViewById(R.id.button8)
        val button9 : NeumorphButton = view.findViewById(R.id.button9)
        val button0 : NeumorphButton = view.findViewById(R.id.button0)
        val button00 : NeumorphButton = view.findViewById(R.id.button00)
        val dotButton : NeumorphCardView = view.findViewById(R.id.buttonDot)
        val convertButton : NeumorphButton = view.findViewById(R.id.convertButton)
        val clearButton : NeumorphCardView = view.findViewById(R.id.clearButton)
        val deleteButton : NeumorphCardView = view.findViewById(R.id.deleteButton)

        //assigning meterEditText and footTextView
        meterEditText = view.findViewById(R.id.meterEditText)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            meterEditText.showSoftInputOnFocus = false
        }

        footTextView = view.findViewById(R.id.footTextView)

        //setting onClickListners for the buttons
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button0.setOnClickListener(this)
        button00.setOnClickListener(this)
        dotButton.setOnClickListener(this)


        //replacing buttons with number to display on editText when clicked
        keyValues.put(R.id.button0,"0")
        keyValues.put(R.id.button00,"00")
        keyValues.put(R.id.button1,"1")
        keyValues.put(R.id.button2,"2")
        keyValues.put(R.id.button3,"3")
        keyValues.put(R.id.button4,"4")
        keyValues.put(R.id.button5,"5")
        keyValues.put(R.id.button6,"6")
        keyValues.put(R.id.button7,"7")
        keyValues.put(R.id.button8,"8")
        keyValues.put(R.id.button9,"9")


        //clear all button
        clearButton.setOnClickListener{
            footTextView.text = ""
            meterEditText.text.clear()
        }

        //delete button
        deleteButton.setOnClickListener{
            var length: Int = meterEditText.text?.length ?: 0

            if (length>0 ){
                meterEditText.text?.delete(length-1,length)


                code.deleteCharAt(length-1)

            }

        }

        //convert button
        convertButton.setOnClickListener{
           footTextView.text = convertMeter(code.toString()).toString()
        }
    }


    //function to convert
    private fun convertMeter(string: String): Double {
        val meterValue = string.toDouble().toInt()
        val feetValue = 3.2808399
        return meterValue * feetValue

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_unit_converter, container, false)
    }

    override fun onClick(p0: View?) {
        var value:String = keyValues.get(p0!!.id)


        if (code.length <10 ){
            code.append(value)
            meterEditText.setText(code)
        } else{
            Toast.makeText(activity,"Numbers Exceed Maximum of 10 Characters",Toast.LENGTH_SHORT).show()
        }

    }


}