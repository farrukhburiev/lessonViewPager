package com.example.lessonviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lessonviewpager.adapter.RecycleItemProductAdapter
import com.example.lessonviewpager.databinding.FragmentProducItemBinding
import com.example.lessonviewpager.model.Product

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProducItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProducItemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var list = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProducItemBinding.inflate(inflater,container,false)
        list.add(Product("Iphone1",R.drawable.iphone,"Iphone"))
        list.add(Product("Iphone2",R.drawable.iphone,"Iphone"))
        list.add(Product("Iphone3",R.drawable.iphone,"Iphone"))
        list.add(Product("Samsung1",R.drawable.samsung,"Samsung"))
        list.add(Product("Samsung2",R.drawable.samsung,"Samsung"))
        list.add(Product("Samsung3",R.drawable.samsung,"Samsung"))
        list.add(Product("Artel1",R.drawable.artel,"Artel"))
        list.add(Product("Artel2",R.drawable.artel,"Artel"))
        list.add(Product("Artel3",R.drawable.artel,"Artel"))

        var selected = mutableListOf<Product>()


        for (i in list){
            if (param1 == i.type){
                selected.add(i)
            }
        }

        if (param1 == "All"){
            selected = list
        }

        val adapter = RecycleItemProductAdapter(selected)
        var layoutmManager = GridLayoutManager(requireContext(),2,LinearLayoutManager.VERTICAL,false)

        binding.itemProductRecycle.layoutManager = layoutmManager
        binding.itemProductRecycle.adapter = adapter

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProducItemFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ProducItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}