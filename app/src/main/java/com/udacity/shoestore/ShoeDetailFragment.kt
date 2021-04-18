package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.databinding.ChildBinding
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    private val shoeViewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false)
        binding.viewModel = shoeViewModel
        binding.lifecycleOwner = this
        binding.cancelBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.shoeListFragment, null));

        binding.saveBtn.setOnClickListener {
            var shoe = shoeViewModel.shoe.value
            shoeViewModel.addShoe(shoe)
            Toast.makeText(this.activity, "Added a shoe!", Toast.LENGTH_SHORT).show()
            shoeViewModel.shoe.value = Shoe("",0.0,"", "")

            it.findNavController().navigateUp()


        }

        return binding.root
    }
}