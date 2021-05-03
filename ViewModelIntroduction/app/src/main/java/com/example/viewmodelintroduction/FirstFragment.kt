package com.example.viewmodelintroduction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelintroduction.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var viewModel: FirstViewModel
    private lateinit var binding:FragmentFirstBinding
//    private var clicks = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Set the value of the view model
        // Inflate the layout for this fragment
/*
        viewModel= FirstViewModel()
*/
        //This is the correct way to create a view model
        viewModel = ViewModelProvider(this)
                .get(FirstViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)

        // Click Listeners
        binding.button1.setOnClickListener{
            hello()
        }
        binding.button2.setOnClickListener{
            goodbye()
        }
        updateUI()

        return binding.root
    }/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }*/

    //These are the old versions that don't use View Model
    /*private fun hello () {
        val name = binding.editText1.text.toString()
        ++clicks
        binding.text1.text = "Hello, $name !"
        binding.textView2.text = "Number of clicks: $clicks"
    }
    private fun goodbye () {
        val name = binding.editText1.text.toString()
        ++clicks
        binding.text1.text = "Goodbye, $name !"
        binding.textView2.text = "Number of clicks: $clicks"
    }*/

    private fun hello(){
        val name = binding.editText1.text.toString()
        viewModel.message = "Hello, $name !"
        viewModel.clicks++
        updateUI()
    }
    private fun goodbye(){
        val name = binding.editText1.text.toString()
        viewModel.message = "Goodbye, $name !"
        viewModel.clicks++
        updateUI()
    }
    private fun updateUI(){
        binding.text1.text = viewModel.message
        binding.textView2.text = "Number of clicks: ${viewModel.clicks}"
    }

}