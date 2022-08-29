package edu.seoul42.doitmission09

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat

class CustomerInfoFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_customer_info, container, false)
        val birthButton = rootView.findViewById<Button>(R.id.birth_button)

        birthButton.setOnClickListener {
            val selectedDate = Calendar.getInstance()
            val year = { selectedDate.get(Calendar.YEAR) }
            val month = { selectedDate.get(Calendar.MONTH) }
            val day = { selectedDate.get(Calendar.DAY_OF_MONTH) }

            val datePickerListener = { view : DatePicker , year : Int, monthOfYear : Int, dayOfMonth : Int ->
                selectedDate.set(year, monthOfYear, dayOfMonth)
                birthButton.text = SimpleDateFormat("yyyy.MM.dd").format(selectedDate.time)

            }
            DatePickerDialog(requireContext(), datePickerListener, year(), month(), day()).show()
        }

        val saveButton = rootView.findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            val name = rootView.findViewById<EditText>(R.id.name)
            val age = rootView.findViewById<EditText>(R.id.age)
            val message = "${getString(R.string.message_save)} ${name.text} / ${age.text}${getString(R.string.age_unit)} / ${birthButton.text}"

            Toast.makeText(activity?.applicationContext, message, Toast.LENGTH_SHORT).show()
        }
        return rootView
    }
}