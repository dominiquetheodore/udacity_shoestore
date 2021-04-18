package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.ChildBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {
    private val viewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_shoe_list, container, false)

        var names: String = ""
        val layout =  binding.childLayout

        viewModel.shoeList.observe(this.viewLifecycleOwner, Observer { shoeReceived ->  if(shoeReceived != null){
            shoeReceived.forEach{
                val child = DataBindingUtil.inflate<ChildBinding>(
                        inflater, R.layout.child, container,false)
                child.shoe = it
                Log.i("shoeList", "received " + it.name)
                layout.addView(child.root)
            }
        }
        else {
            Log.i("shoeList", "nill")
        }})

        binding.shoedetailBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.shoeDetailFragment, null));

        // Log.i("shoeList", "Model is of type " + viewModel.shoeList.javaClass.name)
        // Log.i("shoeList", "First element is " + viewModel.shoeList.value!!.get(0).name.toString())

        return binding.root
    }
}